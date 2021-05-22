package Business;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Order implements Serializable {
    private Integer orderId;
    private String clientId;
    private GregorianCalendar date;
    private Integer totalPrice;

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public Order (Integer orderId, String clientId, GregorianCalendar date, Integer totalPrice)
    {
        this.orderId = orderId;
        this.clientId = clientId;
        this.date = date;
        this.totalPrice = totalPrice;
    }

    @Override
    public int hashCode() {
        return orderId.hashCode() + clientId.hashCode()+ date.hashCode();
    }
}
