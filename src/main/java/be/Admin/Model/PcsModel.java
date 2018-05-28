package be.Admin.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbm_m_pcs")
public class PcsModel {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescpcs() {
		return descpcs;
	}
	public void setDescpcs(String descpcs) {
		this.descpcs = descpcs;
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	private Long id;
	private String descpcs; 
	private int stat;
	
	
	
	
}
