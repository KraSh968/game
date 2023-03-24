package com.orlov.gameClub.repo;

import com.orlov.gameClub.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
