package coligo.restImpl;

import coligo.dao.AnnouncementDao;
import coligo.constents.ColigoConstants;
import coligo.rest.AnnouncementRest;
import coligo.service.AnnouncementService;
import coligo.utils.ColigoUtils;
import coligo.wrapper.AnnouncementWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class AnnouncementRestImpl implements AnnouncementRest {
    @Autowired
    AnnouncementService announcementService;

    @Autowired
    AnnouncementDao announcementDao;

    @Override
    public ResponseEntity<String> addNewAnnouncement(Map<String, String> requestMap) {
        try {
            //System.out.println("inside AnnouncementRestImpl");
            return announcementService.addNewAnnouncement(requestMap);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //System.out.println("Before return");
        return ColigoUtils.getResponeEntity(ColigoConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<AnnouncementWrapper>> getAllAnnouncement() {
        try {
            return announcementService.getAllAnnouncement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> update(Map<String, String> requestMap) {
        try {
            return announcementService.update(requestMap);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ColigoUtils.getResponeEntity(ColigoConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> delete(Integer id) {
        try {
            return announcementService.delete(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ColigoUtils.getResponeEntity(ColigoConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }


    @Override
    public ResponseEntity<AnnouncementWrapper> getAnnouncementById(Integer id) {
        try {
            return announcementService.getAnnouncementById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new AnnouncementWrapper(), HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
