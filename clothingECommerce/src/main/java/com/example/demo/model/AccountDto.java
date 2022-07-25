package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class AccountDto implements Serializable {
    private int id;
    private String userName;
    private String password;
}
