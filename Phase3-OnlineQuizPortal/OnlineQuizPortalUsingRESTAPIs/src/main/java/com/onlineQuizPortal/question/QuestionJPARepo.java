package com.onlineQuizPortal.question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionJPARepo extends JpaRepository<QuestionObject, Integer> {
}
