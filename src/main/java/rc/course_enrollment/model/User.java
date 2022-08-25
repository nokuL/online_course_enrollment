package rc.course_enrollment.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(nullable = false)
    private String username;

    @NotNull
    @Column(nullable = false, length = 100)
    private String password;

    private int active;

    private String firstName;

    private String lastName;

    private String email;

    private String phone1;

    private String phone2;

    private String permissions = "";
  @ManyToOne(fetch = FetchType.LAZY )
  @JoinColumn(name = "address_id")
    private Address address;

    @Enumerated(EnumType.STRING)
    private  Gender gender;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public User(long id, String firstName, String lastName,
                String email, String phone1, String phone2, UserRole userRole,
                String permissions, Address address, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.userRole = userRole;
        this.permissions = permissions;
        this.address = address;
        this.gender = gender;
    }

    public User(String username, String password, UserRole userRole) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }


    public List<String> getRoleList(){
        List<String>stringList = new ArrayList<>();
        if(this.userRole != null){
           stringList.add(userRole.name());
            return stringList;

        }else{
            return  null;
        }


    }

    public List<String> getPermissionList(){
        if(this.permissions.length() > 0){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }

}
