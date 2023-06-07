package coligo.wrapper;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class QuizWrapper {
    Integer id;
    String instructor;
    String course_name;
    String course_code;
    String topic;
    String description;
    String deadline;

    public QuizWrapper(Integer id, String instructor , String course_name , String course_code ,  String topic ,  String description ,  String deadline ) {
        this.id = id;
        this.instructor = instructor;
        this.course_name = course_name;
        this.course_code = course_code;
        this.topic = topic;
        this.description = description;
        this.deadline = deadline;
    }

    public QuizWrapper(Integer id, String course_name) {
        this.id = id;
        this.course_name = course_name;
    }

    public QuizWrapper(Integer id, String instructor , String course_name , String topic ) {
        this.id = id;
        this.instructor = instructor;
        this.course_name = course_name;
        this.topic = topic;
    }
}
