package me.zeph.spring.jpa.example.springjpaoneton.controller;

import me.zeph.spring.jpa.example.springjpaoneton.model.Company;
import me.zeph.spring.jpa.example.springjpaoneton.model.User;
import me.zeph.spring.jpa.example.springjpaoneton.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class CompanyController {

  @Autowired
  private CompanyRepository companyRepository;

  @GetMapping(value = "/company/{id}")
  public ResponseEntity<Company> getCompany(@PathVariable(name = "id") long id) {
    Optional<Company> companyOptional = companyRepository.findById(id);
    if (companyOptional.isPresent()) {
      return new ResponseEntity<>(companyOptional.get(), HttpStatus.OK);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(value = "/save-company")
  public ResponseEntity saveCompany() {
    Company company = new Company();
    company.setId(1L);
    company.setName("company");
    User user = new User();
    user.setName("Benwei");
    company.addUser(user);
    companyRepository.save(company);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
