package com.gabriel.springcrud.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.springcrud.springboot.entity.Stocks;
import com.gabriel.springcrud.springboot.exception.ResourceNotFoundException;
import com.gabriel.springcrud.springboot.repository.StocksRepository;


@RestController
@RequestMapping("/stock")
public class StocksController {
	
	
	@Autowired
	private StocksRepository stockRepository;
	
	
	@GetMapping(path ="/status")
	public String check() {return "online";}
	
	// get all stocks
	@GetMapping
	public List<Stocks> getAllStocks(){
		return this.stockRepository.findAll();
	}
	
	//get stock by name
	@GetMapping("/{name}")
	public Stocks getStockByName(@PathVariable (value = "name") String name) {
		return this.stockRepository.findByName(name);
				//.orElse(ResponseEntity.notFound().build()));
		
	}
	//create stock
	@PostMapping
	public Stocks createStock(@RequestBody Stocks stock) {
		return this.stockRepository.save(stock);
	}
	
	//update stock by name
	@PutMapping("/{name}")
	public Stocks updateStock(@RequestBody Stocks stock, @PathVariable ("name") String name) {
		Stocks existing = this.stockRepository.findByName(name);
				//.orElseThrow(()-> new ResourceNotFoundException("Stock not found with name : " + name));
		existing.setName(stock.getName());
		existing.setQuotes(stock.getQuotes());
		return this.stockRepository.save(existing);
	}
	//delete stock by name
	
	@DeleteMapping("/{name}")
	public ResponseEntity<Stocks> deleteStock(@PathVariable ("name") String name){
		Stocks existing = this.stockRepository.findByName(name);
				//.orElseThrow(()-> new ResourceNotFoundException("Stock not found with name : " + name));
		this.stockRepository.delete(existing);
		return ResponseEntity.ok().build();
		
	}

}
