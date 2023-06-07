package coligo.restImpl;

import coligo.constents.ColigoConstants;
import coligo.dao.AnnouncementDao;
import coligo.dao.QuizDao;
import coligo.rest.QuizRest;
import coligo.service.QuizService;
import coligo.utils.ColigoUtils;
import coligo.wrapper.QuizWrapper;
import coligo.wrapper.QuizWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class QuizRestImpl implements QuizRest {

    @Autowired
    QuizService quizService;

    @Autowired
    QuizDao quizDao;

    @Override
    public ResponseEntity<String> addNewQuiz(Map<String, String> requestMap) {
        try {
            //System.out.println("inside AnnouncementRestImpl");
            return quizService.addNewQuiz(requestMap);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //System.out.println("Before return");
        return ColigoUtils.getResponeEntity(ColigoConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<QuizWrapper>> getAllQuiz() {
        try {
            return quizService.getAllQuiz();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> update(Map<String, String> requestMap) {
        try {
            return quizService.update(requestMap);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ColigoUtils.getResponeEntity(ColigoConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> delete(Integer id) {
        try {
            return quizService.delete(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ColigoUtils.getResponeEntity(ColigoConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }


    @Override
    public ResponseEntity<QuizWrapper> getQuizById(Integer id) {
        try {
            return quizService.getQuizById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new QuizWrapper(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
