package model;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class Meal extends BaseModel {

    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "r_id")
    private Restaurant restaurant;

    @Column(name = "name")
    private String name;

    public Meal()
    {}

    public Meal(Integer id, Integer price, String name) {
        super(id);
        this.price = price;
        this.name = name;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "price=" + price +
                ", restaurant=" + restaurant +
                ", name='" + name + '\'' +
                "} " + super.toString();
    }
}
