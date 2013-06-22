package edu.sdkd.domain;

import edu.sdkd.utils.Constant;

import java.util.Date;

import com.mysql.jdbc.Blob;

public class Card {
	private int id;
	private Date createdAt;
	private Date updatedAt;
	private boolean deleted;
	private boolean isMe;
	private Blob imgBack;
	private Blob imgFront;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public boolean isMe() {
		return isMe;
	}
	public void setMe(boolean isMe) {
		this.isMe = isMe;
	}
	public Blob getImgBack() {
		return imgBack;
	}
	public void setImgBack(Blob imgBack) {
		this.imgBack = imgBack;
	}
	public Blob getImgFront() {
		return imgFront;
	}
	public void setImgFront(Blob imgFront) {
		this.imgFront = imgFront;
	}
	
}
