package com.nttdata.bootcamp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.models.FixedTermAccount;
import com.nttdata.bootcamp.repositories.IFixedTermAccountRepo;
import com.nttdata.bootcamp.services.IFixedTermAccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FixedTermAccountImpl implements IFixedTermAccountService {

	@Autowired
	IFixedTermAccountRepo ftarepo;

	@Override
	public Flux<FixedTermAccount> findAll() {
		return ftarepo.findAll();
	}

	@Override
	public Mono<FixedTermAccount> findById(String id) {
		return ftarepo.findById(id);
	}

	@Override
	public Mono<FixedTermAccount> save(FixedTermAccount fixedTermAccount) {
		// TODO Auto-generated method stub
		return ftarepo.save(fixedTermAccount);
	}

	@Override
	public Mono<Void> delete(FixedTermAccount fixedTermAccount) {
		return ftarepo.delete(fixedTermAccount);
	}

}
