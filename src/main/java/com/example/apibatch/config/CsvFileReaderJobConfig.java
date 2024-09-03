package com.example.apibatch.config;

import com.example.apibatch.batch.CsvReader;
import com.example.apibatch.dto.CsvScheduleDto;
import com.example.apibatch.batch.CsvScheduleWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class CsvFileReaderJobConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final CsvReader csvReader;
    private final CsvScheduleWriter CsvScheduleWriter;

    public CsvFileReaderJobConfig(JobRepository jobRepository,
                                  PlatformTransactionManager transactionManager,
                                  CsvReader csvReader,
                                  CsvScheduleWriter CsvScheduleWriter) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
        this.csvReader = csvReader;
        this.CsvScheduleWriter = CsvScheduleWriter;
    }

    @Bean
    public Job csvScheduleJob() {
        return new JobBuilder("csvScheduleJob", jobRepository)
                .start(csvScheduleReaderStep())
                .build();
    }

    @Bean
    public Step csvScheduleReaderStep() {
        return new StepBuilder("csvScheduleReaderStep", jobRepository)
                .<CsvScheduleDto, CsvScheduleDto>chunk(10, transactionManager)
                .reader(csvReader.csvScheduleReader())
                .writer(CsvScheduleWriter)
                .faultTolerant()
                .skipLimit(10)
                .skip(Exception.class)
                .retryLimit(3)
                .retry(Exception.class)
                .build();
    }
}
