package integration.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import integration.domain.Order;
import integration.gateway.OrderGateway;


@RestController
public class Controller {
	@Autowired
	private OrderGateway orderGateway;

	@RequestMapping("/order/{ordernumber}/{amount}")
	public Order sendOrder(@PathVariable("ordernumber") String ordernumber, @PathVariable("amount") int amount) {
		Message<Order> orderMessage = MessageBuilder.withPayload(new Order(ordernumber, amount)).build();
		return orderGateway.handleRequest(orderMessage);
	}
}
