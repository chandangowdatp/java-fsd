package com.onlineQuizPortal.performanceEvaluator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PerformanceServices {
    @Autowired
    PerformanceJPARepo performanceJPARepo;

    public UserPerformance addPerformance(UserPerformance userPerformance) {
        return performanceJPARepo.save(userPerformance);
    }

    public List<UserPerformance> fetchStats(int userId) {
        return performanceJPARepo.findAllByUserId(userId);
    }
}
