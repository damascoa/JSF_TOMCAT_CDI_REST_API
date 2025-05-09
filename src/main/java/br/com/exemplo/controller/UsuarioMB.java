package br.com.exemplo.controller;

import br.com.exemplo.model.Usuario;
import br.com.exemplo.repository.UsuarioRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("usuarioMB") // Para ser usado no xhtml como #{usuarioMB}
@RequestScoped
public class UsuarioMB implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario = new Usuario();

    @Inject
    private UsuarioRepository repository;

    public void salvar() {
        repository.salvar(usuario);
        usuario = new Usuario();
    }

    public List<Usuario> getUsuarios() {
        return repository.listar();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
