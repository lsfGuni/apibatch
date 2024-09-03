package com.example.apibatch.batch;

import com.example.apibatch.dto.CsvScheduleDto;
import com.example.apibatch.entity.CsvSchedule;
import com.example.apibatch.repository.CsvScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class CsvScheduleWriter implements ItemWriter<CsvScheduleDto> {

    private final CsvScheduleRepository scheduleRepository;

    @Override
    public void write(Chunk<? extends CsvScheduleDto> items) throws Exception {
        List<CsvSchedule> scheduleList = new ArrayList<>();

        items.forEach(getScheduleDto -> {
            CsvSchedule schedule = getScheduleDto.toEntity();
            scheduleList.add(schedule);
        });

        scheduleRepository.saveAll(scheduleList);
    }
}