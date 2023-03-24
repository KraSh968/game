package com.orlov.gameClub.repo;

import com.orlov.gameClub.models.Iron;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IronRepository extends JpaRepository<Iron, Long> {
    List<Iron> findAllByHallName(String s);
    List<Iron> findAllByHalls(String s);
}
