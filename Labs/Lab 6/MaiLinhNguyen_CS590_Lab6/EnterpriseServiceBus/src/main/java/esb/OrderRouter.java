package esb;
public class OrderRouter {
    public String route(Order order) {
        String destinationChannel = null;
        if(order.getOrderType() == OrderType.International){
            destinationChannel = "shippinginternationalchannel";
        }else {
            if (order.getAmount() > 175)
                destinationChannel = "shippingtomorrowchannel";
            else
                destinationChannel = "shippingchannel";
        }
        return destinationChannel;
    }
}