package coligo.wrapper;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class AnnouncementWrapper {
    Integer id;
    String instructor;
    String description;
    String course_name;
    String course_code;

    public AnnouncementWrapper(Integer id, String instructor , String description , String course_name , String course_code ) {
        this.id = id;
        this.instructor = instructor;
        this.description = description;
        this.course_name = course_name;
        this.course_code = course_code;

    }

    public AnnouncementWrapper(Integer id, String course_name) {
        this.id = id;
        this.course_name = course_name;
    }

    public AnnouncementWrapper(Integer id, String instructor, String description, String course_name) {
        this.id = id;
        this.instructor = instructor;
        this.description = description;
        this.course_name = course_name;
    }
}
