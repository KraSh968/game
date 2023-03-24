package com.orlov.gameClub.repo;

import com.orlov.gameClub.models.Recording;
import com.orlov.gameClub.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordingRepository extends JpaRepository<Recording, Long> {
    List<Recording> findAllByUserId(User id);
}
