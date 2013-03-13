package com.spr.hib.domain;

public enum Status {
	INPROGRESS("in progress"), FINISHED("finished");
	
	private String string;
	Status(String a){
		this.string = a;
	}
	
	public String getString(){
		return string;
	}
	public String toString(){
		return string;
	}
}
