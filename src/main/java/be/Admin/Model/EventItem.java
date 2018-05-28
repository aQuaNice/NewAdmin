package be.Admin.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import be.dashmon.domain.Product;
@Entity
@Table(name = "tbm_d_event")
//@Entity(name = "tbm_d_event")
public class EventItem {
	private Long id;
	private int iditem;
	private Long idevent;
	private float eveprice;
	private Product product;
	private EventSell eventSell;
		

//	public EventItem(){
//		
//	}
//	
//	public EventItem(float price){
//		this.eveprice = price;
//	}
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getIditem() {
		return iditem;
	}

	public void setIditem(int iditem) {
		this.iditem = iditem;
	}
	public Long getIdevent() {
		return idevent;
	}

	public void setIdevent(Long idevent) {
		this.idevent = idevent;
	}
	public float getEveprice() {
		return eveprice;
	}

	public void setEveprice(float eveprice) {
		this.eveprice = eveprice;
	}
	
//	@ManyToOne
//    @JoinColumn(name="iditem",insertable = false, updatable = false)
//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
//	@ManyToOne
//    @JoinColumn(name="idevent",insertable = false, updatable = false)	
	 @ManyToOne(optional = false)
	    @JoinColumn(name="idevent",insertable = false, updatable = false,referencedColumnName="id")
	public EventSell getEventSell() {
		return eventSell;
	}

	public void setEventSell(EventSell eventSell) {
		this.eventSell = eventSell;
	}
	
	
	
	@ManyToOne
    @JoinColumn(name="iditem",insertable = false, updatable = false)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
