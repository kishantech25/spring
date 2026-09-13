package com.kishan.repo;


import com.kishan.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class JobRepo {

    private List<JobPost> jobs = new CopyOnWriteArrayList<>();

    public JobRepo() {

        jobs.add(new JobPost(
                101,
                "Java Backend Developer",
                "Develop REST APIs using Spring Boot and Microservices.",
                2,
                Arrays.asList("Java", "Spring Boot", "MySQL", "Docker", "Git")
        ));

        jobs.add(new JobPost(
                102,
                "Full Stack Developer",
                "Develop enterprise web applications.",
                3,
                Arrays.asList("Java", "Angular", "Spring Boot", "MongoDB")
        ));

        jobs.add(new JobPost(
                103,
                "Python Developer",
                "Build AI and ML applications.",
                1,
                Arrays.asList("Python", "Django", "TensorFlow", "AWS")
        ));

        jobs.add(new JobPost(
                104,
                "DevOps Engineer",
                "Manage CI/CD pipelines and cloud deployment.",
                4,
                Arrays.asList("Docker", "Kubernetes", "Jenkins", "AWS")
        ));

        jobs.add(new JobPost(
                105,
                "Cloud Engineer",
                "Deploy scalable cloud applications.",
                3,
                Arrays.asList("AWS", "Terraform", "Docker", "Linux")
        ));

        jobs.add(new JobPost(
                106,
                "Frontend Developer",
                "Develop responsive UI using Angular.",
                2,
                Arrays.asList("Angular", "HTML5", "CSS3", "JavaScript")
        ));

        jobs.add(new JobPost(
                107,
                "React Developer",
                "Build SPA applications using React.",
                2,
                Arrays.asList("React", "JavaScript", "Redux", "Node.js")
        ));

        jobs.add(new JobPost(
                108,
                "Data Engineer",
                "Build ETL pipelines for enterprise data.",
                5,
                Arrays.asList("Python", "Apache Kafka", "Spark", "AWS")
        ));

        jobs.add(new JobPost(
                109,
                "Microservices Developer",
                "Develop distributed applications.",
                3,
                Arrays.asList("Java", "Spring Boot", "Microservices", "Docker", "Kubernetes")
        ));

        jobs.add(new JobPost(
                110,
                "Software Engineer",
                "Design and develop enterprise software.",
                1,
                Arrays.asList("Java", "SQL", "Git", "Spring")
        ));

        jobs.stream().forEach(System.out::println);
    }

    // Return all jobs
    public List<JobPost> getAllJobs() {
        return jobs;
    }

    // Add new job
    public void addJob(JobPost job) {
        jobs.add(job);
        System.out.println("job Added in JobRepo");
    }

    // Find job by Id
    public JobPost getJob(int postId) {
        return jobs.stream()
                .filter(job -> job.postId() == postId)
                .findFirst()
                .orElse(null);
    }

    // Delete job
    public boolean deleteJob(int postId) {

        boolean b = jobs.removeIf(job -> job.postId() == postId);
        return b;
    }

    // Update job
    public JobPost  updateJob(JobPost updatedJob) {

        for (int i = 0; i < jobs.size(); i++) {

            if (jobs.get(i).postId() == updatedJob.postId()) {

                jobs.set(i, updatedJob);
            }
        }
        return updatedJob;
    }
}
