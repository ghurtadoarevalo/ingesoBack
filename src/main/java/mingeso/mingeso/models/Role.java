package mingeso.mingeso.models;

import javax.persistence.*;

@Entity
@Table(name = "role",schema = "usach")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "role_id", unique = true, nullable = false)
    private Long roleId;

    @Column(name = "type", nullable = false, length = 5)
    private int type;

    @OneToOne(mappedBy = "role")
    private User user;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Role() {

    }

    public Role(int type, User user) {
        this.type = type;
        this.user = user;
    }
}
