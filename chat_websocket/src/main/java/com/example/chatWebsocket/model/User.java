package com.example.chatWebsocket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 50, nullable = false)
    private String username;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @Column(name = "phone", length = 20, nullable = false)
    private String phone;

    @Column(name = "created_at", nullable = false)
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @JsonIgnore
    @ManyToMany(mappedBy = "users")
    private Set<Conversation> conversations = new HashSet<>();


    @OneToMany(mappedBy = "followingUser", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = { "followingUser", "followedUser" }, allowSetters = true)
    private Set<Connection> followingConnections = new HashSet<>();

    @OneToMany(mappedBy = "followedUser", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = { "followingUser", "followedUser" }, allowSetters = true)
    private Set<Connection> followedConnections = new HashSet<>();

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private Set<Message> messages = new HashSet<>();

    @Column(name = "created_by", length = 200)
    private String createdBy;

    @Column(name = "created_date")
    private Long createdDate;

    @Column(name = "modified_by", length = 200)
    private String modifiedBy;

    @Column(name = "modified_date")
    private Long modifiedDate;
}
