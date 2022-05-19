package com.nttdata.bootcamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.nttdata.bootcamp.models.FixedTermAccount;
import com.nttdata.bootcamp.repositories.IFixedTermAccountRepo;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@SpringBootApplication
public class BootcampServiceProductFixedtermaccountsApplication implements CommandLineRunner {

	@Autowired
	IFixedTermAccountRepo ftarepo;
	
	@Autowired
	ReactiveMongoTemplate mongoTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(BootcampServiceProductFixedtermaccountsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		mongoTemplate.dropCollection("fixedtermaccounts").subscribe();
		
		Flux.just(FixedTermAccount.builder()
				.idCustomerPerson("b1")
				.accountingBalance("100")
				.movementDay("2")
				.build()).flatMap(bs->{
						return ftarepo.save(bs);
				}).subscribe(s-> log.info("Se ingreso fixedTermAccount: "+s));
	}

}
