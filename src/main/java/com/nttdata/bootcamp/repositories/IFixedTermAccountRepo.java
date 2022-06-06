package com.nttdata.bootcamp.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcamp.models.FixedTermAccount;

import reactor.core.publisher.Flux;

public interface IFixedTermAccountRepo extends ReactiveMongoRepository<FixedTermAccount, String>{

	Flux<FixedTermAccount> findByIdCustomerPerson(String idCustomerPerson);

}