/**
 * 
 */
package org.naresh.javariders.messenger;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.naresh.javariders.messenger.dao.DataBaseClass;
import org.naresh.javariders.messenger.exception.DataNotFoundException;
import org.naresh.javariders.messenger.model.Message;

/**
 * @author nchintha
 *
 */
public class MessageService 
{

	private Map<Integer, Message> messages = DataBaseClass.getAllMessages();
	
	
	public MessageService()
	{
		Message m1= new Message(1,"Naresh","Test");
		Message m2 = new Message(2,"Testsedt ","fdjsfjdsjsd ");
		
		messages.put(1, m1);
		messages.put(2, m2);
	}
	
	public List<Message> getMessageForYear(int year)
	{
		List<Message> result = new ArrayList<Message>();
		
		for (Message message : getAllMesages())
		{
			Calendar cal = Calendar.getInstance();
			
			cal.setTime(message.getCreatedDate());
			
			if(cal.get(Calendar.YEAR) == year)
			{
				result.add(message);
			}
			
		}
		
		return result;
	}
	
	public List<Message> getAllMesages()
	{
		return new ArrayList(messages.values());
	}
	
	public Message getMessage(Integer id)
	{
		Message message = messages.get(id);
		
		if(message == null)
		{
			throw new DataNotFoundException("Message Not Found for Id "+id);
		}
		
		return message;
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

	public List<Message> getMessageBySizeAndStartIndex(int start, int size)
	{
		List<Message> allMessages = getAllMesages();
		
		return allMessages.subList(start, size);
		
	}
}
