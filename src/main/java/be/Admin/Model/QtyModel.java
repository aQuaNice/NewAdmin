package be.Admin.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "tbm_m_qty")
public class QtyModel {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
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
	private Long id;
	private String descqty; 
	public String getDescqty() {
		return descqty;
	}
	public void setDescqty(String descqty) {
		this.descqty = descqty;
	}
	private int stat;
	
	
}
