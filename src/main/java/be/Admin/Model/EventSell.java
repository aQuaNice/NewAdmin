package be.Admin.Model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbm_m_event")
public class EventSell {	
	private Long id;
	private String descevent;
	private int stat;
	private double eveset;
	
	@Transient
	public String getDatestart() {
		return datestart;
	}
	public void setDatestart(String datestart) {
		this.datestart = datestart;
	}
	@Transient
	public String getDateend() {
		return dateend;
	}
	public void setDateend(String dateend) {
		this.dateend = dateend;
	}
	
	private String datestart;
	private String dateend;
	
//	@Column(name = "msgDate", columnDefinition="timestamp")
	private Date evestart;
	
//	@Column(name = "msgDate", columnDefinition="timestamp")
	private Date eveend;
	private String evendesc;
//	private Product product;
	private Set<EventItem> eventItem;
	
	
//	public EventSell(){
//    }
//    public EventSell(String name) {
//        this.descevent = name;
//    }
    
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescevent() {
		return descevent;
	}
	public void setDescevent(String descevent) {
		this.descevent = descevent;
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	public double getEveset() {
		return eveset;
	}
	public void setEveset(double eveset) {
		this.eveset = eveset;
	}
	public Date getEvestart() {
		return evestart;
	}
	public void setEvestart(Date evestart) {
		this.evestart = evestart;
	}
	public Date getEveend() {
		return eveend;
	}
	public void setEveend(Date eveend) {
		this.eveend = eveend;
	}
	public String getEvendesc() {
		return evendesc;
	}
	public void setEvendesc(String evendesc) {
		this.evendesc = evendesc;
	}
	
//	@OneToMany(mappedBy = "eventSell", cascade = CascadeType.ALL)
	@OneToMany(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name="idevent")
	@NotNull
	public Set<EventItem> getEventItem() {
		return eventItem;
	}
	public void setEventItem(Set<EventItem> eventItem) {
		this.eventItem = eventItem;
	}
}
