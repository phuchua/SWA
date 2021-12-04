package integration.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import integration.domain.Order;

@Component
@MessagingGateway
public interface OrderGateway {
	@Gateway(requestChannel = "newOrder") 
	Order handleRequest(Message<Order> orderMessage);
}
