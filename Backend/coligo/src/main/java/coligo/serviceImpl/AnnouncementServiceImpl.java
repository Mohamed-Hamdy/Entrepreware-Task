package coligo.serviceImpl;

import coligo.JWT.CustomerUserDetailsService;
import coligo.JWT.JwtFilter;
import coligo.POJO.Announcement;
import coligo.dao.AnnouncementDao;
import coligo.service.AnnouncementService;
import coligo.wrapper.AnnouncementWrapper;
import com.google.common.base.Strings;
import coligo.constents.ColigoConstants;
import coligo.utils.ColigoUtils;
import coligo.utils.EmailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    AnnouncementDao announcementDao;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    coligo.JWT.jwtUtil jwtUtil;

    @Autowired
    JwtFilter jwtFilter;
    @Autowired
    CustomerUserDetailsService customerUserDetailsService;

    @Autowired
    EmailUtil emailUtil;
    @Override
    public ResponseEntity<String> addNewAnnouncement(Map<String, String> requestMap) {
        log.info("Inside addNewAnnouncement{}", requestMap);
        try {
            if(jwtFilter.isAdmin()){
                if(validateAnnouncementMap(requestMap, false)){
                    announcementDao.save(getAnnouncementFromMap(requestMap , false));
                    return ColigoUtils.getResponeEntity("Announcement Added Successfully", HttpStatus.OK);
                }
            }else{
                return ColigoUtils.getResponeEntity(ColigoConstants.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //System.out.println(CafeConstants.SOMETHING_WENT_WRONG);
        return ColigoUtils.getResponeEntity(ColigoConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Override
    public ResponseEntity<List<AnnouncementWrapper>> getAllAnnouncement() {
        try {
            return new ResponseEntity<>(announcementDao.getAllAnnouncement(), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    public ResponseEntity<String> update(Map<String, String> requestMap) {
        try {
            if (jwtFilter.isAdmin()) {
                if (validateAnnouncementMap(requestMap , true)) {

                    Optional optional = announcementDao.findById(Integer.parseInt(requestMap.get("id")));

                    if (!optional.isEmpty()) {
                        announcementDao.save(getAnnouncementFromMap(requestMap,true));
                        return ColigoUtils.getResponeEntity("Announcement is updated successfully", HttpStatus.OK);

                    } else {
                        return ColigoUtils.getResponeEntity("Announcement id doesn't exist", HttpStatus.OK);
                    }

                }
                return ColigoUtils.getResponeEntity(ColigoConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
            } else {
                return ColigoUtils.getResponeEntity(ColigoConstants.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ColigoUtils.getResponeEntity(ColigoConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    public ResponseEntity<String> delete(Integer id) {
        try {
            if (jwtFilter.isAdmin()) {
                Optional optional = announcementDao.findById(id);
                if (!optional.isEmpty()) {
                    announcementDao.deleteById(id);
                    //System.out.println("Product is deleted successfully");
                    return ColigoUtils.getResponeEntity("Announcement is deleted successfully", HttpStatus.OK);
                }
                //System.out.println("Product id doesn't exist");
                return ColigoUtils.getResponeEntity("Announcement id doesn't exist", HttpStatus.OK);
            } else {
                return ColigoUtils.getResponeEntity(ColigoConstants.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //System.out.println(CafeConstants.SOMETHING_WENT_WRONG);
        return ColigoUtils.getResponeEntity(ColigoConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @Override
    public ResponseEntity<AnnouncementWrapper> getAnnouncementById(Integer id) {
        try {
            return new ResponseEntity<>(announcementDao.getAnnouncementById(id), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new AnnouncementWrapper(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean validateAnnouncementMap(Map<String, String> requestMap, boolean validateId) {
        if(requestMap.containsKey("id") && validateId){
            return true;
        }else if(!validateId){
            return true;
        }

        return false;
    }
    private Announcement getAnnouncementFromMap(Map<String, String> requestMap, boolean isAdd) {
        Announcement announcement = new Announcement();
        if(isAdd){
            announcement.setId(Integer.parseInt(requestMap.get("id")));
        }

        announcement.setInstructor(requestMap.get("instructor"));
        announcement.setCourse_name(requestMap.get("course_name"));
        announcement.setCourse_code(requestMap.get("course_code"));
        announcement.setDescription(requestMap.get("description"));
        return announcement;
    }

}
