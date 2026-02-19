package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.UsuarioModel;

import java.util.List;

public class UsuarioRepository {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("h2PU");

    // CREATE
    public void salvar(UsuarioModel usuario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(usuario);

        em.getTransaction().commit();
        em.close();
    }

    // READ
    public List<UsuarioModel> listar() {
        EntityManager em = emf.createEntityManager();

        List<UsuarioModel> lista =
                em.createQuery("FROM UsuarioModel", UsuarioModel.class)
                        .getResultList();

        em.close();
        return lista;
    }

    // READ - por ID
    public UsuarioModel buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        UsuarioModel usuario = em.find(UsuarioModel.class, id);
        em.close();
        return usuario;
    }

    // UPDATE
    public void atualizar(UsuarioModel usuario) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        UsuarioModel managed = em.find(UsuarioModel.class, usuario.getId());

        managed.setNome(usuario.getNome());
        managed.setEmail(usuario.getEmail());

        em.getTransaction().commit();
        em.close();
    }


    // DELETE
    public boolean remover(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        UsuarioModel usuario = em.find(UsuarioModel.class, id);
        boolean removed = false;

        if (usuario != null) {
            em.remove(usuario);
            removed = true;
        }

        em.getTransaction().commit();
        em.close();
        return removed;
    }

}
