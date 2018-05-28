package be.Admin.Model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Result {
	private String resultmsg;
	private String resulcd;
	private String resuldata;
	private JSONObject rsltobject;
	public JSONObject getRsltobject() {
		return rsltobject;
	}
	public void setRsltobject(JSONObject rsltobject) {
		this.rsltobject = rsltobject;
	}
	public JSONArray getRsltArray() {
		return rsltArray;
	}
	public void setRsltArray(JSONArray rsltArray) {
		this.rsltArray = rsltArray;
	}
	private JSONArray rsltArray;
	
	public String getResultmsg() {
		return resultmsg;
	}
	public void setResultmsg(String resultmsg) {
		this.resultmsg = resultmsg;
	}
	public String getResulcd() {
		return resulcd;
	}
	public void setResulcd(String resulcd) {
		this.resulcd = resulcd;
	}
	public String getResuldata() {
		return resuldata;
	}
	public void setResuldata(String resuldata) {
		this.resuldata = resuldata;
	}	
}
