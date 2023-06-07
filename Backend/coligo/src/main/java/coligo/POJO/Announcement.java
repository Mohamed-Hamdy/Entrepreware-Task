package coligo.POJO;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
@NamedQuery(name = "Announcement.getAllAnnouncement", query = "select new coligo.wrapper.AnnouncementWrapper(u.id , u.instructor , u.description , u.course_name , u.course_code) from Announcement u")
@NamedQuery(name = "Announcement.getAnnouncementById", query = "select new coligo.wrapper.AnnouncementWrapper(u.id , u.instructor ,  u.description , u.course_name ) from Announcement u where u.id=:id")
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "announcement")
public class Announcement implements Serializable {
    private static final long serialVersionUID = 123456L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "instructor")
    private String instructor;

    @Column(name = "description")
    private String description;

    @Column(name = "course_name")
    private String course_name;

    @Column(name = "courseCode")
    private String course_code;


    public Announcement() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "id=" + id +
                ", instructor='" + instructor + '\'' +
                ", description='" + description + '\'' +
                ", courseName='" + course_name + '\'' +
                ", courseCode='" + course_code + '\'' +
                '}';
    }
}
