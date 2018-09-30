package com.android.model;

public class ContactsBean {

	public String companyName;
	public String name;
	public String sex;
	public int age;
	public String position;
	public String department;
	public String  brithday;
	public String phone;
	public int isDMakers;
	public String notes;
   
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getSex() {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public String getPosition() {
        return position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public String getDepartment() {
        return department;
    }

    public void setBrithday(String brithday) {
        this.brithday = brithday;
    }
    public String  getBrithday() {
        return brithday;
    }

    public void setIsDMakers(int isDMakers) {
        this.isDMakers = isDMakers;
    }
    public int getIsDMakers() {
        return isDMakers;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    public String getNotes() {
        return notes;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}