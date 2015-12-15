/**
 * 
 */
package org.naresh.javariders.messenger.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.naresh.javariders.messenger.MessageService;
import org.naresh.javariders.messenger.model.Message;

/**
 * @author nchintha
 *
 */

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService msgService = new MessageService();
	
	@GET
	public List<Message> getMessage(@QueryParam("year") int year
			,@QueryParam("start") int start,@QueryParam("size") int size)
	{
		
		if(year > 0)
		{
			return msgService.getMessageForYear(year);
		}
		else if(start >=0 && size >0)
		{
			return msgService.getMessageBySizeAndStartIndex(start,size);
		}
		
		return msgService.getAllMesages();
	}
	
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") Integer messageId)
	{
		return msgService.getMessage(messageId);
	}
	
	@DELETE
	@Path("/{messageId}")
	public List<Message> deleteMessage(@PathParam("messageId") Integer messageId)
	{
		return msgService.removeMessage(messageId);
	}
	
	@POST

	public Message addMessage(Message message)
	{
		return msgService.addMessage(message);
	}
	
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(Message message,@PathParam("messageId") Integer messageId)
	{
		message.setId(messageId);
		return msgService.updateMessage(message);
	}
}
