package com.telusko.spring_data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int postId;
    @Column
    private String postProfile;
    @Column
    private String postDesc;
    @Column
    private int reqExperience;

    private List<String> postTechStack;

}
