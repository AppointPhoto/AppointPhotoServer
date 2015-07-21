package com.appointphoto.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="_User")
public class User {
	private long id;
	private String name;
	private int sex;
	
	private String password;
	private String emailAddress ; 
	private String phoneNum; 
	private String image;
	private String location;	
	private int level;
	
	//用戶對應的圖片@one to many
	private Set<UserPictures> pictures=new HashSet<UserPictures>();	
	
	//对应的审核用户
	private CheckUser checkuser;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@OneToMany(mappedBy="user" ,cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	//@JoinColumn(name="id")
	@OrderBy(value= "id ASC")
	public Set<UserPictures> getPictures() {
		return pictures;
	}


	public void setPictures(Set<UserPictures> pictures) {
		this.pictures = pictures;
	}

	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	public CheckUser getCheckuser() {
		return checkuser;
	}

	
	public void setCheckuser(CheckUser checkuser) {
		this.checkuser = checkuser;
	}

}
