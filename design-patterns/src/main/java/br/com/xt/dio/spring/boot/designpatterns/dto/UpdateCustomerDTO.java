package br.com.xt.dio.spring.boot.designpatterns.dto;

public class UpdateCustomerDTO extends CreateCustomerDTO {

    private Integer id;

    public UpdateCustomerDTO() {
    }

    public UpdateCustomerDTO(Integer id, String name, String document, String phone, String cellphone, String email, Integer postalCode, String addressNumber) {
        super(name, document, phone, cellphone, email, postalCode, addressNumber);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
