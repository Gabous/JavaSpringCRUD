package com.gabriel.springcrud.springboot.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.springcrud.springboot.entity.Stocks;

@Repository
public interface StocksRepository extends JpaRepository<Stocks, Long> {
	Stocks findByName(String name);

}
