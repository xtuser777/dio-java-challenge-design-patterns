package br.com.xt.dio.spring.boot.designpatterns.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 14, nullable = false)
    private String phone;

    @Column(length = 15, nullable = false)
    private String cellphone;

    @Column(length = 100, nullable = false)
    private String email;

    public Contact() {
    }

    public Contact(Integer id, String phone, String cellphone, String email) {
        this.id = id;
        this.phone = phone;
        this.cellphone = cellphone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
