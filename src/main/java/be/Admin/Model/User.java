package be.Admin.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
	 private String username;
	 private String password;
	 private Boolean enabled;

	    public User() {
	    }

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "username" , length = 100, unique = true)
	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    @Column(name = "password" , length = 100)
	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    @Column(name = "enabled")
	    public boolean isEnabled() {
	        return enabled;
	    }

	    public void setEnabled(boolean enabled) {
	        this.enabled = enabled;
	    }

	    @Override
	    public String toString() {
	        return "User{" +
	                "username='" + username + '\'' +
	                ", password='" + password + '\'' +
	                ", enabled=" + enabled +
	                '}';
	    }
	
}
