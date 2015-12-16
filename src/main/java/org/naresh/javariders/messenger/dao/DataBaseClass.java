/**
 * 
 */
package org.naresh.javariders.messenger.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.naresh.javariders.messenger.model.Comment;
import org.naresh.javariders.messenger.model.Message;
import org.naresh.javariders.messenger.model.Profiles;

/**
 * @author nchintha
 *
 */
public class DataBaseClass {

	public static Map<Integer,Message> messages = new HashMap<Integer,Message>();
	
	public static Map<Integer,Profiles> profiles = new HashMap<Integer,Profiles>();
	
	public static Map<Integer, Message> getAllMessages()
	{
		return messages;
	}
	
	
	public static Map<Integer,Profiles> getAllProfiles()
	{
		return profiles;
	}
}
