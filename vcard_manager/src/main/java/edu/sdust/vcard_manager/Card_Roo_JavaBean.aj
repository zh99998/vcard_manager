// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.sdust.vcard_manager;

import edu.sdust.vcard_manager.Card;
import java.util.Date;

privileged aspect Card_Roo_JavaBean {
    
    public Boolean Card.getIsMe() {
        return this.isMe;
    }
    
    public void Card.setIsMe(Boolean isMe) {
        this.isMe = isMe;
    }
    
    public Boolean Card.getDeleted() {
        return this.deleted;
    }
    
    public void Card.setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
    
    public byte[] Card.getImgFront() {
        return this.imgFront;
    }
    
    public void Card.setImgFront(byte[] imgFront) {
        this.imgFront = imgFront;
    }
    
    public byte[] Card.getImgBack() {
        return this.imgBack;
    }
    
    public void Card.setImgBack(byte[] imgBack) {
        this.imgBack = imgBack;
    }
    
    public Date Card.getCreatedAt() {
        return this.createdAt;
    }
    
    public void Card.setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public Date Card.getUpdatedAt() {
        return this.updatedAt;
    }
    
    public void Card.setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
}