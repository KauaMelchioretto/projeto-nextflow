package ifsc.edu.core.entities.repository;

import ifsc.edu.core.entities.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    List<Postagem> findAll();
    Postagem save(Postagem postagem);
    Postagem findPostagemByTitulo(String titulo);
    Optional<Postagem> findByUuid(UUID uuid);
}
