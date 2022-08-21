package com.example.demoWebSocket.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "username",length = 50, nullable = false)
    private String username;
    @Column(name = "password",length = 20, nullable = false)
    private String password;
    @Column(name = "phone",length = 20, nullable = false)
    private String phone;
    @Column(name = "createdAt", nullable = false)
    private String created_at;
    @Column(name = "updatedAt")
    private String updated_at;

    @ManyToMany(mappedBy = "accounts")
    @JsonBackReference
    private Set<PrivateChat> privateChats;
}
