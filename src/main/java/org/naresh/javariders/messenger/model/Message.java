package org.naresh.javariders.messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {

	
	private String author;
	private Date createdDate;
	private String message;
	private int id;
	
	private Map<Integer,Comment> comments = new HashMap<Integer,Comment>();
	private List<Links> links = new ArrayList<Links>();
	
	

	/**
	 * @return the links
	 */
	public List<Links> getLinks() {
		return links;
	}
	/**
	 * @param links the links to set
	 */
	public void setLinks(List<Links> links) {
		this.links = links;
	}
	public Message()
	{
		
	}
	/**
	 * @return the comments
	 */
	@XmlTransient
	public Map<Integer, Comment> getComments() {
		return comments;
	}
	
	/**
	 * @param comments the comments to set
	 */
	public void setComments(Map<Integer, Comment> comments) {
		this.comments = comments;
	}
	
	public Message(int id,String author,String message)
	{
		this.id = id;
		this.author = author;
		this.message = message;
		this.createdDate = new Date();
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	public void addLinks(String uri,String rel)
	{
		Links links = new Links();
		links.setLink(uri);
		links.setRel(rel);
		this.links.add(links);
	}
	
}
