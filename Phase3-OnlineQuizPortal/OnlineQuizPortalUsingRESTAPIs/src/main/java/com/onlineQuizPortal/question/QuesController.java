package com.onlineQuizPortal.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/question")
public class QuesController {

    @Autowired
    QuesServices queService;

    // to handle api to add questions in db
    @PostMapping("/addQuestion")
    public ResponseEntity<Object> addQuestion(@RequestBody QuestionObject question){
        QuestionObject resp= queService.addQuestion(question);

        if(resp!=null)
            return new ResponseEntity<Object>(resp,HttpStatus.CREATED);
        else
            return new ResponseEntity<Object>("Error while inserting data",HttpStatus.INTERNAL_SERVER_ERROR);
    }


    // to handle api to view all questions saved db
    @GetMapping("/viewAllQuestion")
    public ResponseEntity<List<QuestionObject>> viewAllQuestion(@RequestParam(required = false) String Qname){
        try {
            List<QuestionObject> QuesList = new ArrayList<QuestionObject>();
            queService.getAllQuestion().forEach(QuesList::add);

            if(QuesList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                return new ResponseEntity<>(QuesList,HttpStatus.OK);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // to handle api to view a particular question using its id
    @GetMapping("/questionbyid/{quesId}")
    public ResponseEntity<QuestionObject> viewQuestionById(@PathVariable("quesId")  int quesId){
        Optional<QuestionObject> Questiondata = queService.getQuestionById(quesId);
        if (Questiondata.isPresent()) {
            return new ResponseEntity<>(Questiondata.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
