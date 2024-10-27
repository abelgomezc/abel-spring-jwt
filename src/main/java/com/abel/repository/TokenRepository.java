package com.abel.repository;


import com.abel.model.JwtToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<JwtToken,Long> {
    Optional<JwtToken> findByToken(String jwt);
}
