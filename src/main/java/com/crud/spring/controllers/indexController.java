package com.crud.spring.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class indexController {
    @RequestMapping(value = "/{nome}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String helloWorld(@PathVariable String nome){
      return "Hello World " + nome;
    }
}