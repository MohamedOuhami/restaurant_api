package ma.ouhami.restaurant_api.reservation;

public class ReservationRequest {
    
    private Integer customer_id;
    private Integer restaurant_id;

    public Integer getCustomer_id(){
        return this.customer_id;
    }

    public Integer getRestaurant_id(){
        return this.restaurant_id;
    }
}
