package br.com.xt.dio.spring.boot.designpatterns.controller;

import br.com.xt.dio.spring.boot.designpatterns.dto.CreateCustomerDTO;
import br.com.xt.dio.spring.boot.designpatterns.dto.UpdateCustomerDTO;
import br.com.xt.dio.spring.boot.designpatterns.entity.Customer;
import br.com.xt.dio.spring.boot.designpatterns.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/customers")
public class CustomersController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ResponseEntity<Iterable<Customer>> index() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> show(@PathVariable Integer id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateCustomerDTO dto) {
        this.customerService.insert(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody UpdateCustomerDTO dto) {
        this.customerService.update(id, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        this.customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
