package com.cts.entity;

public class Course {
	int id;
	String title;
	String summary;
	public Course(){
		
	}
	
	public Course(int id, String title, String summary) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", summary=" + summary + "]";
	}

}
