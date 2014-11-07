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

package co.edu.uniandes.csw.disenoPAP2.autor.logic.mock;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.disenoPAP2.autor.logic.dto.AutorDTO;
import co.edu.uniandes.csw.disenoPAP2.autor.logic.api._IAutorLogicService;

public abstract class _AutorMockLogicService implements _IAutorLogicService {

	private Long id= new Long(1);
	protected List<AutorDTO> data=new ArrayList<AutorDTO>();

	public AutorDTO createAutor(AutorDTO autor){
		id++;
		autor.setId(id);
		data.add(autor);
		return autor;
    }

	public List<AutorDTO> getAutors(){
		return data; 
	}

	public AutorDTO getAutor(Long id){
		for(AutorDTO data1:data){
			if(data1.getId().equals(id)){
				return data1;
			}
		}
		return null;
	}

	public void deleteAutor(Long id){
	    AutorDTO delete=null;
		for(AutorDTO data1:data){
			if(data1.getId().equals(id)){
				delete=data1;
			}
		}
		if(delete!=null){
			data.remove(delete);
		} 
	}

	public void updateAutor(AutorDTO autor){
	    AutorDTO delete=null;
		for(AutorDTO data1:data){
			if(data1.getId().equals(id)){
				delete=data1;
			}
		}
		if(delete!=null){
			data.remove(delete);
			data.add(autor);
		} 
	}	
}