package com.abel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tokens")
public class JwtToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 1024)
    private String token;
    private Date expiration;
    private boolean isValid;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

