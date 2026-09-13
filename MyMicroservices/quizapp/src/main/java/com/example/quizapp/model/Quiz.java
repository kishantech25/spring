package com.example.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String title;
    @ManyToMany(fetch =  FetchType.EAGER)
    private List<Question> questions;
}
