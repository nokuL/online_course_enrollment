package rc.bootsecurity.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class User {
  public enum UserRole{
      ADMIN,
      TUTOR,
      STUDENT
  }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private int active;

    private String firstName;

    private String lastName;

    private String email;

    private String phone1;

    private String phone2;

    private Set<UserRole> roles = new HashSet<>();

    private String permissions = "";
  @ManyToOne(fetch = FetchType.LAZY )
  @JoinColumn(name = "address_id")
    private Address address;

    public User(long id, String username, String password, int active, String firstName, String lastName, String email, String phone1, String phone2, Set<UserRole> roles, String permissions) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.active = active;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.roles = roles;
        this.permissions = permissions;
    }

    protected User(){}

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getActive() {
        return active;
    }


    public String getPermissions() {
        return permissions;
    }

    public Set<UserRole> getRoleList(){
        if(this.roles.size() > 0){
            return this.roles;
        }
        return new HashSet<>();
    }

    public List<String> getPermissionList(){
        if(this.permissions.length() > 0){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }
}
