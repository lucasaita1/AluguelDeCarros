package lucas.AluguelDeCarros.DTO;


import lombok.*;
import lucas.AluguelDeCarros.Model.CarrosModel;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotoristaDto {

    private Long id;
    private String imgUrl;
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataDeNascimento;
    private String email;
    private CarrosModel carro;
}
