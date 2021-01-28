package model;

import java.io.Serializable;

public class Request implements Serializable{
	private String req;
	public Request() {}
	public Request(String req) {
		this.req=req;
	}

	public String getReq() {
		return req;
	}

	public void setReq(String req) {
		this.req = req;
	}

}
