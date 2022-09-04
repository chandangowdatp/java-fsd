package com.displayinguserfeedback;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExtensionOfAPIofJPA extends JpaRepository<FeedbackFormDataModel, Integer> {
    List<FeedbackFormDataModel> findAll();
}
