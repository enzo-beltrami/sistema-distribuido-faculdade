package com.dlenk.stock;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockModel, Integer> {
  Optional<StockModel> findById(Integer id);
}
