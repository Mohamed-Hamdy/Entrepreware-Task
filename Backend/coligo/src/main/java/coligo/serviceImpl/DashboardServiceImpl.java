package coligo.serviceImpl;

import coligo.dao.AnnouncementDao;
import coligo.dao.QuizDao;
import coligo.service.DashboardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    AnnouncementDao announcementDao;



    @Override
    public ResponseEntity<Map<String, Object>> getData() {
        System.out.println("inside Dashboard");

        Map<String , Object> map = new HashMap<>();
        map.put("quiz" , quizDao.getAllQuiz());
        map.put("announcement" , announcementDao.getAllAnnouncement());
        return new ResponseEntity<>(map , HttpStatus.OK);
    }
}
