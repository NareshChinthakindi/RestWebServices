/**
 * 
 */
package org.naresh.javariders.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.naresh.javariders.messenger.resource.bean.ErrorMessage;

/**
 * @author nchintha
 *
 */
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException ex)
	{
		ErrorMessage errorMessage = new ErrorMessage();
		
		errorMessage.setDocumentation("http://google.com");
		errorMessage.setErrorCode(Status.NOT_FOUND.toString());
		errorMessage.setErrorMesasge(ex.getMessage());
		
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}

}
