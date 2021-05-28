package com.atos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atos.model.Product;
import com.atos.service.PrepaidService;

public class PrepaidController {

	private final PrepaidService prepaidService;

	@Autowired
	public PrepaidController(PrepaidService prepaidService) {
		this.prepaidService = prepaidService;
	}

//http://localhost:8080/getDiscount?type=diamondCard
	@RequestMapping(value = "/getDiscount", method = RequestMethod.GET, produces = "application/json")
	public Product getQuestions(@RequestParam(required = true) String type) {
		Product product = new Product();
		product.setType(type);
		prepaidService.getProductDiscount(product);

		return product;
	}

}
