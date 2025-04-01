package com.example.Springboot_RestAPI.service;


import com.example.Springboot_RestAPI.model.JobPost;
import com.example.Springboot_RestAPI.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repo.findAll();
    }

    public JobPost getJob(int postId) {
        return repo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                    List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
            new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                    3, List.of("HTML", "CSS", "JavaScript", "React")),
            new JobPost(3, "Full Stack Developer", "Experience in building responsive web applications using React and in core Java and advanced Java",
                    3, List.of("HTML", "CSS", "JavaScript", "React","Core Java","Spring Boot","Hibernate")),
            new JobPost(4, "Meachine Learning", "Experience in predicting and testing data",
                    3, List.of("Python", "Numpy", "Pandas", "Matplotlib")),
            new JobPost(4, "Mobile Developer", "Experience in creating Apps",
                    3, List.of("HTML", "CSS", "JS", "React Native","Swift","Kotlin","Java"))
        ));

        repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }
}
