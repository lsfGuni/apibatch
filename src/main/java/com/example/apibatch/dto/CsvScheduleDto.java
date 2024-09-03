package com.example.apibatch.dto;

import com.example.apibatch.entity.CsvSchedule;
import lombok.*;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CsvScheduleDto {


    private String month;


    private String date;


    private String event;

    /**
     * Schedule 엔티티 반환
     * @return
     */
    public CsvSchedule toEntity(){
        return CsvSchedule.builder()
                .month(this.month)
                .date(this.date)
                .event(this.event)
                .build();

    }
}