package coligo.dao;

import coligo.POJO.Quiz;
import coligo.wrapper.QuizWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuizDao extends JpaRepository<Quiz, Integer> {
    
    List<QuizWrapper> getAllQuiz();

    QuizWrapper getQuizById(@Param("id") Integer id);

}
