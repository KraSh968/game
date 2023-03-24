package com.orlov.gameClub.repo;

import com.orlov.gameClub.models.Pc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PcRepository extends JpaRepository<Pc, Long> {
}
