package com.onlineQuizPortal.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizJPARepo extends JpaRepository<QuizObject, Integer> {
    List<QuizObject> findAll();
}
