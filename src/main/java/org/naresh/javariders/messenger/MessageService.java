/**
 * 
 */
package org.naresh.javariders.messenger;

import java.util.ArrayList;
import java.util.List;

import org.naresh.javariders.messenger.model.Message;

/**
 * @author nchintha
 *
 */
public class MessageService {

	public List<Message> getAllMesages()
	{
		List<Message> messages = new ArrayList<Message>();
		
		Message m1 = new Message(1,"Naresh","rdfjdklf dsf d");
		Message m2 = new Message(2,"Sa","dsfhdsfh dsfhd sfsdf d");
		
		messages.add(m1);
		messages.add(m2);
		
		
		return messages;
	}
}
