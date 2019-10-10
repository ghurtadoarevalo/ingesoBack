package mingeso.mingeso.dto;

import mingeso.mingeso.models.Client;

import javax.persistence.*;
import java.io.Serializable;

public class HistoryDTO implements Serializable {

    private Long historyId;
    private String aditionalInfo;
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
}
