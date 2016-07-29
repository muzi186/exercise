package com.gl.redis.voting.vo;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private String link;
	private Date publishAt;
	private Integer votes;
	private User author;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getPublishAt() {
		return publishAt;
	}

	public void setPublishAt(Date publishAt) {
		this.publishAt = publishAt;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
}
