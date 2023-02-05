package com.example.bookMyShowBackend.Repository;

import com.example.bookMyShowBackend.Models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
}
