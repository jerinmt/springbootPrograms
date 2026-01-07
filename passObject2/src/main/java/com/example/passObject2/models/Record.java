package com.example.passObject2.models;

public class Record {
	private int rollNo;
    private String name;
    private float marks;
    
    public Record(int rollNo, String name, float marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }
    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public float getMarks() {
        return marks;
    }
    public void setMarks(float marks) {
        this.marks = marks;
    }
}
