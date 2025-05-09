package br.com.exemplo.repository;

import br.com.exemplo.model.Usuario;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

@RequestScoped
public class UsuarioRepository {

    @Inject
    private EntityManager em;

    public List<Usuario> listar() {
        return em.createQuery("Select u from Usuario u", Usuario.class).getResultList();
    }

    public void salvar(Usuario usuario) {
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
    }
}
