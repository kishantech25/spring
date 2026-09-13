package com.kishan.controller;

import com.kishan.exception.ErrorResponse;
import com.kishan.exception.JobPostNotFoundException;
import com.kishan.model.JobPost;
import com.kishan.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/jobPosts")
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping
    public ResponseEntity<?> getAllJobs() {
        try {
            List<JobPost> jobs = service.getAllJobs();
            if (jobs.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.ok(jobs);
        }
        catch (JobPostNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
        catch (Exception ex){
            ErrorResponse error =new ErrorResponse(
                    LocalDateTime.now(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                    "Something Went wrong please try again"
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);

    }

        @GetMapping("/{postId}")
        public ResponseEntity<?> getJob(@PathVariable("postId") int postId) {
        try {
            JobPost job = service.getJobById(postId);
            return ResponseEntity.ok(job);
        }
        catch (JobPostNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
        catch (Exception ex){
            ErrorResponse error =new ErrorResponse(
                    LocalDateTime.now(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                    "Something Went wrong please try again");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @PostMapping
    public JobPost addJob(@RequestBody JobPost jobPost) {
        service.addjob(jobPost);
        return service.getAllJobs().get(jobPost.postId());
    }

    @PutMapping
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        return service.updateJob(jobPost);
    }

    @DeleteMapping("/{postId}")
    public String deleteJob(@PathVariable int postId) {
        String s = null;
        if (service.deleteJob(postId))
            s = "deleted";
        else
            s = " not Deleted";

        return s;
    }

}
