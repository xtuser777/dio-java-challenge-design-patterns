package br.com.xt.dio.spring.boot.designpatterns.dto;

public class CreateCustomerDTO {

    private String name;
    private String document;
    private String phone;
    private String cellphone;
    private String email;
    private Integer postalCode;
    private String addressNumber;

    public CreateCustomerDTO() {
    }

    public CreateCustomerDTO(String name, String document, String phone, String cellphone, String email, Integer postalCode, String addressNumber) {
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.cellphone = cellphone;
        this.email = email;
        this.postalCode = postalCode;
        this.addressNumber = addressNumber;
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

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }
}
