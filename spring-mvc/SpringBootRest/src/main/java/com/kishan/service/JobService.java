package com.kishan.service;

import com.kishan.model.JobPost;
import com.kishan.repo.JobRepo;
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

    public JobPost updateJob(JobPost post){
        return jobRepo.updateJob(post);
    }

    public boolean deleteJob(int postId){

        return jobRepo.deleteJob(postId);

    }

    public JobPost getJobById(int postId) {
        JobPost job =jobRepo.getJob(postId);
        return job;
    }
}
