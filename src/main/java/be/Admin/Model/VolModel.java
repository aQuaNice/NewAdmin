package be.Admin.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbm_m_vol")
public class VolModel {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)

	public String getDescvol() {
		return descvol;
	}
	public void setDescvol(String descvol) {
		this.descvol = descvol;
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	private Long id; 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private String descvol; 
	private int stat;
}

