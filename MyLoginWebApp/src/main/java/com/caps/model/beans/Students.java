package com.caps.model.beans;

public class Students {
private int userid;

private String password;
private String firstname;
private String lastname;
private String type;
private String gender;

public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Students [userid=" + userid + ", password=" + password + ", firstname=" + firstname + ", lastname="
			+ lastname + ", type=" + type + ", gender=" + gender + "]";
}


}
