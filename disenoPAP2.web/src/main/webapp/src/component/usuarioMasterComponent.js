define(['controller/selectionController', 'model/cacheModel', 'model/usuarioMasterModel', 'component/_CRUDComponent', 'controller/tabController', 'component/usuarioComponent',
 'component/trabajoComponent'
 
 ],function(SelectionController, CacheModel, UsuarioMasterModel, CRUDComponent, TabController, UsuarioComponent,
 trabajoComponent
 ) {
    App.Component.UsuarioMasterComponent = App.Component.BasicComponent.extend({
        initialize: function() {
            var self = this;
            this.configuration = App.Utils.loadComponentConfiguration('usuarioMaster');
            var uComponent = new UsuarioComponent();
            uComponent.initialize();
            uComponent.render('main');
            Backbone.on(uComponent.componentId + '-post-usuario-create', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-post-usuario-edit', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-pre-usuario-list', function() {
                self.hideChilds();
            });
            Backbone.on('usuario-master-model-error', function(error) {
                Backbone.trigger(uComponent.componentId + '-' + 'error', {event: 'usuario-master-save', view: self, message: error});
            });
            Backbone.on(uComponent.componentId + '-instead-usuario-save', function(params) {
                self.model.set('usuarioEntity', params.model);
                if (params.model) {
                    self.model.set('id', params.model.id);
                } else {
                    self.model.unset('id');
                }
                var trabajoModels = self.trabajoComponent.componentController.trabajoModelList;
                self.model.set('listtrabajo', []);
                self.model.set('createtrabajo', []);
                self.model.set('updatetrabajo', []);
                self.model.set('deletetrabajo', []);
                for (var i = 0; i < trabajoModels.models.length; i++) {
                    var m =trabajoModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createtrabajo').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updatetrabajo').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < trabajoModels.deletedModels.length; i++) {
                    var m = trabajoModels.deletedModels[i];
                    self.model.get('deletetrabajo').push(m.toJSON());
                }
                self.model.save({}, {
                    success: function() {
                        Backbone.trigger(uComponent.componentId + '-post-usuario-save', self);
                    },
                    error: function(error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'usuario-master-save', view: self, error: error});
                    }
                });
            });
        },
        renderChilds: function(params) {
            var self = this;
            this.tabModel = new App.Model.TabModel(
                    {
                        tabs: [
                            {label: "Trabajo", name: "trabajo", enable: true},
                        ]
                    }
            );

            this.tabs = new TabController({model: this.tabModel});

            this.tabs.render('tabs');
            App.Model.UsuarioMasterModel.prototype.urlRoot = this.configuration.context;
            var options = {
                success: function() {
					self.trabajoComponent = new trabajoComponent();
                    self.trabajoModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.TrabajoModel), self.model.get('listtrabajo'));
                    self.trabajoComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.TrabajoModel),
                        listModelClass: App.Utils.createCacheList(App.Model.TrabajoModel, App.Model.TrabajoList, self.trabajoModels)
                    });
                    self.trabajoComponent.render(self.tabs.getTabHtmlId('trabajo'));
                    Backbone.on(self.trabajoComponent.componentId + '-post-trabajo-create', function(params) {
                        params.view.currentTrabajoModel.setCacheList(params.view.trabajoModelList);
                    });
                    self.trabajoToolbarModel = self.trabajoComponent.toolbarModel.set(App.Utils.Constans.containmentToolbarConfiguration);
                    self.trabajoComponent.setToolbarModel(self.trabajoToolbarModel);
                	
                     
                
                    Backbone.on(self.trabajoComponent.componentId + '-toolbar-add', function() {
                        var selection = new App.Controller.SelectionController({"componentId":"trabajoComponent"});
                        App.Utils.getComponentList('trabajoComponent', function(componentName, model) {
                            if (model.models.length == 0) {
                                alert('There is no Trabajos to select.');
                            } else {
                                selection.showSelectionList({list: model, name: 'name', title: 'Trabajo List'});
                            }
                            ;
                        });
                    });
                    Backbone.on('trabajoComponent-post-selection', function(models) {
                        var cachetrabajoModel = App.Utils.createCacheModel(App.Model.TrabajoModel);
                        models = App.Utils.convertToModel(cachetrabajoModel, models);
                        for (var i = 0; i < models.length; i++) {
                        	var model = models[i];
                        	model.setCacheList(self.trabajoComponent.componentController.trabajoModelList);
                        	model.save('',{});
                        }
                        self.trabajoComponent.componentController.showEdit=false;
                        self.trabajoComponent.componentController.list();
                        
                    });
                    $('#tabs').show();
                },
                error: function() {
                    Backbone.trigger(self.componentId + '-' + 'error', {event: 'usuario-edit', view: self, id: id, data: data, error: error});
                }
            };
            if (params.id) {
                self.model = new App.Model.UsuarioMasterModel({id: params.id});
                self.model.fetch(options);
            } else {
                self.model = new App.Model.UsuarioMasterModel();
                options.success();
            }


        },
        hideChilds: function() {
            $('#tabs').hide();
        }
    });

    return App.Component.UsuarioMasterComponent;
});