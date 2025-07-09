package lucas.AluguelDeCarros.DTO;

import lombok.*;
import lucas.AluguelDeCarros.Model.MotoristaModel;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarrosDto {


    private Long id;
    private String imgUrl;
    private String modelo;
    private String marca;
    private String cor;
    private String placa;
    private int ano;
    private MotoristaModel motorista;
}
