package br.com.xt.dio.spring.boot.designpatterns.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    private Integer code;

    @Column(length = 100, nullable = false)
    private String street;

    @Column(length = 5, nullable = false)
    private String number;

    @Column(length = 50, nullable = false)
    private String neighborhood;

    @Column(length = 2, nullable = false)
    private String state;

    @Column(length = 100, nullable = false)
    private String city;

    public Address() {
    }

    public Address(Integer code, String street, String number, String neighborhood, String state, String city) {
        this.code = code;
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.state = state;
        this.city = city;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
