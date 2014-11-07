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

package co.edu.uniandes.csw.disenoPAP2.usuario.master.persistence;
import co.edu.uniandes.csw.disenoPAP2.trabajo.logic.dto.TrabajoDTO;
import co.edu.uniandes.csw.disenoPAP2.usuario.master.persistence.entity.UsuariotrabajoEntity;
import co.edu.uniandes.csw.disenoPAP2.trabajo.persistence.converter.TrabajoConverter;
import co.edu.uniandes.csw.disenoPAP2.usuario.logic.dto.UsuarioDTO;
import co.edu.uniandes.csw.disenoPAP2.usuario.master.logic.dto.UsuarioMasterDTO;
import co.edu.uniandes.csw.disenoPAP2.usuario.master.persistence.api._IUsuarioMasterPersistence;
import co.edu.uniandes.csw.disenoPAP2.usuario.persistence.api.IUsuarioPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class _UsuarioMasterPersistence implements _IUsuarioMasterPersistence {

  	@PersistenceContext(unitName="disenoPAP2PU")
 
    protected EntityManager entityManager;
    
    @Inject
    protected IUsuarioPersistence usuarioPersistence;  

    public UsuarioMasterDTO getUsuario(Long usuarioId) {
        UsuarioMasterDTO usuarioMasterDTO = new UsuarioMasterDTO();
        UsuarioDTO usuario = usuarioPersistence.getUsuario(usuarioId);
        usuarioMasterDTO.setUsuarioEntity(usuario);
        usuarioMasterDTO.setListtrabajo(getUsuariotrabajoEntityList(usuarioId));
        return usuarioMasterDTO;
    }

    public UsuariotrabajoEntity createUsuariotrabajoEntity(UsuariotrabajoEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteUsuariotrabajoEntity(Long usuarioId, Long trabajoId) {
        Query q = entityManager.createNamedQuery("UsuariotrabajoEntity.deleteUsuariotrabajoEntity");
        q.setParameter("usuarioId", usuarioId);
        q.setParameter("trabajoId", trabajoId);
        q.executeUpdate();
    }

    public List<TrabajoDTO> getUsuariotrabajoEntityList(Long usuarioId) {
        ArrayList<TrabajoDTO> resp = new ArrayList<TrabajoDTO>();
        Query q = entityManager.createNamedQuery("UsuariotrabajoEntity.getByMasterId");
        q.setParameter("usuarioId",usuarioId);
        List<UsuariotrabajoEntity> qResult =  q.getResultList();
        for (UsuariotrabajoEntity entity : qResult) { 
            if(entity.getTrabajoIdEntity()==null){
                entityManager.refresh(entity);
            }
            resp.add(TrabajoConverter.entity2PersistenceDTO(entity.getTrabajoIdEntity()));
        }
        return resp;
    }

}