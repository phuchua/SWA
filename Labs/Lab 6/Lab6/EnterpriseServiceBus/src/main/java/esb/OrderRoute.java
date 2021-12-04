package esb;

public class OrderRoute {
    public String route(Order order) {
        String destinationChannel = null;

        if(order.getOrderType() == OrderType.INTERNATIONAL){
            destinationChannel = "shippinginternationalchannel";
        } else {
            if (order.getAmount() > 175)
                destinationChannel = "shippingnextdaychannel";
            else
                destinationChannel = "shippingnormalchannel";
        }
        return destinationChannel;
    }
}
