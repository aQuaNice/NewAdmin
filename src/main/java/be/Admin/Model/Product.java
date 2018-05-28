package be.Admin.Model;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
//import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "tbm_item")
public class Product {
	private int id;
	@NotEmpty(message = "Description is required")
	private String deschead;
	// @NotEmpty(message = "Address is required.")
	private String desccont;
	// @NotEmpty(message = "Icon cannot be empty")
	private String itemicon;
	@NotNull()
	private int itmprice;
	private MultipartFile files;

	@NotEmpty(message = "Pcs minimun is 1")
	private String itmsat;
	@NotNull()
	private int itmqty;
	@NotEmpty(message = "Address is required.")
	private String itmvol;
	private int eventuse;
	private ProductCategory productCategory;
	private Set<OrderDetail> orderDetail;
	private Set<EventItem> eventItem;
	private Long evenid;
	
	@Transient
	public Long getEvenid() {
		return evenid;
	}

	public void setEvenid(Long evenid) {
		this.evenid = evenid;
	}

	@Transient
	public Long getEvenstat() {
		return evenstat;
	}

	public void setEvenstat(Long evenstat) {
		this.evenstat = evenstat;
	}

	
	private Long evenstat;
	
	@NotNull()
	private int idmenu;

	public Product(){

	}

	public Product(String name) {
		this.deschead = name;
	}

	public Product(String name, ProductCategory productCategory) {
		this.deschead = name;
		this.productCategory = productCategory;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Transient
	public MultipartFile getFiles() {
		return files;
	}

	public void setFiles(MultipartFile files) {
		this.files = files;
	}

	public int getIdmenu() {
		return idmenu;
	}

	public void setIdmenu(int idmenu) {
		this.idmenu = idmenu;
	}

	public String getDeschead() {
		return deschead;
	}

	public void setDeschead(String deschead) {
		this.deschead = deschead;
	}

	public String getDesccont() {
		return desccont;
	}

	public void setDesccont(String desccont) {
		this.desccont = desccont;
	}

	public String getItemicon() {
		return itemicon;
	}

	public void setItemicon(String itemicon) {
		this.itemicon = itemicon;
	}

	public int getItmprice() {
		return itmprice;
	}

	public void setItmprice(int itmprice) {
		this.itmprice = itmprice;
	}

	public String getItmsat() {
		return itmsat;
	}

	public void setItmsat(String itmsat) {
		this.itmsat = itmsat;
	}

	public int getItmqty() {
		return itmqty;
	}

	public void setItmqty(int itmqty) {
		this.itmqty = itmqty;
	}

	public String getItmvol() {
		return itmvol;
	}

	public void setItmvol(String itmvol) {
		this.itmvol = itmvol;
	}
	
	public int getEventuse() {
		return eventuse;
	}

	public void setEventuse(int eventuse) {
		this.eventuse = eventuse;
	}


	@ManyToOne
	@JoinColumn(name = "idmenu", insertable = false, updatable = false)
	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	
	
	 @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	public Set<EventItem> getEventItem() {
		return eventItem;
	}

	public void setEventItem(Set<EventItem> eventItem) {
		this.eventItem = eventItem;
	}

	

	
	 @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	 public Set<OrderDetail> getOrderDetail() {
	 return orderDetail;
	 }
	
	 public void setOrderDetail(Set<OrderDetail> orderDetail) {
	 this.orderDetail = orderDetail;
	 }
}
