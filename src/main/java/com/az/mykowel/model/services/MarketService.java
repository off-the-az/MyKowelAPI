package com.az.mykowel.model.services;

import com.az.mykowel.model.entity.Market;
import com.az.mykowel.model.repositories.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MarketService {

    @Autowired
    private MarketRepository marketRepository;
    public List<Market> listAllMarket() {
        return marketRepository.findAll();
    }

    public List<Market> listAllMarketByCategory(String category) {
        return marketRepository.findByCategory(category);
    }

    public void saveMarket(Market item) {
        marketRepository.save(item);
    }

    public Optional<Market> getMarketById(Long id) {
        return marketRepository.findById(id);
    }

    public Market getItemById(Long Id){
        return marketRepository.getById(Id);
    }

    public void deleteMarket(Long id) {
        marketRepository.deleteById(id);
    }
}
