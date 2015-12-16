/**
 * 
 */
package org.naresh.javariders.messenger.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.naresh.javariders.messenger.CommentService;
import org.naresh.javariders.messenger.model.Comment;

/**
 * @author nchintha
 *
 */
@Path("/")
public class CommentResource 
{

	CommentService commentService = new CommentService();
	
	
	@GET
	@Path("/{CommentId}")
	public Comment getComment(@PathParam("commentId") Integer commentId,@PathParam("messageId") Integer messageId)
	{
		return commentService.getComment(messageId, commentId);
	}
	
	@DELETE
	@Path("/{CommentId}")
	public Comment deleteComment(@PathParam("commentId") Integer commentId,@PathParam("messageId") Integer messageId)
	{
		return commentService.removeComment(messageId, commentId);
	}
	
	@POST
	public Comment addComment(Comment comment,@PathParam("messageId") Integer messageId)
	{
		return commentService.addComment(comment, messageId);
	}
	
	
	@PUT
	@Path("/{CommentId}")
	public Comment updateComment(Comment comment,@PathParam("commentId") Integer commentId,@PathParam("messageId") Integer messageId)
	{
		comment.setId(commentId);
		return commentService.updateComment(comment, messageId);
	}
	
	
}
