package com.appointphoto.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="_U_Photo")
public class UserPictures {
	private int id;
	private int uId;
	private String captain;
	private String pic;	
	private User user;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
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
	
	@ManyToOne(cascade=CascadeType.REFRESH,optional=false)
	@JoinColumn(name="uId", referencedColumnName="id",nullable=false,insertable=false, updatable=false)
	//@JoinColumn(name="uId",insertable=false, updatable=false)
	public User getUser() {
		return user;
	}
	
	
	public void setUser(User user) {
		this.user = user;
	}
	
}
