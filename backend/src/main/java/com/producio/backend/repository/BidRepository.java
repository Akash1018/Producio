package com.producio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.producio.backend.model.Bid;

public interface BidRepository extends JpaRepository<Bid, Long> {
    
}
