package mingeso.mingeso.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "day",schema = "usach")
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "day_id", unique = true, nullable = false)
    private Long dayId;

    @Column(name = "date", nullable = false, length = 50)
    private Date date;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="reservation_id", nullable=true)
    private Reservation reservation;

    public Long getDayId() {
        return dayId;
    }

    public void setDayId(Long dayId) {
        this.dayId = dayId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
