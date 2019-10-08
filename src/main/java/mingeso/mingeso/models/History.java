package mingeso.mingeso.models;


import javax.persistence.*;

@Table(name = "history",schema = "usach")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "history_id", unique = true, nullable = false)
    private Long historyId;

    @Column(name = "aditionalInfo", nullable = false, length = 400)
    private String aditionalInfo;

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
}
