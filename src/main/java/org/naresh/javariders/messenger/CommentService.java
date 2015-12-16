package org.naresh.javariders.messenger;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.naresh.javariders.messenger.dao.DataBaseClass;
import org.naresh.javariders.messenger.model.Comment;
import org.naresh.javariders.messenger.model.Message;

public class CommentService 
{



	private Map<Integer, Message> messages = DataBaseClass.getAllMessages();
	
	
	public CommentService()
	{
		
	}
	
    public List<Comment> getAllMesages(Integer messageId)
	{
		 Map<Integer, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList(comments.values());
	}
	
	public Comment getComment(Integer messageId,Integer commentId)
	{
		 Map<Integer, Comment> comments = messages.get(messageId).getComments();
		
		return comments.get(commentId);
	}
	
	
	public Comment addComment(Comment comment,Integer messageId)
	{
		 Map<Integer, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() +1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(Comment Comment,Integer messageId)
	{
		 Map<Integer, Comment> comments = messages.get(messageId).getComments();
		 comments.put(Comment.getId(), Comment);
		return  Comment;
	}
	
	public Comment removeComment(Integer messageId,Integer commentId)
	{
		 Map<Integer, Comment> comments = messages.get(messageId).getComments();
		 
		return comments.remove(commentId);
	}

}
