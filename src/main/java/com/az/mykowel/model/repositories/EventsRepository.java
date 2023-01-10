package com.az.mykowel.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.az.mykowel.model.entity.Events;

public interface EventsRepository extends JpaRepository<Events, Long> {
}
