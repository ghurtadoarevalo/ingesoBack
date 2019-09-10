package mingeso.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Table(name = "career",schema = "usach")
@Entity

public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "career_id", unique = true, nullable = false)
    private Long careerId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "career", cascade = CascadeType.ALL)
    private Set<Student> students;

    public Career() {
    }

    public Career(String name) {
        this.name = name;
    }

    public Long getCareerId() {
        return careerId;
    }

    public void setCareerId(Long careerId) {
        this.careerId = careerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
