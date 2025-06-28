package ifsc.edu.database.services;

import ifsc.edu.core.entities.Postagem;
import ifsc.edu.core.entities.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PostagemService {
    @Autowired
    private PostagemRepository postagemRepository;

    public List<Postagem> getAllPostagens() {
        try {
            return postagemRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter todas as postagens: " + e.getMessage(), e);
        }
    }

    public Postagem save(Postagem postagem) throws Exception {
        try {
            return postagemRepository.save(postagem);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar postagem: " + e.getMessage(), e);
        }
    }

    public Postagem getPostagemPorTitulo(String titulo) throws Exception {
        try {
            return postagemRepository.findPostagemByTitulo(titulo);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter postagem por título: " + e.getMessage(), e);
        }
    }

    public Postagem curtirPostagem(UUID uuid) throws Exception {
        try {
            Postagem postagem = postagemRepository.findByUuid(uuid).orElseThrow(() -> new RuntimeException("Postagem não encontrada"));
            postagem.curtidas++;

            return postagemRepository.save(postagem);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao curtir postagem: " + e.getMessage(), e);
        }
    }

    public Postagem alterarPostagem(Postagem postagem) throws Exception {
        try {
            Postagem postagemAlterar = postagemRepository.findByUuid(postagem.uuid).orElseThrow(() -> new RuntimeException("Postagem não econtrada"));

            postagemAlterar.titulo = postagem.titulo;
            postagemAlterar.conteudo = postagem.conteudo;
            postagemAlterar.palavrasChave = postagem.palavrasChave;
            postagemAlterar.alteradoEm = LocalDateTime.now();
            return postagemRepository.save(postagemAlterar);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao alterar postagem: " + e.getMessage(), e);
        }
    }
}
