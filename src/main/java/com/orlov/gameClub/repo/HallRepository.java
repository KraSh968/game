package com.orlov.gameClub.repo;

import com.orlov.gameClub.models.Hall;
import com.orlov.gameClub.models.Iron;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HallRepository extends JpaRepository<Hall, Long> {
    List<Hall> findAllByName(String s);
}
