package coligo.service;

import coligo.wrapper.QuizWrapper;
import coligo.wrapper.QuizWrapper;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface QuizService {
    ResponseEntity<String> addNewQuiz(Map<String, String> requestMap);
    ResponseEntity<List<QuizWrapper>> getAllQuiz();


    ResponseEntity<String> update(Map<String, String> requestMap);

    ResponseEntity<String> delete(Integer id);

    ResponseEntity<QuizWrapper> getQuizById(Integer id);

}
