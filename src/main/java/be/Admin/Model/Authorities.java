package be.Admin.Model;
import javax.persistence.*;

import javax.persistence.*;

/**
 * Created by josescalia on 23/03/15.
 */
@Entity
@Table(name = "authorities",uniqueConstraints =@UniqueConstraint(columnNames = {"username","authority"}))
public class Authorities {
	
	private static final long serialVersionUID = 1L;

	  @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	  
//  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
  
  
	  private String username;
	  private String authority;

	  @Column(name = "ID", length = 30)  
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

@Column(name = "getUsername", length = 30)  
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
@Column(name = "authority", length = 30)
public String getAuthority() {
	return authority;
}
public void setAuthority(String authority) {
	this.authority = authority;
}
	

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "ID", length = 30)
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

//    @ManyToOne
//    @JoinColumn(name = "username")
//    public User getUser() {
//        return user;
//    }

//    public void setUser(User user) {
//        this.user = user;
//    }

//    @Column(name = "authority", length = 30, nullable = false)
//    public String getAuthority() {
//        return authority;
//    }
//
//    public void setAuthority(String authority) {
//        this.authority = authority;
//    }

//    @Column(name = "username", length = 100, nullable = false)
//	private String username;
//  
//    
//   
//    
//    public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}


//    @Override
//    public String toString() {
//    	
//    	
//        return "Authorities{" +
//                "user=" + user +
//                ", authority='" + authority + '\'' +
//                '}';
//    }
}