/* ========================================================================
 * Copyright 2014 disenoPAP2
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 disenoPAP2

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.201408112050

*/

package co.edu.uniandes.csw.disenoPAP2.trabajo.master.logic.ejb;

import co.edu.uniandes.csw.disenoPAP2.obra.logic.dto.ObraDTO;
import co.edu.uniandes.csw.disenoPAP2.obra.persistence.api.IObraPersistence;
import co.edu.uniandes.csw.disenoPAP2.video.logic.dto.VideoDTO;
import co.edu.uniandes.csw.disenoPAP2.video.persistence.api.IVideoPersistence;
import co.edu.uniandes.csw.disenoPAP2.imagen.logic.dto.ImagenDTO;
import co.edu.uniandes.csw.disenoPAP2.imagen.persistence.api.IImagenPersistence;
import co.edu.uniandes.csw.disenoPAP2.autor.logic.dto.AutorDTO;
import co.edu.uniandes.csw.disenoPAP2.autor.persistence.api.IAutorPersistence;
import co.edu.uniandes.csw.disenoPAP2.trabajo.logic.dto.TrabajoDTO;
import co.edu.uniandes.csw.disenoPAP2.trabajo.master.logic.api._ITrabajoMasterLogicService;
import co.edu.uniandes.csw.disenoPAP2.trabajo.master.logic.dto.TrabajoMasterDTO;
import co.edu.uniandes.csw.disenoPAP2.trabajo.master.persistence.api.ITrabajoMasterPersistence;
import co.edu.uniandes.csw.disenoPAP2.trabajo.master.persistence.entity.TrabajoobraEntity;
import co.edu.uniandes.csw.disenoPAP2.trabajo.master.persistence.entity.TrabajovideoEntity;
import co.edu.uniandes.csw.disenoPAP2.trabajo.master.persistence.entity.TrabajoimagenEntity;
import co.edu.uniandes.csw.disenoPAP2.trabajo.master.persistence.entity.TrabajoautorEntity;
import co.edu.uniandes.csw.disenoPAP2.trabajo.persistence.api.ITrabajoPersistence;
import javax.inject.Inject;

public abstract class _TrabajoMasterLogicService implements _ITrabajoMasterLogicService {

    @Inject
    protected ITrabajoPersistence trabajoPersistance;
    @Inject
    protected ITrabajoMasterPersistence trabajoMasterPersistance;
    @Inject
    protected IImagenPersistence imagenPersistance;
    @Inject
    protected IAutorPersistence autorPersistance;
    @Inject
    protected IVideoPersistence videoPersistance;
    @Inject
    protected IObraPersistence obraPersistance;

    public TrabajoMasterDTO createMasterTrabajo(TrabajoMasterDTO trabajo) {
        TrabajoDTO persistedTrabajoDTO = trabajoPersistance.createTrabajo(trabajo.getTrabajoEntity());
        if (trabajo.getCreateobra() != null) {
            for (ObraDTO obraDTO : trabajo.getCreateobra()) {
                ObraDTO createdObraDTO = obraPersistance.createObra(obraDTO);
                TrabajoobraEntity trabajoObraEntity = new TrabajoobraEntity(persistedTrabajoDTO.getId(), createdObraDTO.getId());
                trabajoMasterPersistance.createTrabajoobraEntity(trabajoObraEntity);
            }
        }
        if (trabajo.getCreatevideo() != null) {
            for (VideoDTO videoDTO : trabajo.getCreatevideo()) {
                VideoDTO createdVideoDTO = videoPersistance.createVideo(videoDTO);
                TrabajovideoEntity trabajoVideoEntity = new TrabajovideoEntity(persistedTrabajoDTO.getId(), createdVideoDTO.getId());
                trabajoMasterPersistance.createTrabajovideoEntity(trabajoVideoEntity);
            }
        }
        if (trabajo.getCreateimagen() != null) {
            for (ImagenDTO imagenDTO : trabajo.getCreateimagen()) {
                ImagenDTO createdImagenDTO = imagenPersistance.createImagen(imagenDTO);
                TrabajoimagenEntity trabajoImagenEntity = new TrabajoimagenEntity(persistedTrabajoDTO.getId(), createdImagenDTO.getId());
                trabajoMasterPersistance.createTrabajoimagenEntity(trabajoImagenEntity);
            }
        }
        if (trabajo.getCreateautor() != null) {
            for (AutorDTO autorDTO : trabajo.getCreateautor()) {
                AutorDTO createdAutorDTO = autorPersistance.createAutor(autorDTO);
                TrabajoautorEntity trabajoAutorEntity = new TrabajoautorEntity(persistedTrabajoDTO.getId(), createdAutorDTO.getId());
                trabajoMasterPersistance.createTrabajoautorEntity(trabajoAutorEntity);
            }
        }
        // update obra
        if (trabajo.getUpdateobra() != null) {
            for (ObraDTO obraDTO : trabajo.getUpdateobra()) {
                obraPersistance.updateObra(obraDTO);
                TrabajoobraEntity trabajoObraEntity = new TrabajoobraEntity(persistedTrabajoDTO.getId(), obraDTO.getId());
                trabajoMasterPersistance.createTrabajoobraEntity(trabajoObraEntity);
            }
        }
        // update video
        if (trabajo.getUpdatevideo() != null) {
            for (VideoDTO videoDTO : trabajo.getUpdatevideo()) {
                videoPersistance.updateVideo(videoDTO);
                TrabajovideoEntity trabajoVideoEntity = new TrabajovideoEntity(persistedTrabajoDTO.getId(), videoDTO.getId());
                trabajoMasterPersistance.createTrabajovideoEntity(trabajoVideoEntity);
            }
        }
        // update imagen
        if (trabajo.getUpdateimagen() != null) {
            for (ImagenDTO imagenDTO : trabajo.getUpdateimagen()) {
                imagenPersistance.updateImagen(imagenDTO);
                TrabajoimagenEntity trabajoImagenEntity = new TrabajoimagenEntity(persistedTrabajoDTO.getId(), imagenDTO.getId());
                trabajoMasterPersistance.createTrabajoimagenEntity(trabajoImagenEntity);
            }
        }
        // update autor
        if (trabajo.getUpdateautor() != null) {
            for (AutorDTO autorDTO : trabajo.getUpdateautor()) {
                autorPersistance.updateAutor(autorDTO);
                TrabajoautorEntity trabajoAutorEntity = new TrabajoautorEntity(persistedTrabajoDTO.getId(), autorDTO.getId());
                trabajoMasterPersistance.createTrabajoautorEntity(trabajoAutorEntity);
            }
        }
        return trabajo;
    }

    public TrabajoMasterDTO getMasterTrabajo(Long id) {
        return trabajoMasterPersistance.getTrabajo(id);
    }

    public void deleteMasterTrabajo(Long id) {
        trabajoPersistance.deleteTrabajo(id);
    }

    public void updateMasterTrabajo(TrabajoMasterDTO trabajo) {
        trabajoPersistance.updateTrabajo(trabajo.getTrabajoEntity());

        //---- FOR RELATIONSHIP
        // persist new obra
        if (trabajo.getCreateobra() != null) {
            for (ObraDTO obraDTO : trabajo.getCreateobra()) {
                ObraDTO createdObraDTO = obraPersistance.createObra(obraDTO);
                TrabajoobraEntity trabajoObraEntity = new TrabajoobraEntity(trabajo.getTrabajoEntity().getId(), createdObraDTO.getId());
                trabajoMasterPersistance.createTrabajoobraEntity(trabajoObraEntity);
            }
        }
        // update obra
        if (trabajo.getUpdateobra() != null) {
            for (ObraDTO obraDTO : trabajo.getUpdateobra()) {
                obraPersistance.updateObra(obraDTO);
            }
        }
        // delete obra
        if (trabajo.getDeleteobra() != null) {
            for (ObraDTO obraDTO : trabajo.getDeleteobra()) {
                trabajoMasterPersistance.deleteTrabajoobraEntity(trabajo.getTrabajoEntity().getId(), obraDTO.getId());
                obraPersistance.deleteObra(obraDTO.getId());
            }
        }
        // persist new video
        if (trabajo.getCreatevideo() != null) {
            for (VideoDTO videoDTO : trabajo.getCreatevideo()) {
                VideoDTO createdVideoDTO = videoPersistance.createVideo(videoDTO);
                TrabajovideoEntity trabajoVideoEntity = new TrabajovideoEntity(trabajo.getTrabajoEntity().getId(), createdVideoDTO.getId());
                trabajoMasterPersistance.createTrabajovideoEntity(trabajoVideoEntity);
            }
        }
        // update video
        if (trabajo.getUpdatevideo() != null) {
            for (VideoDTO videoDTO : trabajo.getUpdatevideo()) {
                videoPersistance.updateVideo(videoDTO);
            }
        }
        // delete video
        if (trabajo.getDeletevideo() != null) {
            for (VideoDTO videoDTO : trabajo.getDeletevideo()) {
                trabajoMasterPersistance.deleteTrabajovideoEntity(trabajo.getTrabajoEntity().getId(), videoDTO.getId());
                videoPersistance.deleteVideo(videoDTO.getId());
            }
        }
        // persist new imagen
        if (trabajo.getCreateimagen() != null) {
            for (ImagenDTO imagenDTO : trabajo.getCreateimagen()) {
                ImagenDTO createdImagenDTO = imagenPersistance.createImagen(imagenDTO);
                TrabajoimagenEntity trabajoImagenEntity = new TrabajoimagenEntity(trabajo.getTrabajoEntity().getId(), createdImagenDTO.getId());
                trabajoMasterPersistance.createTrabajoimagenEntity(trabajoImagenEntity);
            }
        }
        // update imagen
        if (trabajo.getUpdateimagen() != null) {
            for (ImagenDTO imagenDTO : trabajo.getUpdateimagen()) {
                imagenPersistance.updateImagen(imagenDTO);
            }
        }
        // delete imagen
        if (trabajo.getDeleteimagen() != null) {
            for (ImagenDTO imagenDTO : trabajo.getDeleteimagen()) {
                trabajoMasterPersistance.deleteTrabajoimagenEntity(trabajo.getTrabajoEntity().getId(), imagenDTO.getId());
                imagenPersistance.deleteImagen(imagenDTO.getId());
            }
        }
        // delete autor
        if (trabajo.getDeleteautor() != null) {
            for (AutorDTO autorDTO : trabajo.getDeleteautor()) {
                trabajoMasterPersistance.deleteTrabajoautorEntity(trabajo.getTrabajoEntity().getId(), autorDTO.getId());
            }
        }
        // persist new autor
        if (trabajo.getCreateautor() != null) {
            for (AutorDTO autorDTO : trabajo.getCreateautor()) {
                TrabajoautorEntity trabajoAutorEntity = new TrabajoautorEntity(trabajo.getTrabajoEntity().getId(), autorDTO.getId());
                trabajoMasterPersistance.createTrabajoautorEntity(trabajoAutorEntity);
            }
        }
        // update autor
        if (trabajo.getUpdateautor() != null) {
            for (AutorDTO autorDTO : trabajo.getUpdateautor()) {
                trabajoMasterPersistance.deleteTrabajoautorEntity(trabajo.getTrabajoEntity().getId(), autorDTO.getId());
                autorPersistance.updateAutor(autorDTO);
                TrabajoautorEntity trabajoAutorEntity = new TrabajoautorEntity(trabajo.getId(), autorDTO.getId());
                trabajoMasterPersistance.createTrabajoautorEntity(trabajoAutorEntity);
                
            }
        }
    }
}
