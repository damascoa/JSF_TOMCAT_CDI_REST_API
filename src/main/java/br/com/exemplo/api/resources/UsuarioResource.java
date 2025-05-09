package br.com.exemplo.api.resources;

import br.com.exemplo.model.Usuario;
import br.com.exemplo.repository.UsuarioRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    private UsuarioRepository repository;

    @GET
    public List<Usuario> listar() {
        return repository.listar();
    }

    @POST
    public void salvar(Usuario usuario) {
        repository.salvar(usuario);
    }
}