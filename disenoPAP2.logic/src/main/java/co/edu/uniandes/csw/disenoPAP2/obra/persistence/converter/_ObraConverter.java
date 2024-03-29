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

package co.edu.uniandes.csw.disenoPAP2.obra.persistence.converter;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


import co.edu.uniandes.csw.disenoPAP2.obra.logic.dto.ObraDTO;
import co.edu.uniandes.csw.disenoPAP2.obra.persistence.entity.ObraEntity;

public abstract class _ObraConverter {

	public static ObraDTO entity2PersistenceDTO(ObraEntity entity){
		if (entity != null) {
			ObraDTO dto = new ObraDTO();
					dto.setId(entity.getId());
					dto.setUrlArchivo(entity.getUrlArchivo());
					dto.setName(entity.getName());
			return dto;
		}else{
			return null;
		}
	}
	
	public static ObraEntity persistenceDTO2Entity(ObraDTO dto){
		if(dto!=null){
			ObraEntity entity=new ObraEntity();
					entity.setId(dto.getId());
			
					entity.setUrlArchivo(dto.getUrlArchivo());
			
					entity.setName(dto.getName());
			
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<ObraDTO> entity2PersistenceDTOList(List<ObraEntity> entities){
		List<ObraDTO> dtos=new ArrayList<ObraDTO>();
		for(ObraEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<ObraEntity> persistenceDTO2EntityList(List<ObraDTO> dtos){
		List<ObraEntity> entities=new ArrayList<ObraEntity>();
		for(ObraDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}