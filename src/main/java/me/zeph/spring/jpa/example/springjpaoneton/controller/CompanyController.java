package me.zeph.spring.jpa.example.springjpaoneton.controller;

import me.zeph.spring.jpa.example.springjpaoneton.model.Company;
import me.zeph.spring.jpa.example.springjpaoneton.model.User;
import me.zeph.spring.jpa.example.springjpaoneton.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

  @Autowired
  private CompanyRepository companyRepository;

  @GetMapping(value = "/save-company")
  public ResponseEntity saveCompany() {
    Company company = new Company();
    company.setId(1L);
    company.setName("company");
    User user = new User();
    user.setId(1L);
    user.setName("Benwei");
    User ceo = new User();
    ceo.setId(2L);
    ceo.setName("ceo");
    company.addUser(user);
    company.addUser(ceo);
    company.setCeo(ceo);
    companyRepository.save(company);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
