package be.Admin.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tbm_menu")
public class ProductCategory {

    private int id;
	private String desc;
	private String mnuicon;
	private int stat;   
	private Set<Product> products;

	public ProductCategory(){
    }
    public ProductCategory(String name) {
        this.desc = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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


    @OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL)
    public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

    @Override
    public String toString() {
        String result = String.format(
                "Category[id=%d, name='%s']%n",
                id, desc);
        if (products != null) {
            for(Product product : products) {
                result += String.format(
                        "Book[id=%d, name='%s']%n",
                        product.getId(), product.getDeschead());
            }
        }

        System.err.println(result);
        return result;
    }
}
