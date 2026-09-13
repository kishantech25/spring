package com.telusko.spring_data.repo;

import com.telusko.spring_data.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {
}
