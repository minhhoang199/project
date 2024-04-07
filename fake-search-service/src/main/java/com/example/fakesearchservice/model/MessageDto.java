package com.example.fakesearchservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MessageDto {
    private String to;
    private String toName;
    private String subject;
    private String content;
}
