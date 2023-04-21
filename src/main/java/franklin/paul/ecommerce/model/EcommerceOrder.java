package franklin.paul.ecommerce.model;

import javax.persistence.*;

@Entity
@Table
public class EcommerceOrder {
    @Id
    private String orderId;

    @ManyToOne
    @JoinColumn(
        name = "user_id",
        nullable = false
    )
    private EcommerceUser user;

    @Column(nullable = false)
    private Double totalPrice;

    public EcommerceOrder() {
    }

    public EcommerceOrder(String orderId, EcommerceUser user, Double totalPrice) {
        this.orderId = orderId;
        this.user = user;
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public EcommerceUser getUser() {
        return user;
    }

    public void setUser(EcommerceUser user) {
        this.user = user;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
