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

package co.edu.uniandes.csw.disenoPAP2.autor.logic.ejb;
import java.util.List;
import javax.inject.Inject;

import co.edu.uniandes.csw.disenoPAP2.autor.logic.dto.AutorDTO;
import co.edu.uniandes.csw.disenoPAP2.autor.logic.api._IAutorLogicService;
import co.edu.uniandes.csw.disenoPAP2.autor.persistence.api.IAutorPersistence;

public abstract class _AutorLogicService implements _IAutorLogicService {

	@Inject
	protected IAutorPersistence persistance;

	public AutorDTO createAutor(AutorDTO autor){
		return persistance.createAutor( autor); 
    }

	public List<AutorDTO> getAutors(){
		return persistance.getAutors(); 
	}

	public AutorDTO getAutor(Long id){
		return persistance.getAutor(id); 
	}

	public void deleteAutor(Long id){
	    persistance.deleteAutor(id); 
	}

	public void updateAutor(AutorDTO autor){
	    persistance.updateAutor(autor); 
	}	
}