package com.dlenk.stock;

import com.dlenk.stock.DTOs.StockUpdateDTO;
import com.dlenk.error.NotFoundException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stock")
public class StockController {


  private final StockService stockService;

  @Autowired
  public StockController(StockService stockService) {
    this.stockService = stockService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<StockModel> getStockById(@Valid @PathVariable Integer id)
      throws NotFoundException {
    return ResponseEntity.ok(stockService.getStockById(id));
  }

  @GetMapping
  public ResponseEntity<List<StockModel>> getStocks() {
    return ResponseEntity.ok(stockService.getStocks());
  }

  @PostMapping
  public ResponseEntity<StockModel> postStock(@Valid @RequestBody StockModel stockModel)
      throws Exception {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(stockService.saveStock(stockModel));
  }

  @PutMapping("/{id}")
  public ResponseEntity<StockModel> putStock(@PathVariable Integer id,
                                            @Valid @RequestBody StockModel stockModel) throws NotFoundException {
    return ResponseEntity.ok(stockService.putStock(id, stockModel));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<StockModel> patchStock(@PathVariable Integer id,
                                              @Valid @RequestBody StockUpdateDTO stockUpdateDTO) throws NotFoundException {
    return ResponseEntity.ok(stockService.patchStock(id, stockUpdateDTO));
  }


  @DeleteMapping("/{id}")
  public ResponseEntity<?> removeStock(@PathVariable Integer id) throws NotFoundException {
    stockService.removeStock(id);
    return ResponseEntity.noContent().build();
  }
}
