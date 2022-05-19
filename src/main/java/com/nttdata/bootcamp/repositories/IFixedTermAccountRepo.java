package com.nttdata.bootcamp.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcamp.models.FixedTermAccount;

public interface IFixedTermAccountRepo extends ReactiveMongoRepository<FixedTermAccount, String>{

}
