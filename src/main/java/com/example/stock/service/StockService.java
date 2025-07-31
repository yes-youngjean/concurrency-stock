package com.example.stock.service;

import com.example.stock.domain.Stock;
import com.example.stock.repository.StockRepository;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

//    @Transactional

    /**
     * @Transactional => DB에 한꺼번에 반영됌!
     * => 첫번째 Thread는 1을 줄였지만 DB에는 반영이 안 되서 두번째 Thread는 첫번째 Thread가 줄인 정보에 대해 알 수 없음
     */
    public synchronized void decrease(Long id,
                                      Long quantity) {
        /**
         * synchronized => 1개의 Thread만 접근 가능함
         * 단, 서버가 1대일 경우에는 유효하지만, 서버가 2대 이상인 경우부터는 사용 안함
         * */
        // Stock 조회
        Stock stock = stockRepository.findById(id).orElseThrow();
        stock.decrease(quantity);

        stockRepository.saveAndFlush(stock);

        // 재고 감소
        // 갱신된 값 저장
    }
}
