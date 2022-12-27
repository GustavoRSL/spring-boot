package com.crud.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.spring.models.Usuario;
import com.crud.spring.repository.UsuarioRepository;

@RestController
public class CRUD {

  @Autowired // Injeção de dependências.
  private UsuarioRepository usuarioRepository;

  //Método GET - Retornar lista de usuários
  @GetMapping(value = "/Usuarios")
  @ResponseBody // Retorna os resultados para o corpo da resposta.
  public ResponseEntity<List<Usuario>> listarUsuarios(){
    List<Usuario> usuarios = usuarioRepository.findAll();
    return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK); // Retorna a lista em JSON.
  } 
}
