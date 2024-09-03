package com.example.apibatch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/batch")
public class CsvBatchController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job csvScheduleJob;

    @PostMapping("/csvrun")
    public String runBatchJob() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("startAt", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(csvScheduleJob, jobParameters);
            return "Batch job has been invoked";
        } catch (Exception e) {
            e.printStackTrace();
            return "Batch job failed: " + e.getMessage();
        }
    }
}
