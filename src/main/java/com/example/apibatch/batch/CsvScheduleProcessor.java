package com.example.apibatch.batch;


import com.example.apibatch.dto.CsvScheduleDto;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CsvScheduleProcessor implements ItemProcessor<CsvScheduleDto, CsvScheduleDto> {

    @Override
    public CsvScheduleDto process(CsvScheduleDto item) throws Exception {
        // Process the item here if needed
        return item;
    }
}
