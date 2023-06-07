package coligo.serviceImpl;

import coligo.JWT.CustomerUserDetailsService;
import coligo.JWT.JwtFilter;
import coligo.POJO.Quiz;
import coligo.constents.ColigoConstants;
import coligo.dao.QuizDao;
import coligo.service.QuizService;
import coligo.utils.ColigoUtils;
import coligo.utils.EmailUtil;
import coligo.wrapper.QuizWrapper;
import coligo.wrapper.QuizWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizDao quizDao;

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
    public ResponseEntity<String> addNewQuiz(Map<String, String> requestMap) {
        log.info("Inside addNewQuiz{}", requestMap);
        try {
            if(jwtFilter.isAdmin()){
                if(validateQuizMap(requestMap, false)){
                    quizDao.save(getQuizFromMap(requestMap , false));
                    return ColigoUtils.getResponeEntity("Quiz Added Successfully", HttpStatus.OK);
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
    public ResponseEntity<List<QuizWrapper>> getAllQuiz() {
        try {
            return new ResponseEntity<>(quizDao.getAllQuiz(), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    public ResponseEntity<String> update(Map<String, String> requestMap) {
        try {
            if (jwtFilter.isAdmin()) {
                if (validateQuizMap(requestMap , true)) {

                    Optional optional = quizDao.findById(Integer.parseInt(requestMap.get("id")));

                    if (!optional.isEmpty()) {
                        quizDao.save(getQuizFromMap(requestMap,true));
                        return ColigoUtils.getResponeEntity("Quiz is updated successfully", HttpStatus.OK);

                    } else {
                        return ColigoUtils.getResponeEntity("Quiz id doesn't exist", HttpStatus.OK);
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
                Optional optional = quizDao.findById(id);
                if (!optional.isEmpty()) {
                    quizDao.deleteById(id);
                    //System.out.println("Product is deleted successfully");
                    return ColigoUtils.getResponeEntity("Quiz is deleted successfully", HttpStatus.OK);
                }
                //System.out.println("Product id doesn't exist");
                return ColigoUtils.getResponeEntity("Quiz id doesn't exist", HttpStatus.OK);
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
    public ResponseEntity<QuizWrapper> getQuizById(Integer id) {
        try {
            return new ResponseEntity<>(quizDao.getQuizById(id), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new QuizWrapper(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    private boolean validateQuizMap(Map<String, String> requestMap, boolean validateId) {
        if(requestMap.containsKey("id") && validateId){
            return true;
        }else if(!validateId){
            return true;
        }

        return false;
    }
    private Quiz getQuizFromMap(Map<String, String> requestMap, boolean isAdd) {
        log.info("Inside getQuizFromMap{}", requestMap);

        Quiz Quiz = new Quiz();
        if(isAdd){
            Quiz.setId(Integer.parseInt(requestMap.get("id")));
        }

        Quiz.setInstructor(requestMap.get("instructor"));
        Quiz.setCourse_name(requestMap.get("course_name"));

        Quiz.setCourse_code(requestMap.get("course_code"));

        Quiz.setTopic(requestMap.get("topic"));

        Quiz.setDescription(requestMap.get("description"));
        Quiz.setDeadline(requestMap.get("deadline"));


        return Quiz;
    }
}
