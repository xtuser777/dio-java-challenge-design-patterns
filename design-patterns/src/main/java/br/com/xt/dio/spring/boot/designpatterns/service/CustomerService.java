package br.com.xt.dio.spring.boot.designpatterns.service;

import br.com.xt.dio.spring.boot.designpatterns.dto.CreateCustomerDTO;
import br.com.xt.dio.spring.boot.designpatterns.dto.LocationData;
import br.com.xt.dio.spring.boot.designpatterns.dto.UpdateCustomerDTO;
import br.com.xt.dio.spring.boot.designpatterns.entity.Address;
import br.com.xt.dio.spring.boot.designpatterns.entity.Contact;
import br.com.xt.dio.spring.boot.designpatterns.entity.Customer;
import br.com.xt.dio.spring.boot.designpatterns.repository.AddressRepository;
import br.com.xt.dio.spring.boot.designpatterns.repository.ContactRepository;
import br.com.xt.dio.spring.boot.designpatterns.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private IViaCepService IViaCepService;

    @Override
    public Iterable<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        var customer = this.customerRepository.findById(id);

        return customer.get();
    }

    @Override
    public void insert(CreateCustomerDTO dto) {
        Customer customer = convert(dto);
        this.saveWithLocationData(customer, dto.getPostalCode(), dto.getAddressNumber());
    }

    @Override
    public void update(Integer id, UpdateCustomerDTO dto) {
        var customer = this.findById(id);
        if (customer != null) {
            customer = this.convert(dto, customer);
            this.saveWithLocationData(customer, dto.getPostalCode(), dto.getAddressNumber());
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(Integer id) {
        this.customerRepository.deleteById(id);
    }

    private Customer convert(CreateCustomerDTO dto) {
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setDocument(dto.getDocument());

        Contact contact = new Contact();
        contact.setPhone(dto.getPhone());
        contact.setEmail(dto.getEmail());
        contact.setCellphone(dto.getCellphone());
        contact = this.contactRepository.save(contact);
        customer.setContact(contact);

        return customer;
    }

    private Customer convert(UpdateCustomerDTO dto, Customer customer) {
        customer.setName(dto.getName());
        customer.setDocument(dto.getDocument());
        customer.getContact().setPhone(dto.getPhone());
        customer.getContact().setEmail(dto.getEmail());
        customer.getContact().setCellphone(dto.getCellphone());

        return customer;
    }

    private void saveWithLocationData(Customer customer, Integer postalCode, String addressNumber) {
        // Verificar se o Endereco do Cliente já existe (pelo CEP).
        Address address = addressRepository.findById(postalCode).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            LocationData data = IViaCepService.searchPostalCode(postalCode);
            Address newAddress = new Address(
                    Integer.parseInt(data.getCep().replace("-", "")),
                    data.getLogradouro(),
                    addressNumber,
                    data.getBairro(),
                    data.getUf(),
                    data.getLocalidade()
            );
            addressRepository.save(newAddress);
            return newAddress;
        });
        customer.setAddress(address);

        // Inserir Cliente, vinculando o Endereco (novo ou existente).
        customerRepository.save(customer);
    }

}
