package com.khanday.model;

// Java Bean
// This class is an typical objective representation of a student.
// This class follows the norms, so it could be called a Bean, more specifically a Java Bean.
public class Student {
    private long rollNo;
    private String name;
    private String address;
    private String phoneNo;

    public long getRollNo() {
        return this.rollNo;
    }

    public void setRollNo(long rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return this.phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

}
