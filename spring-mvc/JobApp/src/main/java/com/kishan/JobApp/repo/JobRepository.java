package com.kishan.JobApp.repo;

import com.kishan.JobApp.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobPost,Integer> {
}
