package mingeso.mingeso.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mingeso.mingeso.models.Hotel;
import mingeso.mingeso.models.Reservation;
import mingeso.mingeso.models.RoomReservation;
import mingeso.mingeso.models.ServiceRoom;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class RoomDTO implements Serializable {

    private Long roomId;
    private int type;
    private int price;
    private int roomNumber;
    private int childCapacity;
    private int adultCapacity;
    private String imageLink;

    private Hotel hotel;
    private List<ServiceRoom> serviceRooms;
    private List<RoomReservation> roomReservations;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getChildCapacity() {
        return childCapacity;
    }

    public void setChildCapacity(int childCapacity) {
        this.childCapacity = childCapacity;
    }

    public int getAdultCapacity() {
        return adultCapacity;
    }

    public void setAdultCapacity(int adultCapacity) {
        this.adultCapacity = adultCapacity;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public List<RoomReservation> getRoomReservations() {
        return roomReservations;
    }

    public void setRoomReservations(List<RoomReservation> roomReservations) {
        this.roomReservations = roomReservations;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<ServiceRoom> getServiceRooms() {
        return serviceRooms;
    }

    public void setServiceRooms(List<ServiceRoom> serviceRooms) {
        this.serviceRooms = serviceRooms;
    }
}
