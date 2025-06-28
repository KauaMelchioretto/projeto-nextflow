package ifsc.edu.core.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "postagens")
public class Postagem {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    public UUID uuid;

    @PrePersist
    public void prePersist() {
        if(uuid == null) {
            uuid = UUID.randomUUID();
        }
    }

    @Column(nullable = false)
    public String titulo;

    @Column(nullable = false)
    public String conteudo;

    @Column(nullable = false)
    public String autor;

    public int curtidas;

    @ElementCollection
    @CollectionTable(name = "postagens_palavras_chave", joinColumns = @JoinColumn(name = "posgatem_uuid"))
    @Column(name = "palavra")
    public List<String> palavrasChave = new ArrayList<String>();

    public LocalDateTime publicadoEm = LocalDateTime.now();

    public LocalDateTime alteradoEm = LocalDateTime.now();
}
