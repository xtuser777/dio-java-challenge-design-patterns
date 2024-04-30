package br.com.xt.dio.spring.boot.designpatterns.repository;

import br.com.xt.dio.spring.boot.designpatterns.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
}
