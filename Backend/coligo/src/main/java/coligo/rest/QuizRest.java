package coligo.rest;

import coligo.wrapper.AnnouncementWrapper;
import coligo.wrapper.QuizWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping(path = "/quiz")
public interface QuizRest {
    @PostMapping(path = "/add")
    public ResponseEntity<String> addNewQuiz(@RequestBody(required = true) Map<String, String> requestMap);

    @GetMapping(path = "/get")
    public ResponseEntity<List<QuizWrapper>> getAllQuiz();

    @PostMapping(path = "/update")
    public ResponseEntity<String> update(@RequestBody(required = true) Map<String, String> requestMap);

    @PostMapping(path = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id);

    @GetMapping(path = "/getQuizById/{id}")
    public ResponseEntity<QuizWrapper> getQuizById(@PathVariable Integer id);

}
