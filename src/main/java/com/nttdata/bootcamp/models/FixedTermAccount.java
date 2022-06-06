package com.nttdata.bootcamp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "fixedtermaccounts")
@Builder
public class FixedTermAccount {
	@Id
	private String id;
	private String idCustomerPerson;
	private String accountingBalance;
	private String movementDay;
}