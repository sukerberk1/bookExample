package com.example.jpademo.domain.review;

import com.example.jpademo.domain.review.identity.ReviewId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Review {
    @EmbeddedId
    ReviewId id;
    private String text;
}
