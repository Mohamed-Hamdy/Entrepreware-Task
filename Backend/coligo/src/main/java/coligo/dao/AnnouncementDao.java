package coligo.dao;

import coligo.POJO.Announcement;
import coligo.POJO.Quiz;
import coligo.wrapper.AnnouncementWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AnnouncementDao extends JpaRepository<Announcement, Integer> {

    List<AnnouncementWrapper> getAllAnnouncement();

    AnnouncementWrapper getAnnouncementById(@Param("id") Integer id);

}
