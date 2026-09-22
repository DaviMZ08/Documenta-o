package com.treino.treinamento.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // GET: http://localhost:8080/usuario/contar-usuarios
    @GetMapping("/contar-usuarios")
    public long contar() {
        return usuarioService.contarUsuarios();
    }

    // GET: http://localhost:8080/usuario/buscar-usuario/{id}
    @GetMapping("/buscar-usuario/{id}")
    public Usuario buscar(@PathVariable Integer id) {
        return usuarioService.buscarUsuario(id);
    }

    // GET: http://localhost:8080/usuario/listar-usuarios
    @GetMapping("/listar-usuarios")
    public List<Usuario> listar() {
        return usuarioService.listarUsuarios();
    }

    // POST: http://localhost:8080/usuario/salvar-usuario
    @PostMapping("/salvar-usuario")
    public Usuario salvar(@RequestBody Usuario usuario) {
        return usuarioService.cadastrarUsuario(usuario);
    }

    // PUT: http://localhost:8080/usuario/atualizar-usuario/{id}
    @PutMapping("/atualizar-usuario/{id}")
    public Usuario atualizar(@PathVariable Integer id, @RequestBody Usuario usuario) {
        return usuarioService.atualizarUsuario(id, usuario);
    }

    // DELETE: http://localhost:8080/usuario/deletar-usuario/{id}
    @DeleteMapping("/deletar-usuario/{id}")
    public String deletar(@PathVariable Integer id) {
        if(usuarioService.deletarUsuario(id)) {
            return "Usuário deletado com sucesso!";
        }
        return "Usuário não encontrado.";
    }
}
