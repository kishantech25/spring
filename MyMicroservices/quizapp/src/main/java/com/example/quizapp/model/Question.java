package com.example.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String category;
    @Column
    private String difficultyLevel;
    @Column
    private String option1;
    @Column
    private String option2;
    @Column
    private String option3;
    @Column
    private String option4;
    @Column
    private String questionTitle;
    @Column
    private String rightAnswer;

}
