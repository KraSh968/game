package com.orlov.gameClub.repo;

import com.orlov.gameClub.models.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data, Long> {
}
