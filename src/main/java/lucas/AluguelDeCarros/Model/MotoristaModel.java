package lucas.AluguelDeCarros.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_motorista")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotoristaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Foto")
    private String imgUrl;

    @Column(name = "Nome")
    @NotBlank(message = "Obrigatório o nome")
    private String nomeCompleto;

    @Column(unique = true, name = "Cpf" )
    @NotBlank(message = "Obrigatório informar o CPF")
    private String cpf;

    @Column(name = "Data de Nascimento")
    @NotNull(message = "Obrigatório informar a data de nascimento")
    private LocalDate dataDeNascimento;

    @Column(unique = true, name = "E-mail")
    @NotBlank(message = "Obrigatório o email")
    private String email;

    @OneToOne(mappedBy = "motorista")
    @JsonIgnore
    private CarrosModel carro;

}
