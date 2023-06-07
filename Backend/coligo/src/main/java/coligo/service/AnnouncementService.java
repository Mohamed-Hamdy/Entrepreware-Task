package coligo.service;

import coligo.POJO.Announcement;
import coligo.wrapper.AnnouncementWrapper;
import coligo.wrapper.QuizWrapper;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


public interface AnnouncementService {
     ResponseEntity<String> addNewAnnouncement(Map<String, String> requestMap);
     ResponseEntity<List<AnnouncementWrapper>> getAllAnnouncement();


     ResponseEntity<String> update(Map<String, String> requestMap);

     ResponseEntity<String> delete(Integer id);

     ResponseEntity<AnnouncementWrapper> getAnnouncementById(Integer id);

}
