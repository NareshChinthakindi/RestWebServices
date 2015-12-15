/**
 * 
 */
package org.naresh.javariders.messenger.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author nchintha
 *
 */
@Path("/inject")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectParamResource {

	
	@GET
	@Path("queryp")
	public String getParamValues(@MatrixParam("matrixParam") String matrixParam
			,@HeaderParam("headerParam") String headerValue)
			{
		               return "Val :"+matrixParam+" : HeaderParam : "+headerValue;
			}
}
