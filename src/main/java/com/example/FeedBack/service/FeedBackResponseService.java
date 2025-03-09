package com.example.FeedBack.service;

import com.example.FeedBack.model.FeedBackQuestion;
import com.example.FeedBack.model.FeedBackResponses;
import com.example.FeedBack.repository.FeedBackResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedBackResponseService {

    @Autowired
    private FeedBackResponseRepository feedBackResponsesRepository;

    public FeedBackResponses saveResponse(FeedBackResponses response) {
        // Validate response based on question type
        FeedBackQuestion question = response.getQuestion();
        if ("rating".equals(question.getQuestionType())) {
            if (response.getResponseValue() == null || response.getResponseValue() < 1 || response.getResponseValue() > 10) {
                throw new IllegalArgumentException("Rating value must be between 1 and 10 for rating-type questions.");
            }
        } else if ("text".equals(question.getQuestionType())) {
            if (response.getResponseText() == null || response.getResponseText().trim().isEmpty()) {
                throw new IllegalArgumentException("Text response is required for text-type questions.");
            }
        } else {
            throw new IllegalArgumentException("Invalid question type.");
        }

        return feedBackResponsesRepository.save(response);
    }
}