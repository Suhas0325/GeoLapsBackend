package com.example.FeedBack.repository;

import com.example.FeedBack.model.FeedBackResponses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedBackResponseRepository extends JpaRepository<FeedBackResponses, Integer> {
}