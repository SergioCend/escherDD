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

package co.edu.uniandes.csw.disenoPAP2.trabajo.master.logic.dto;

import co.edu.uniandes.csw.disenoPAP2.obra.logic.dto.ObraDTO;
import co.edu.uniandes.csw.disenoPAP2.video.logic.dto.VideoDTO;
import co.edu.uniandes.csw.disenoPAP2.imagen.logic.dto.ImagenDTO;
import co.edu.uniandes.csw.disenoPAP2.autor.logic.dto.AutorDTO;
import co.edu.uniandes.csw.disenoPAP2.trabajo.logic.dto.TrabajoDTO;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public abstract class _TrabajoMasterDTO {

 
    protected TrabajoDTO trabajoEntity;
    protected Long id;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public TrabajoDTO getTrabajoEntity() {
        return trabajoEntity;
    }

    public void setTrabajoEntity(TrabajoDTO trabajoEntity) {
        this.trabajoEntity = trabajoEntity;
    }
    
    public List<ObraDTO> createobra;
    public List<ObraDTO> updateobra;
    public List<ObraDTO> deleteobra;
    public List<ObraDTO> listobra;	
    public List<VideoDTO> createvideo;
    public List<VideoDTO> updatevideo;
    public List<VideoDTO> deletevideo;
    public List<VideoDTO> listvideo;	
    public List<ImagenDTO> createimagen;
    public List<ImagenDTO> updateimagen;
    public List<ImagenDTO> deleteimagen;
    public List<ImagenDTO> listimagen;	
    public List<AutorDTO> createautor;
    public List<AutorDTO> updateautor;
    public List<AutorDTO> deleteautor;
    public List<AutorDTO> listautor;	
	
	
	
    public List<ObraDTO> getCreateobra(){ return createobra; };
    public void setCreateobra(List<ObraDTO> createobra){ this.createobra=createobra; };
    public List<ObraDTO> getUpdateobra(){ return updateobra; };
    public void setUpdateobra(List<ObraDTO> updateobra){ this.updateobra=updateobra; };
    public List<ObraDTO> getDeleteobra(){ return deleteobra; };
    public void setDeleteobra(List<ObraDTO> deleteobra){ this.deleteobra=deleteobra; };
    public List<ObraDTO> getListobra(){ return listobra; };
    public void setListobra(List<ObraDTO> listobra){ this.listobra=listobra; };	
    public List<VideoDTO> getCreatevideo(){ return createvideo; };
    public void setCreatevideo(List<VideoDTO> createvideo){ this.createvideo=createvideo; };
    public List<VideoDTO> getUpdatevideo(){ return updatevideo; };
    public void setUpdatevideo(List<VideoDTO> updatevideo){ this.updatevideo=updatevideo; };
    public List<VideoDTO> getDeletevideo(){ return deletevideo; };
    public void setDeletevideo(List<VideoDTO> deletevideo){ this.deletevideo=deletevideo; };
    public List<VideoDTO> getListvideo(){ return listvideo; };
    public void setListvideo(List<VideoDTO> listvideo){ this.listvideo=listvideo; };	
    public List<ImagenDTO> getCreateimagen(){ return createimagen; };
    public void setCreateimagen(List<ImagenDTO> createimagen){ this.createimagen=createimagen; };
    public List<ImagenDTO> getUpdateimagen(){ return updateimagen; };
    public void setUpdateimagen(List<ImagenDTO> updateimagen){ this.updateimagen=updateimagen; };
    public List<ImagenDTO> getDeleteimagen(){ return deleteimagen; };
    public void setDeleteimagen(List<ImagenDTO> deleteimagen){ this.deleteimagen=deleteimagen; };
    public List<ImagenDTO> getListimagen(){ return listimagen; };
    public void setListimagen(List<ImagenDTO> listimagen){ this.listimagen=listimagen; };	
    public List<AutorDTO> getCreateautor(){ return createautor; };
    public void setCreateautor(List<AutorDTO> createautor){ this.createautor=createautor; };
    public List<AutorDTO> getUpdateautor(){ return updateautor; };
    public void setUpdateautor(List<AutorDTO> updateautor){ this.updateautor=updateautor; };
    public List<AutorDTO> getDeleteautor(){ return deleteautor; };
    public void setDeleteautor(List<AutorDTO> deleteautor){ this.deleteautor=deleteautor; };
    public List<AutorDTO> getListautor(){ return listautor; };
    public void setListautor(List<AutorDTO> listautor){ this.listautor=listautor; };	
	
	
}
