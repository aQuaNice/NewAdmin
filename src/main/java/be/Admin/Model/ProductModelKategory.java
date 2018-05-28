//package be.Admin.Model;
//
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import org.hibernate.validator.constraints.NotBlank;
//
//
//
//
//@Entity
//@Table(name = "tbm_menu")
//public class ProductModelKategory {	
//	
////	@NotBlank()
//	private long lcid;
//	
//	@Column(name="desc")
//	@NotBlank()
//	private String lcdesc;
//	
//	
//	private Set<ProductModel> product;
//	
//	
//	
//	public ProductModelKategory(){}
//	
//	public ProductModelKategory(String lcdesc) {
//	        this.lcdesc = lcdesc;
//	    }
//	    
//	    
////	    public Set<ProductModel> getProduct() {
////			return product;
////		}
////
////
////		public void setProduct(Set<ProductModel> product) {
////			this.product = product;
////		}
////	    
//	    
//	    @Id
//	    @Column(name="id")
//	    @GeneratedValue
//	    public long getLcid() {
//			return lcid;
//		}
//
//		public void setLcid(long lcid) {
//			this.lcid = lcid;
//		}
//	    
//		
//		
////		@OneToMany(mappedBy = "bookCategory", cascade = CascadeType.ALL)
////	    public Set<Book> getBooks() {
////	        return books;
////	    }
////		
//	    
////	    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//	    
//	    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
//	    public Set<ProductModel> getProducts() {
//	        return product;
//	    }
//	  
//	    
//	    
//	    public Set<ProductModel> getProduct() {
//			return product;
//		}
//
//		public void setProduct(Set<ProductModel> product) {
//			this.product = product;
//		}
//
//	    
//		
//		@Override
//	    public String toString() {
//	        String result = String.format(
//	                "Category[id=%d, name='%s']%n",lcid, lcdesc);
//	        if (product != null) {
//	            for(ProductModel prod : product) {
//	                result += String.format(
//	                        "Book[id=%d, name='%s']%n",
//	                        prod.getLcid(), prod.getLcdeschead());
//	            }
//	        }
//
//	        return result;
//	    }
//	    
////		@GeneratedValue(strategy = GenerationType.AUTO)
//	    
////
////	    @OneToMany(mappedBy = "idmenu", cascade = CascadeType.ALL)
////		public Set<ProductModel> getProductmodels() {
////			return productmodels;
////		}
////
////		public void setProductmodels(Set<ProductModel> productmodels) {
////			productmodels = productmodels;
////		}
////
////	    @Override
////	    public String toString() {
////	        String result = String.format(
////	                "Category[id=%d, name='%s']%n",lcid, lcdesc);
////	        if (productmodels != null) {
////	            for(ProductModel Productmd : productmodels) {
////	                result += String.format(
////	                        "Book[id=%d, name='%s']%n",Productmd.getLcid(), Productmd.getLcdeschead());
////	            }
////	        }
////
////	        System.err.println(result);
////	        return result;
////	    }
////	
//	
////	
//	    
//
//
//		public String getLcdesc() {
//			return lcdesc;
//		}
//
//		public void setLcdesc(String lcdesc) {
//			this.lcdesc = lcdesc;
//		}
//
//		public String getLcmnuicon() {
//			return lcmnuicon;
//		}
//
//		public void setLcmnuicon(String lcmnuicon) {
//			this.lcmnuicon = lcmnuicon;
//		}
//
//		public String getLcstat() {
//			return lcstat;
//		}
//
//		public void setLcstat(String lcstat) {
//			this.lcstat = lcstat;
//		}
//
//	@Column(name="mnuicon")
//	@NotBlank()
//	private String lcmnuicon;
//
//	
//	@Column(name="stat")
//	@NotBlank()
//	private String lcstat;
//	
//	
//}
