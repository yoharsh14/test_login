package com.example.LoginTestApplication.Entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Role_Master")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(name="roleName")
    private String roleName;   // e.g., "USER", "ADMIN"
    @Column(name="authority")
    private String authority;  // e.g., "ROLE_USER", "ROLE_ADMIN"

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    @OneToMany(mappedBy = "roles")
    private Set<UserEntity> users;   // One role can be assigned to multiple users


}
