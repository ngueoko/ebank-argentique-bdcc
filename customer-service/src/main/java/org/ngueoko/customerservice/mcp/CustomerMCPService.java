package org.ngueoko.customerservice.web;

import jakarta.ws.rs.PathParam;
import org.ngueoko.customerservice.dto.CustomerRequestDTO;
import org.ngueoko.customerservice.dto.CustomerResponseDTO;
import org.ngueoko.customerservice.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
// CQRS: Command Query Responsability Segregation
public class CustomerRestController {
    @PostMapping("/customers")
    public CustomerResponseDTO addCustomer(@RequestBody CustomerRequestDTO request) {
        return customerService.addCustomer(request);
    }

    @Transactional(readOnly = true)
    @GetMapping("/customers/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable UUID id) {
        return customerService.getCustomer(id);
    }

    @Transactional(readOnly = true)
    @GetMapping("/customers")
    public List<CustomerResponseDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }
    @PutMapping("/customers/{id}")
    public CustomerResponseDTO updateCustomer(@PathVariable UUID id, @RequestBody CustomerRequestDTO request) {
        return customerService.updateCustomer(id, request);
    }
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable UUID id) {
        customerService.deleteCustomer( id);
    }

    @ExceptionHandler(Exception.class)
   @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handle(IOException ex) {
        return Map.of("errorMessage",ex.getMessage());
    }

    private CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }
}
