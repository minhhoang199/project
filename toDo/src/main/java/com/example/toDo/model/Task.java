package com.example.toDo.model;

import com.example.toDo.model.enums.State;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy")
    private LocalDate date;
    @Column
    @Enumerated(EnumType.STRING)
    private State taskState;
}
