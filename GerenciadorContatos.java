// Integrantes da equipe:
// Deilson Pereia Alves
// Juciana Maria Diniz
// Mathias Ferreira do Nascimento e Silva
// Rayassa Beatriz Alencar Almeida
import java.util.List;

public interface GerenciadorContatos {

    void adicionarContato(Contato contato) throws ContatoExistenteException;

    Contato buscarContato(String nome) throws ContatoNaoEncontradoException;

    void removerContato(String nome) throws ContatoNaoEncontradoException;

    List<Contato> listarTodosContatos();
}
