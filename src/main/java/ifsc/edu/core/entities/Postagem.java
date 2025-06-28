package ifsc.edu.core.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "postagens")
public class Postagem {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    public String titulo;

    @Column(nullable = false)
    public String conteudo;

    @Column(nullable = false)
    public String autor;

    public int curtidas;
    public String[] palavrasChaves;
    public LocalDateTime publicadoEm;
    public LocalDateTime alteradoEm;

}
