package be.Admin.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "listeventedit")
public class ListeventEdit {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;	
	private String deschead;
	private int itmprice;
	private int eventuse;
	private Long evenstat;
	private Long evenid;
	
	public Long getEvenid() {
		return evenid;
	}
	public void setEvenid(Long evenid) {
		this.evenid = evenid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeschead() {
		return deschead;
	}
	public void setDeschead(String deschead) {
		this.deschead = deschead;
	}
	public int getItmprice() {
		return itmprice;
	}
	public void setItmprice(int itmprice) {
		this.itmprice = itmprice;
	}
	public int getEventuse() {
		return eventuse;
	}
	public void setEventuse(int eventuse) {
		this.eventuse = eventuse;
	}
	public Long getEvenstat() {
		return evenstat;
	}
	public void setEvenstat(Long evenstat) {
		this.evenstat = evenstat;
	}
}
