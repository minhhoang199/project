package com.example.demo.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class AccountDto implements Serializable {
    private int id;
    private String username;
    private String password;
}
