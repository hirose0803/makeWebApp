package model;

import java.io.Serializable;

public class Slang implements Serializable {
	private int id;
	private String title;
	private String body;
	private int type;
	public Slang() {}
	public Slang(String title,String body,int type) {
		this.title=title;
		this.body=body;
		this.type=type;
	}
	public Slang(int id,String title,String body,int type) {
		this(title,body,type);
		this.id=id;
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
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}


}
