package com.example.apibatch.repository;


import com.example.apibatch.entity.CsvSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CsvScheduleRepository extends JpaRepository<CsvSchedule, Long> {
}
