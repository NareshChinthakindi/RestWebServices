/**
 * 
 */
package org.naresh.javariders.messenger.model;

import java.util.Date;

/**
 * @author nchintha
 *
 */
public class Comment {

	
	private int id;
	private Date creationDate;
	private String comment;
	private String author;
	
	
	public Comment()
	{
		
	}
	
	
	public Comment(int id,String comment,String author)
	{
		this.id = id;
		this.creationDate = new Date();
		this.comment = comment;
		this.author = author;
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
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
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
	
	
	
	
	
}
