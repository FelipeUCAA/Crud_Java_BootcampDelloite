package service;

import model.UsuarioModel;
import repository.UsuarioRepository;

import java.util.List;

public class UsuarioService {

    private final UsuarioRepository repository = new UsuarioRepository();

    public void criar(String nome, String email) {
        repository.salvar(new UsuarioModel(nome, email));
    }

    public List<UsuarioModel> listar() {
        return repository.listar();
    }

    public UsuarioModel buscar(Long id) {
        return repository.buscarPorId(id);
    }

    public boolean atualizar(Long id, String nome, String email) {
        return repository.atualizar(
                new UsuarioModel(id, nome, email)
        );
    }

    public boolean deletar(Long id) {
        return repository.remover(id);
    }
}
