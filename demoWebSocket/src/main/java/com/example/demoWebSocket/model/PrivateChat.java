package com.example.demoWebSocket.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "private_chat")
@Data
@NoArgsConstructor
public class PrivateChat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "created_at", nullable = false)
    private String createdAt;
    @Column(name = "updated_at")
    private String updatedAt;

    @OneToMany(mappedBy = "privateChat", cascade = CascadeType.ALL)
    Set<PrivateMessage>privateMessages;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "private_chat_account",
    joinColumns = { @JoinColumn(name = "private_chat_id", referencedColumnName = "id") },
    inverseJoinColumns = { @JoinColumn(name = "account_id", referencedColumnName = "id") })
    private Set<Account> accounts;


    public PrivateChat(String name, String createdAt) {
        this.name = name;
        this.createdAt = createdAt;
    }
}
