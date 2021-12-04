package integration.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

import integration.domain.Order;

@MessagingGateway
public interface OrderGateway {
	@Gateway(requestChannel = "channel1")
	Order handleRequest(Message<Order> orderMessage);
}
