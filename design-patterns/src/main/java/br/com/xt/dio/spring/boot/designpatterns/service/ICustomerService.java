package br.com.xt.dio.spring.boot.designpatterns.service;

import br.com.xt.dio.spring.boot.designpatterns.dto.CreateCustomerDTO;
import br.com.xt.dio.spring.boot.designpatterns.dto.UpdateCustomerDTO;
import br.com.xt.dio.spring.boot.designpatterns.entity.Customer;

public interface ICustomerService {

    Iterable<Customer> findAll();

    Customer findById(Integer id);

    void insert(CreateCustomerDTO dto);

    void update(Integer id, UpdateCustomerDTO dto);

    void delete(Integer id);
}
