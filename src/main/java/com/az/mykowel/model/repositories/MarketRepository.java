package com.az.mykowel.model.repositories;

import com.az.mykowel.model.modules.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface MarketRepository  extends JpaRepository<Market, Long> {
    List<Market> findByCategory(String category);
    
}
