// Integrantes da equipe:
// Deilson Pereia Alves
// Juciana Maria Diniz
// Mathias Ferreira do Nascimento e Silva
// Rayassa Beatriz Alencar Almeida
import java.util.*;
import java.io.*;

public class AgendaManager implements GerenciadorContatos {

    private List<Contato> contatos = new ArrayList<>();

    @Override
    public void adicionarContato(Contato contato) throws ContatoExistenteException {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(contato.getNome())) {
                throw new ContatoExistenteException("Contato já existe!");
            }
        }
        contatos.add(contato);
    }

    @Override
    public Contato buscarContato(String nome) throws ContatoNaoEncontradoException {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        throw new ContatoNaoEncontradoException("Contato não encontrado!");
    }

    @Override
    public void removerContato(String nome) throws ContatoNaoEncontradoException {
        Contato c = buscarContato(nome);
        contatos.remove(c);
    }

    @Override
    public List<Contato> listarTodosContatos() {
        return contatos;
    }

    public List<Contato> listarContatosOrdenados() {
        List<Contato> listaOrdenada = new ArrayList<>(contatos);
        listaOrdenada.sort(Comparator.comparing(Contato::getNome));
        return listaOrdenada;
    }

    public List<Contato> buscarPorDominioEmail(String dominio) {
        List<Contato> encontrados = new ArrayList<>();
        for (Contato c : contatos) {
            if (c.getEmail().contains(dominio)) {
                encontrados.add(c);
            }
        }
        return encontrados;
    }

    public void salvarContatosCSV(String nomeArquivo) throws IOException {
        FileWriter writer = new FileWriter(nomeArquivo);

        for (Contato c : contatos) {
            writer.write(c.getNome() + ";" + c.getTelefone() + ";" + c.getEmail() + "\n");
        }
        writer.close();
    }

    public void carregarContatosCSV(String nomeArquivo) throws IOException {
        contatos.clear();
        BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
        String linha;

        while ((linha = br.readLine()) != null) {
            String[] partes = linha.split(";");
            Contato c = new Contato(partes[0], partes[1], partes[2]);
            contatos.add(c);
        }

        br.close();
    }
}
