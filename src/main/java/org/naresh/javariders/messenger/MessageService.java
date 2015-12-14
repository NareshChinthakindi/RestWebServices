/**
 * 
 */
package org.naresh.javariders.messenger;

import java.util.ArrayList;
import java.util.List;

import org.naresh.javariders.messenger.dao.DataBaseClass;
import org.naresh.javariders.messenger.model.Message;

/**
 * @author nchintha
 *
 */
public class MessageService 
{

	private List<Message> messages = DataBaseClass.getAllMessages();
	
	
	public MessageService()
	{
		Message m1= new Message(1,"Naresh","Test");
		Message m2 = new Message(2,"Testsedt ","fdjsfjdsjsd ");
		addMessage(m1);
		addMessage(m2);
	}
	
	public List<Message> getAllMesages()
	{
		return messages;
	}
	
	public Message getMessage(Integer id)
	{
		
		return messages.get(id);
	}
	
	
	public Message addMessage(Message message)
	{
		message.setId(messages.size() +1);
		DataBaseClass.messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message)
	{
		DataBaseClass.messages.put(message.getId(), message);
		return  message;
	}
	
	public List<Message> removeMessage(Integer id)
	{
		DataBaseClass.messages.remove(id);
		return getAllMesages();
	}
}
