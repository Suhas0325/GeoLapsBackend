package com.example.FeedBack.controller;

import com.example.FeedBack.model.FeedBackResponses;
import com.example.FeedBack.service.FeedBackResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feedback/responses")
public class FeedBackResponsesController {

    @Autowired
    private FeedBackResponseService feedBackResponsesService;

    @PostMapping
    public ResponseEntity<FeedBackResponses> submitResponse(@RequestBody FeedBackResponses response) {
        try {
            FeedBackResponses savedResponse = feedBackResponsesService.saveResponse(response);
            return ResponseEntity.ok(savedResponse);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null); // Return 400 Bad Request for invalid input
        }
    }
}