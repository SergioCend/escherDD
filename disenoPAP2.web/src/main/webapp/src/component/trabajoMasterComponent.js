define(['controller/selectionController', 'model/cacheModel', 'model/trabajoMasterModel', 'component/_CRUDComponent', 'controller/tabController', 'component/trabajoComponent',
 'component/obraComponent'
 ,
 'component/videoComponent'
 ,
 'component/imagenComponent'
 ,
 'component/autorComponent'
 
 ],function(SelectionController, CacheModel, TrabajoMasterModel, CRUDComponent, TabController, TrabajoComponent,
 obraComponent
 ,
 videoComponent
 ,
 imagenComponent
 ,
 autorComponent
 ) {
    App.Component.TrabajoMasterComponent = App.Component.BasicComponent.extend({
        initialize: function() {
            var self = this;
            this.configuration = App.Utils.loadComponentConfiguration('trabajoMaster');
            var uComponent = new TrabajoComponent();
            uComponent.initialize();
            uComponent.render('main');
            Backbone.on(uComponent.componentId + '-post-trabajo-create', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-post-trabajo-edit', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-pre-trabajo-list', function() {
                self.hideChilds();
            });
            Backbone.on('trabajo-master-model-error', function(error) {
                Backbone.trigger(uComponent.componentId + '-' + 'error', {event: 'trabajo-master-save', view: self, message: error});
            });
            Backbone.on(uComponent.componentId + '-instead-trabajo-save', function(params) {
                self.model.set('trabajoEntity', params.model);
                if (params.model) {
                    self.model.set('id', params.model.id);
                } else {
                    self.model.unset('id');
                }
                var obraModels = self.obraComponent.componentController.obraModelList;
                self.model.set('listobra', []);
                self.model.set('createobra', []);
                self.model.set('updateobra', []);
                self.model.set('deleteobra', []);
                for (var i = 0; i < obraModels.models.length; i++) {
                    var m =obraModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createobra').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updateobra').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < obraModels.deletedModels.length; i++) {
                    var m = obraModels.deletedModels[i];
                    self.model.get('deleteobra').push(m.toJSON());
                }
                var videoModels = self.videoComponent.componentController.videoModelList;
                self.model.set('listvideo', []);
                self.model.set('createvideo', []);
                self.model.set('updatevideo', []);
                self.model.set('deletevideo', []);
                for (var i = 0; i < videoModels.models.length; i++) {
                    var m =videoModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createvideo').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updatevideo').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < videoModels.deletedModels.length; i++) {
                    var m = videoModels.deletedModels[i];
                    self.model.get('deletevideo').push(m.toJSON());
                }
                var imagenModels = self.imagenComponent.componentController.imagenModelList;
                self.model.set('listimagen', []);
                self.model.set('createimagen', []);
                self.model.set('updateimagen', []);
                self.model.set('deleteimagen', []);
                for (var i = 0; i < imagenModels.models.length; i++) {
                    var m =imagenModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createimagen').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updateimagen').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < imagenModels.deletedModels.length; i++) {
                    var m = imagenModels.deletedModels[i];
                    self.model.get('deleteimagen').push(m.toJSON());
                }
                var autorModels = self.autorComponent.componentController.autorModelList;
                self.model.set('listautor', []);
                self.model.set('createautor', []);
                self.model.set('updateautor', []);
                self.model.set('deleteautor', []);
                for (var i = 0; i < autorModels.models.length; i++) {
                    var m =autorModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createautor').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updateautor').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < autorModels.deletedModels.length; i++) {
                    var m = autorModels.deletedModels[i];
                    self.model.get('deleteautor').push(m.toJSON());
                }
                self.model.save({}, {
                    success: function() {
                        Backbone.trigger(uComponent.componentId + '-post-trabajo-save', self);
                    },
                    error: function(error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'trabajo-master-save', view: self, error: error});
                    }
                });
            });
        },
        renderChilds: function(params) {
            var self = this;
            this.tabModel = new App.Model.TabModel(
                    {
                        tabs: [
                            {label: "Obra", name: "obra", enable: true},
                            ,
                            {label: "Video", name: "video", enable: true},
                            ,
                            {label: "Imagen", name: "imagen", enable: true},
                            ,
                            {label: "Autor", name: "autor", enable: true},
                        ]
                    }
            );

            this.tabs = new TabController({model: this.tabModel});

            this.tabs.render('tabs');
            App.Model.TrabajoMasterModel.prototype.urlRoot = this.configuration.context;
            var options = {
                success: function() {
					self.obraComponent = new obraComponent();
                    self.obraModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.ObraModel), self.model.get('listobra'));
                    self.obraComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.ObraModel),
                        listModelClass: App.Utils.createCacheList(App.Model.ObraModel, App.Model.ObraList, self.obraModels)
                    });
                    self.obraComponent.render(self.tabs.getTabHtmlId('obra'));
                    Backbone.on(self.obraComponent.componentId + '-post-obra-create', function(params) {
                        params.view.currentObraModel.setCacheList(params.view.obraModelList);
                    });
					self.videoComponent = new videoComponent();
                    self.videoModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.VideoModel), self.model.get('listvideo'));
                    self.videoComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.VideoModel),
                        listModelClass: App.Utils.createCacheList(App.Model.VideoModel, App.Model.VideoList, self.videoModels)
                    });
                    self.videoComponent.render(self.tabs.getTabHtmlId('video'));
                    Backbone.on(self.videoComponent.componentId + '-post-video-create', function(params) {
                        params.view.currentVideoModel.setCacheList(params.view.videoModelList);
                    });
					self.imagenComponent = new imagenComponent();
                    self.imagenModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.ImagenModel), self.model.get('listimagen'));
                    self.imagenComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.ImagenModel),
                        listModelClass: App.Utils.createCacheList(App.Model.ImagenModel, App.Model.ImagenList, self.imagenModels)
                    });
                    self.imagenComponent.render(self.tabs.getTabHtmlId('imagen'));
                    Backbone.on(self.imagenComponent.componentId + '-post-imagen-create', function(params) {
                        params.view.currentImagenModel.setCacheList(params.view.imagenModelList);
                    });
					self.autorComponent = new autorComponent();
                    self.autorModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.AutorModel), self.model.get('listautor'));
                    self.autorComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.AutorModel),
                        listModelClass: App.Utils.createCacheList(App.Model.AutorModel, App.Model.AutorList, self.autorModels)
                    });
                    self.autorComponent.render(self.tabs.getTabHtmlId('autor'));
                    Backbone.on(self.autorComponent.componentId + '-post-autor-create', function(params) {
                        params.view.currentAutorModel.setCacheList(params.view.autorModelList);
                    });
                    self.obraToolbarModel = self.obraComponent.toolbarModel.set(App.Utils.Constans.referenceToolbarConfiguration);
                    self.obraComponent.setToolbarModel(self.obraToolbarModel);                    
                    self.videoToolbarModel = self.videoComponent.toolbarModel.set(App.Utils.Constans.referenceToolbarConfiguration);
                    self.videoComponent.setToolbarModel(self.videoToolbarModel);                    
                    self.imagenToolbarModel = self.imagenComponent.toolbarModel.set(App.Utils.Constans.referenceToolbarConfiguration);
                    self.imagenComponent.setToolbarModel(self.imagenToolbarModel);                    
                    self.autorToolbarModel = self.autorComponent.toolbarModel.set(App.Utils.Constans.containmentToolbarConfiguration);
                    self.autorComponent.setToolbarModel(self.autorToolbarModel);
                	
                     
                
                    Backbone.on(self.autorComponent.componentId + '-toolbar-add', function() {
                        var selection = new App.Controller.SelectionController({"componentId":"autorComponent"});
                        App.Utils.getComponentList('autorComponent', function(componentName, model) {
                            if (model.models.length == 0) {
                                alert('There is no Autors to select.');
                            } else {
                                selection.showSelectionList({list: model, name: 'name', title: 'Autor List'});
                            }
                            ;
                        });
                    });
                    Backbone.on('autorComponent-post-selection', function(models) {
                        var cacheautorModel = App.Utils.createCacheModel(App.Model.AutorModel);
                        models = App.Utils.convertToModel(cacheautorModel, models);
                        for (var i = 0; i < models.length; i++) {
                        	var model = models[i];
                        	model.setCacheList(self.autorComponent.componentController.autorModelList);
                        	model.save('',{});
                        }
                        self.autorComponent.componentController.showEdit=false;
                        self.autorComponent.componentController.list();
                        
                    });
                    $('#tabs').show();
                },
                error: function() {
                    Backbone.trigger(self.componentId + '-' + 'error', {event: 'trabajo-edit', view: self, id: id, data: data, error: error});
                }
            };
            if (params.id) {
                self.model = new App.Model.TrabajoMasterModel({id: params.id});
                self.model.fetch(options);
            } else {
                self.model = new App.Model.TrabajoMasterModel();
                options.success();
            }


        },
        hideChilds: function() {
            $('#tabs').hide();
        }
    });

    return App.Component.TrabajoMasterComponent;
});