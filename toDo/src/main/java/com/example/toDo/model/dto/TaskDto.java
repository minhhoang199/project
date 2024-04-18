package com.example.toDo.model.dto;

import com.example.toDo.model.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private String id;
    @NotBlank
    private String content;
    @NotBlank
    private LocalDate date;
    private State taskState;
}
