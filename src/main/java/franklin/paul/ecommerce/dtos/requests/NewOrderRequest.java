package franklin.paul.ecommerce.dtos.requests;

public class NewOrderRequest {
    private Double totalPrice;

    public NewOrderRequest() {
        super();
    }

    public NewOrderRequest(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
