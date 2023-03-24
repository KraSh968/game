package com.orlov.gameClub.repo;

import com.orlov.gameClub.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {
//    void deleteByIdIn(Long id);
    List findAllByHalls(String name);
}
