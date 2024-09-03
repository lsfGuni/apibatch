package com.example.apibatch.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@ToString
@Table(name = "csv")
public class CsvSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`MONTH`", length = 255)
    private String month; //월



    @Column(name = "DATE", length = 255)
    private String date; //날짜

    @Column(name = "EVENT", length = 255)
    private String event; //이벤트

}