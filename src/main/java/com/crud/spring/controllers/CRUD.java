package com.crud.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.spring.models.Usuario;
import com.crud.spring.repository.UsuarioRepository;

@RestController
public class CRUD {

  @Autowired // Injeção de dependências.
  private UsuarioRepository usuarioRepository;

  //Método GET - Retornar lista de usuários
  @GetMapping(value = "/usuarios")
  @ResponseBody // Retorna os resultados para o corpo da resposta.
  public ResponseEntity<List<Usuario>> listarUsuarios(){
    List<Usuario> usuarios = usuarioRepository.findAll();
    return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK); // Retorna a lista em JSON.
  }
  
  //Método POST - Cadastra usuário
  @PostMapping(value = "/cadastro")
  @ResponseBody
  public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario){
    Usuario user = usuarioRepository.save(usuario);
    return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
  }

  //Método DELETE - Deletar usuário
  @DeleteMapping(value = "/deletar")
  @ResponseBody
  public ResponseEntity<String> deletarUsuario(@RequestParam Long idUser){
    usuarioRepository.deleteById(idUser);
    return new ResponseEntity<String>("Usuário deletado com sucesso!", HttpStatus.OK);
  }
}
