package edu.sdkd.domain;

import edu.sdkd.dao.InfoDao;
import edu.sdkd.dao.impl.InfoDaoImpl;
import edu.sdkd.utils.Constant;

import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Blob;

public class Card {
	private int id;
	private Date createdAt;
	private Date updatedAt;
	private boolean deleted;
	private boolean isMe;
	private String imgBack;
	private String imgFront;
	
	public String getImgBack() {
		return imgBack;
	}
	public void setImgBack(String imgBack) {
		this.imgBack = imgBack;
	}
	public String getImgFront() {
		return imgFront;
	}
	public void setImgFront(String imgFront) {
		this.imgFront = imgFront;
	}

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
	
	
	public List<Info> getInfoes() {
		InfoDao infoDao = new InfoDaoImpl();
		List<Info> infoes = infoDao.getInfoesByCard(id);
		return infoes;
	}
	
}