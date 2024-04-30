package br.com.xt.dio.spring.boot.designpatterns.repository;

import br.com.xt.dio.spring.boot.designpatterns.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {
}
