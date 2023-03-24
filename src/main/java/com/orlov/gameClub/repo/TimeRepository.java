package com.orlov.gameClub.repo;

import com.orlov.gameClub.models.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Long> {
}
