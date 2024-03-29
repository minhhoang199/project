package com.example.demo.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CategoryDto implements Serializable {
    private Long id;
    @NotEmpty
    @Length(min = 5)
    private String name;

    private boolean isEdit = false;

    public CategoryDto(String name) {
        this.name = name;
    }
}
