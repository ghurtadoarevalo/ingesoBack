package mingeso.mingeso.models;
import javax.persistence.*;

@Entity
@Table(name = "history",schema = "usach")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "history_id", unique = true, nullable = false)
    private Long historyId;

    @Column(name = "aditionalInfo", nullable = true, length = 400)
    private String aditionalInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")

    private User user;

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public String getAditionalInfo() {
        return aditionalInfo;
    }

    public void setAditionalInfo(String aditionalInfo) {
        this.aditionalInfo = aditionalInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public History () {

    }

    public History(String aditionalInfo, User user) {
        this.aditionalInfo = aditionalInfo;
        this.user = user;
    }
}
