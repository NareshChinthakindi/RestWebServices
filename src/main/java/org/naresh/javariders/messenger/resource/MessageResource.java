/**
 * 
 */
package org.naresh.javariders.messenger.resource;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.naresh.javariders.messenger.MessageService;
import org.naresh.javariders.messenger.model.Message;
import org.naresh.javariders.messenger.resource.bean.MessageBeanParam;

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
	public List<Message> getMessage(@BeanParam MessageBeanParam messageBeanParam)
	{
		
		if(messageBeanParam.getYear() > 0)
		{
			return msgService.getMessageForYear(messageBeanParam.getYear());
		}
		else if(messageBeanParam.getStart() >=0 && messageBeanParam.getSize() >0)
		{
			return msgService.getMessageBySizeAndStartIndex(messageBeanParam.getStart(), messageBeanParam.getSize());
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
	public Response addMessage(Message message,@Context UriInfo uriInfo)
	{
		//return msgService.addMessage(message);
		
		Message newMessage = msgService.addMessage(message);
		
		UriBuilder builder =  uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMessage.getId()));
		return Response.created(builder.build()).entity(newMessage).build();
	}
	
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(Message message,@PathParam("messageId") Integer messageId)
	{
		message.setId(messageId);
		return msgService.updateMessage(message);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getComments()
	{
		return new CommentResource();
	}
}
