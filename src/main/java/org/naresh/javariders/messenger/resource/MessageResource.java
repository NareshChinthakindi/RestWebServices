/**
 * 
 */
package org.naresh.javariders.messenger.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.naresh.javariders.messenger.MessageService;
import org.naresh.javariders.messenger.model.Message;

/**
 * @author nchintha
 *
 */

@Path("/messages")
public class MessageResource {

	MessageService msgService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessage()
	{
		return msgService.getAllMesages();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") Integer messageId)
	{
		return msgService.getMessage(messageId);
	}
	
}
