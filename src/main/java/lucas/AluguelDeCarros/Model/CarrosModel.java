package lucas.AluguelDeCarros.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_carros")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarrosModel {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "ID")
private Long id;

@Column(name = "Foto")
private String imgUrl;

@Column(name = "Modelo")
@NotBlank(message = "Modelo é Obrigatório" )
private String modelo;

@Column(name = "Marca")
@NotBlank(message = "Definir Marca é obrigatório")
private String marca;

@Column(name = "Cor")
@NotBlank(message = "Cor é obrigatório")
private String cor;

@Column(unique = true, name = "Placa")
@NotBlank(message = "Placa é obrigatório")
private String placa;

@Column(name = "Ano")
@NotNull(message = "Ano é obrigatório")
private int ano;

@OneToOne
@JoinColumn(name = "motorista_id", unique = true)
private MotoristaModel motorista;



}
