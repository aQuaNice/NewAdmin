package be.Admin.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbm_menu")
public class KategoryModel {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getMnuicon() {
		return mnuicon;
	}
	public void setMnuicon(String mnuicon) {
		this.mnuicon = mnuicon;
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	private String desc; 
	private String mnuicon; 
	private int stat;

}
