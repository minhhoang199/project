package com.example.chatWebsocket.model;

import com.example.chatWebsocket.model.enums.ConnectionStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "connection")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Connection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "connection_status", nullable = false)
    private ConnectionStatus connectionStatus;

    @ManyToOne
    @JoinColumn(name = "following_user",  referencedColumnName = "phone")
    @JsonIgnoreProperties(value = "messages", allowSetters = true)
    private User followingUser;

    @ManyToOne
    @JoinColumn(name = "followed_user", referencedColumnName = "phone")
    @JsonIgnoreProperties(value = "messages", allowSetters = true)
    private User followedUser;

    @Column(name = "created_by", length = 200)
    private String createdBy;

    @Column(name = "created_date")
    private Long createdDate;

    @Column(name = "modified_by", length = 200)
    private String modifiedBy;

    @Column(name = "modified_date")
    private Long modifiedDate;

}
