package be.Admin.Model;

public class ProccessOrder {

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	public int getIdmember() {
		return idmember;
	}
	public void setIdmember(int idmember) {
		this.idmember = idmember;
	}
	public String getGcmcode() {
		return gcmcode;
	}
	public void setGcmcode(String gcmcode) {
		this.gcmcode = gcmcode;
	}
	
	private Long id;
	private int stat;
	private int idmember;
	private	String gcmcode;
	private	String ordstat;
	public String getOrdstat() {
		return ordstat;
	}
	public void setOrdstat(String ordstat) {
		this.ordstat = ordstat;
	}

}
