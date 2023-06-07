package coligo.POJO;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
@NamedQuery(name = "Quiz.getAllQuiz", query = "select new coligo.wrapper.QuizWrapper(u.id , u.instructor , u.course_name , u.course_code , u.topic , u.description , u.deadline) from Quiz u")

@NamedQuery(name = "Quiz.getQuizById", query = "select new coligo.wrapper.QuizWrapper(u.id , u.instructor , u.course_name , u.course_code , u.topic , u.description , u.deadline) from Quiz u where u.id=:id")

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "quiz")
public class Quiz implements Serializable{


    private static final long serialVersionUID = 123456L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "instructor")
    private String instructor;

    @Column(name = "course_name")
    private String course_name;

    @Column(name = "course_code")
    private String course_code;

    @Column(name = "topic")
    private String topic;

    @Column(name = "description")
    private String description;

    @Column(name = "deadline")
    private String deadline;

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


    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
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
        return "Quiz{" +
                "id=" + id +
                ", instructor='" + instructor + '\'' +
                ", course_name='" + course_name + '\'' +
                ", course_code='" + course_code + '\'' +
                ", topic='" + topic + '\'' +
                ", description='" + description + '\'' +
                ", deadline='" + deadline + '\'' +
                '}';
    }
}
