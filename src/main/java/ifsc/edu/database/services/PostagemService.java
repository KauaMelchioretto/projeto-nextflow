package ifsc.edu.database.services;

import ifsc.edu.database.entities.Postagem;
import ifsc.edu.database.entities.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostagemService {
    @Autowired
    private PostagemRepository postagemRepository;

    public List<Postagem> getAllPostagens() {
        return postagemRepository.findAll();
    }

    public Postagem save(Postagem postagem) {
        return postagemRepository.save(postagem);
    }
}
