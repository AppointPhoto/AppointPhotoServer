package com.appointphoto.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="_U_Photo")
public class UserPictures {
	private long id;
	private long uId;
	private String captain;
	private String pic;	
	private User user;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public long getuId() {
		return uId;
	}
	public void setuId(long uId) {
		this.uId = uId;
	}
	public String getCaptain() {
		return captain;
	}
	public void setCaptain(String captain) {
		this.captain = captain;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	@ManyToOne(cascade=CascadeType.REFRESH,optional=false,fetch=FetchType.LAZY)
	@JoinColumn(name="uId", referencedColumnName="id",nullable=false,insertable=false, updatable=false)
	//@JoinColumn(name="uId",insertable=false, updatable=false)
	public User getUser() {
		return user;
	}
	
	
	public void setUser(User user) {
		this.user = user;
	}
	
}
