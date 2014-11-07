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

package co.edu.uniandes.csw.disenoPAP2.usuario.persistence.converter;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


import co.edu.uniandes.csw.disenoPAP2.usuario.logic.dto.UsuarioDTO;
import co.edu.uniandes.csw.disenoPAP2.usuario.persistence.entity.UsuarioEntity;

public abstract class _UsuarioConverter {

	public static UsuarioDTO entity2PersistenceDTO(UsuarioEntity entity){
		if (entity != null) {
			UsuarioDTO dto = new UsuarioDTO();
					dto.setId(entity.getId());
					dto.setName(entity.getName());
			return dto;
		}else{
			return null;
		}
	}
	
	public static UsuarioEntity persistenceDTO2Entity(UsuarioDTO dto){
		if(dto!=null){
			UsuarioEntity entity=new UsuarioEntity();
					entity.setId(dto.getId());
			
					entity.setName(dto.getName());
			
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<UsuarioDTO> entity2PersistenceDTOList(List<UsuarioEntity> entities){
		List<UsuarioDTO> dtos=new ArrayList<UsuarioDTO>();
		for(UsuarioEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<UsuarioEntity> persistenceDTO2EntityList(List<UsuarioDTO> dtos){
		List<UsuarioEntity> entities=new ArrayList<UsuarioEntity>();
		for(UsuarioDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}