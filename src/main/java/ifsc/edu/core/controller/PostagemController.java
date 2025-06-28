package ifsc.edu.core.controller;

import ifsc.edu.core.entities.Postagem;
import ifsc.edu.database.services.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PostagemController {
    @Autowired
    private PostagemService postagemService;

    @PostMapping("/criarPostagem")
    public Postagem createPostagem(@RequestBody Postagem postagem) throws Exception {
        try {
            return postagemService.save(postagem);
        } catch(Exception e) {
            throw new Exception("Erro ao criar postagem: " + e.getMessage(), e);
        }
    }

    @GetMapping("/getPostagens")
    public List<Postagem> getAllPostagens() throws Exception {
        try {
            return postagemService.getAllPostagens();
        } catch (Exception e) {
            throw new Exception("Erro ao obter postagens: " + e.getMessage(), e);
        }
    }

    @GetMapping("/getPostagemPorTitulo")
    public Postagem getPostagemPorTitulo(@RequestParam String titulo) throws Exception {
        try {
            return postagemService.getPostagemPorTitulo(titulo);
        } catch (Exception e) {
            throw new Exception("Erro ao obter postagem por título: " + e.getMessage(), e);
        }
    }

    @PutMapping("/curtirPostagem/{uuid}")
    public Postagem curtirPostagem(@PathVariable UUID uuid) throws Exception {
        try {
            return postagemService.curtirPostagem(uuid);
        } catch (Exception e) {
            throw new Exception("Erro ao curtir postagem de id '" + uuid.toString() + "': " + e.getMessage(), e);
        }
    }

    @PutMapping("/alterarPostagem")
    public Postagem alterarPostagem(@RequestBody Postagem postagem) throws Exception {
        try {
            return postagemService.alterarPostagem(postagem);
        } catch (Exception e) {
            throw new Exception("Erro ao alterar postagem de id '" + postagem.uuid.toString() + "': " + e.getMessage(), e);
        }
    }
}
