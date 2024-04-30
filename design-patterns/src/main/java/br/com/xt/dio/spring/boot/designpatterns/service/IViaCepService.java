package br.com.xt.dio.spring.boot.designpatterns.service;

import br.com.xt.dio.spring.boot.designpatterns.dto.LocationData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface IViaCepService {

    @GetMapping("/{code}/json/")
    LocationData searchPostalCode(@PathVariable("code") Integer code);
}
