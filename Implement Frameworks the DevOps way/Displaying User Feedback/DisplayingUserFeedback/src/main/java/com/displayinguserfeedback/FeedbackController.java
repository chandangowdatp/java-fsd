package com.displayinguserfeedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FeedbackController {
    @Autowired
    ExtensionOfAPIofJPA jpaAPI;

    @GetMapping("/saveFeedback")
    @ResponseBody
    public ResponseEntity<String> saveFeedback(FeedbackFormDataModel feedbackFormDataObject) {
        jpaAPI.save(feedbackFormDataObject);
        return ResponseEntity.ok("Feedback saved successfully");
    }

    @GetMapping("/viewFeedbacks")
    @ResponseBody
    public ResponseEntity<List<FeedbackFormDataModel>> viewFeedbacks() {
        List<FeedbackFormDataModel> feedbacksList = null;
        try {
            feedbacksList= jpaAPI.findAll();
            /*System.out.println("Printing List");
            for (int index = 0; index < feedbacksList.size(); index++) {
                System.out.println(feedbacksList.get(index).getFirstName());
            }
            System.out.println("List ended");*/
        }
        catch (Exception e) {
            System.out.println("Error Occured: ");
            e.printStackTrace();

        }
        return ResponseEntity.ok().body(feedbacksList);
    }
}
