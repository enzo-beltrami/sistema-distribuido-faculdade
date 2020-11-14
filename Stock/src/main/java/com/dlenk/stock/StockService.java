package com.dlenk.stock;

import com.dlenk.stock.DTOs.StockUpdateDTO;
import com.dlenk.error.NotFoundException;
import com.dlenk.utils.Constants;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

  private StockMapper stockMapper;
  private StockRepository stockRepository;


  @Autowired
  public StockService(StockRepository stockRepository, StockMapper stockMapper) {
    this.stockRepository = stockRepository;
    this.stockMapper = stockMapper;

  }

  public StockModel saveStock(StockModel stockModel) {
    return stockRepository.save(stockModel);
  }

  public StockModel getStockById(Integer id) throws NotFoundException {
    return stockRepository.findById(id).orElseThrow(() -> new NotFoundException(
        Constants.ITEM_NOT_FIND));
  }

  public StockModel putStock(Integer id, StockModel stockModelRequest) throws NotFoundException {
    stockModelRequest.setId(id);
    stockRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(
            Constants.ITEM_NOT_FIND));
    return stockRepository.save(stockModelRequest);
  }

  public StockModel patchStock(Integer id, StockUpdateDTO stockUpdateDTO) throws NotFoundException {

    StockModel stockModel = stockRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(
            Constants.ITEM_NOT_FIND));
    stockMapper.updateStockFromDto(stockUpdateDTO, stockModel);
    return stockRepository.save(stockModel);

  }

  public void removeStock(Integer id) throws NotFoundException {
    StockModel stock = stockRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(
            Constants.ITEM_NOT_FIND));
    stockRepository.delete(stock);
  }

  public StockModel buyFromStock(Integer id) throws NotFoundException {
    StockModel stockModel = stockRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(
            Constants.ITEM_NOT_FIND));
    StockUpdateDTO stockUpdateDTO = new StockUpdateDTO();
    stockUpdateDTO.setQuant(stockModel.getQuant() - 1);
    stockMapper.updateStockFromDto(stockUpdateDTO, stockModel);
    return stockRepository.save(stockModel);
  }

  public List<StockModel> getStocks() {
    return stockRepository.findAll();
  }
}
