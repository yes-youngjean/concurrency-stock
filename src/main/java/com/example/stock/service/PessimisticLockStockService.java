package com.example.stock.service;

import com.example.stock.domain.Stock;
import com.example.stock.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessimisticLockStockService {

    private final StockRepository stockRepository;

    public PessimisticLockStockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    /**
     * Lock은 Transactional이 반드시 필요하다!
     * 이유
     * - 1) Lock은 Transaction 단위로 유지됌
     * - 2) Transaction이 없으면 Lock은 바로 해지됨
     * ===> '동시성 제어'는 곧 Transaction 내에서 의미를 가짐!
     * */
    @Transactional
    public void decrease(Long id,
                         Long quantity){
        Stock stock = stockRepository.findByIdWithPessimisticLock(id);

        stock.decrease(quantity);

        stockRepository.saveAndFlush(stock);
    }
}
