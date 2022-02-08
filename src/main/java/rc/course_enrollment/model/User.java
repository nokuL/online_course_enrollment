package rc.course_enrollment.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    private int active;

    private String firstName;

    private String lastName;

    private String email;

    private String phone1;

    private String phone2;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns =  @JoinColumn(name = "role_id"))
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

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
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
