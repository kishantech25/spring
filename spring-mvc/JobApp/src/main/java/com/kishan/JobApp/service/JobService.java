package com.kishan.JobApp.service;

import com.kishan.JobApp.model.JobPost;
import com.kishan.JobApp.repo.JobRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

   private final JobRepo jobRepo;

   public JobService(JobRepo jobRepo){
       this.jobRepo=jobRepo;
   }

    public List<JobPost> getAllJobs(){
           return jobRepo.getAllJobs();
    }
    public void addjob(JobPost job){
        jobRepo.addJob(job);
    }

    public JobPost getJobPost(int postId){
       return jobRepo.findById(postId);
    }



}
