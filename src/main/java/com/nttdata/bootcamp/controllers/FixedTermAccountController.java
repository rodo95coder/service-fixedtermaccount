package com.nttdata.bootcamp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.models.FixedTermAccount;
import com.nttdata.bootcamp.services.IFixedTermAccountService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/fixedTermAccount")
public class FixedTermAccountController {
	
	@Autowired
	private IFixedTermAccountService ftarepo;
	
	@GetMapping("/findAll")
	public Flux<FixedTermAccount> findAll(){
		log.info("all FixedTermAccount were consulted");
		return ftarepo.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public Mono<FixedTermAccount> findById(@PathVariable String id){
		log.info("a FixedTermAccount was consulted by id");
		return ftarepo.findById(id);
	}
	
	@PutMapping("/update")
	public Mono<FixedTermAccount> update(@RequestBody FixedTermAccount fixedTermAccount){
		return ftarepo.findById(fixedTermAccount.getId()).flatMap(f->{
			f.setAccountingBalance(fixedTermAccount.getAccountingBalance());
			log.info("a FixedTermAccount was updated");
			return ftarepo.save(f);
		});
	}
	
	@PostMapping("/save")
	public Mono<FixedTermAccount> save(@RequestBody FixedTermAccount fixedTermAccount){
		log.info("a FixedTermAccount was created");
		return ftarepo.save(fixedTermAccount);
	}
	
	@DeleteMapping("/delete")
	public Mono<Void> delete(@RequestBody FixedTermAccount fixedTermAccount){
		log.info("a FixedTermAccount was deleted");
		return ftarepo.delete(fixedTermAccount);
	}

}
