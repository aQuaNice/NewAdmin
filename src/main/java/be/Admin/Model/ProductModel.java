//package be.Admin.Model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//
//import org.hibernate.validator.constraints.NotBlank;
//
//
//@Entity
//@Table(name = "tbm_item")
//public class ProductModel {
//	private long lcid;
//	
//	@Column(name="idmenu")
//	@NotNull()
//	private long lcidmenu;
//	
//	@Column(name="deschead")
//	@NotBlank()	
//	private String lcdeschead;
//	
//	@Column(name="desccont")
//	@NotBlank()
//	private String lcdesccont;
//	
//	@Column(name="itmprice")
//	@NotNull()	
//	private float lcitmprice;
//	
//	private ProductModelKategory category;
//	
//	
//		//	
////	
//		public ProductModel() {
//		}
////	
//	public ProductModel(String name, String description, float price, ProductModelKategory lcategory) {
//        this.lcdeschead = name;
//        this.lcdesccont = description;
//        this.lcitmprice = price;
//        this.category = lcategory;
//    }
//	
//	
//
//	 
//	@Id
//	@GeneratedValue
//	@Column(name="id")
//	public long getLcid() {
//		return lcid;
//	}
//	
//	
//	@ManyToOne
//    @JoinColumn(name = "idmenu")
//	public ProductModelKategory getCategory() {
//		return category;
//	}
//	public void setCategory(ProductModelKategory category) {
//		this.category = category;
//	}
//	
////	@ManyToOne
////    @JoinColumn(name = "book_category_id")
////    public BookCategory getBookCategory() {
////        return bookCategory;
////    }
////	
//	
//	
//	
////	 @ManyToOne
////	    @JoinColumn(name = "idmenu")
////	    public ProductModelKategory getCategory() {
////	        return category;
////	    }
////	
////	@NotBlank()
//	
//	
//	
//	
//	
////	
////	public ProductModel(){
////		
////	}
////	
////	public ProductModel(String lcdeschead){
////		this.lcdeschead = lcdeschead;
////		
////	}
//	
//	
//
//	public void setLcid(long lcid) {
//		this.lcid = lcid;
//	}
//
//
//	public long getLcidmenu() {
//		return lcidmenu;
//	}
//
//	public void setLcidmenu(long lcidmenu) {
//		this.lcidmenu = lcidmenu;
//	}
//
//	public String getLcdeschead() {
//		return lcdeschead;
//	}
//
//	public void setLcdeschead(String lcdeschead) {
//		this.lcdeschead = lcdeschead;
//	}
//
//	public String getLcdesccont() {
//		return lcdesccont;
//	}
//
//	public void setLcdesccont(String lcdesccont) {
//		this.lcdesccont = lcdesccont;
//	}
//
//	public String getLcitemicon() {
//		return lcitemicon;
//	}
//
//	public void setLcitemicon(String lcitemicon) {
//		this.lcitemicon = lcitemicon;
//	}
//
//	public float getLcitmprice() {
//		return lcitmprice;
//	}
//
//	public void setLcitmprice(float lcitmprice) {
//		this.lcitmprice = lcitmprice;
//	}
//
//	public String getLcitmsat() {
//		return lcitmsat;
//	}
//
//	public void setLcitmsat(String lcitmsat) {
//		this.lcitmsat = lcitmsat;
//	}
//
//	public float getLcitmqty() {
//		return lcitmqty;
//	}
//
//	public void setLcitmqty(float lcitmqty) {
//		this.lcitmqty = lcitmqty;
//	}
//
//	public String getLcitmvol() {
//		return lcitmvol;
//	}
//
//	public void setLcitmvol(String lcitmvol) {
//		this.lcitmvol = lcitmvol;
//	}
//
//	public int getLcitmtype() {
//		return lcitmtype;
//	}
//
//	public void setLcitmtype(int lcitmtype) {
//		this.lcitmtype = lcitmtype;
//	}
//
//	public int getLcstat() {
//		return lcstat;
//	}
//
//	public void setLcstat(int lcstat) {
//		this.lcstat = lcstat;
//	}
//
////	public ProductModel(String lcdeschead, ProductModelKategory productmk) {
////	        this.lcdeschead = lcdeschead;
////	        this.productmk = productmk;
////	    }
////	
//////	
////	 @ManyToOne
////	    @JoinColumn(name = "id")
////
////		public ProductModelKategory getProductmk() {
////		return productmk;
////	}
//////
////	public void setProductmk(ProductModelKategory productmk) {
////		this.productmk = productmk;
////	}
////
////	 
////	    public ProductModelKategory getProdutCategory() {
////	        return productmk;
////	    }
////
////	    public void setProdutCategory(ProductModelKategory productmk) {
////	        this.productmk = productmk;
////	    }
//	 
//	
//	
//	
//	
//	
//	@Column(name="itemicon")
//	@NotBlank()	
//	private String lcitemicon;
//	
//	
//	
//	@Column(name="itmsat")
//	@NotBlank()
//	private String lcitmsat;
//	
//	@Column(name="itmqty")
//	@NotNull()	
//	private float lcitmqty;
//	
//	@Column(name="itmvol")
//	@NotBlank()
//	private String lcitmvol;
//	
//	@Column(name="itmtype")
//	@NotNull()
//	private int lcitmtype;
//	
//	@Column(name="stat")
//	@NotNull()
//	private int lcstat;
//
//}
