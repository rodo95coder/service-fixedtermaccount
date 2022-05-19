package com.nttdata.bootcamp.services;

import com.nttdata.bootcamp.models.FixedTermAccount;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IFixedTermAccountService {
	public Flux<FixedTermAccount> findAll();
	public Mono<FixedTermAccount> findById(String id);
	public Mono<FixedTermAccount> save(FixedTermAccount fixedTermAccount);
	public Mono<Void> delete(FixedTermAccount fixedTermAccount);
}
