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
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private Client client;

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public History () {

    }

    public History(String aditionalInfo, Client user) {
        this.aditionalInfo = aditionalInfo;
        this.client = user;
    }
}
