package com.onlineQuizPortal.performanceEvaluator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PerformanceJPARepo extends JpaRepository<UserPerformance, Integer> {
    List<UserPerformance> findAllByUserId(int userId);
}
