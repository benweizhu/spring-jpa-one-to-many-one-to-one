package me.zeph.spring.jpa.example.springjpa.controller;

import me.zeph.spring.jpa.example.springjpa.model.Company;
import me.zeph.spring.jpa.example.springjpa.model.User;
import me.zeph.spring.jpa.example.springjpa.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
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

  @GetMapping(value = "/company")
  public ResponseEntity<Company> getCompanyByUser(@Param("username") String username) {
    Optional<Company> companyOptional = companyRepository.findByUsersName(username);
    if (companyOptional.isPresent()) {
      return new ResponseEntity<>(companyOptional.get(), HttpStatus.OK);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(value = "/save-company/{id}")
  public ResponseEntity saveCompany(@PathVariable long id) {
    Optional<Company> companyOptional = companyRepository.findById(id);
    if (companyOptional.isPresent()) {
      Company existedCompany = companyOptional.get();
      companyRepository.save(existedCompany);
    } else {
      Company company = new Company();
      company.setId(id);
      company.setName("company" + id);
      User user = new User();
      user.setId(id);
      user.setName("Benwei" + id);
      user.setCompanyId(id);
      company.setUsers(getUsers(user));
      companyRepository.save(company);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }

  private List<User> getUsers(User user) {
    List<User> users = new ArrayList<>();
    users.add(user);
    return users;
  }
}
