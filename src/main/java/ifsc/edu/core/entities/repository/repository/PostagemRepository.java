package ifsc.edu.core.entities.entities.repository;

import ifsc.edu.database.entities.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    List<Postagem> findAll();

    Postagem save(Postagem postagem);
}
