package br.com.xt.dio.spring.boot.designpatterns.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 15, nullable = false)
    private String document;

    @ManyToOne(optional = false)
    private Address address;

    @ManyToOne(optional = false)
    private Contact contact;

    public Customer() {
    }

    public Customer(Integer id, String name, String document, Address address, Contact contact) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.address = address;
        this.contact = contact;
    }

    public Customer(Integer id, String name, String document) {
        this.id = id;
        this.name = name;
        this.document = document;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
