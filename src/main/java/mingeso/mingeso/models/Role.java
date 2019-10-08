package mingeso.mingeso.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "role",schema = "usach")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "role_id", unique = true, nullable = false)
    private Long roleId;

    //0: Usuario natural;
    //1: Recepcionista
    //2: Administrador (dueño)
    @Column(name = "type", nullable = false, length = 5)
    private int type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
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
}
