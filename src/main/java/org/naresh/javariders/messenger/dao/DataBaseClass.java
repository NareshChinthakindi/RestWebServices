/**
 * 
 */
package org.naresh.javariders.messenger.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.naresh.javariders.messenger.model.Message;
import org.naresh.javariders.messenger.model.Profiles;

/**
 * @author nchintha
 *
 */
public class DataBaseClass {

	public static Map<Integer,Message> messages = new HashMap<Integer,Message>();
	
	public static Map<Integer,Profiles> profiles = new HashMap<Integer,Profiles>();
	
	
	public static List<Message> getAllMessages()
	{
		return new ArrayList(messages.values());
	}
	
	
	public static List<Profiles> getAllProfiles()
	{
		return new ArrayList(profiles.values());
	}
}
