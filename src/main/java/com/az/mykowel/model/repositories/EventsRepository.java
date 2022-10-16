package com.az.mykowel.model.repositories;

import com.az.mykowel.model.modules.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Events, Long> {
}
