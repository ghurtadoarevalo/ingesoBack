package mingeso.mingeso.dto;

import mingeso.mingeso.models.History;
import mingeso.mingeso.models.Reservation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class ClientDTO implements Serializable {

    private Long clientId;
    private String name;
    private String rut;
    private String contact;
    private String mail;
    private String passport;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
