package lucas.AluguelDeCarros.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lucas.AluguelDeCarros.DTO.CarrosDto;
import lucas.AluguelDeCarros.Service.CarrosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carros")
@RequiredArgsConstructor
public class CarrosController {

    private final CarrosService carrosService;

    //#CREATE
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo carro", description = "Rota para o usuário criar um novo carro.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Carro criado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do carro.")
    })
    public ResponseEntity<CarrosDto> adicionarCarro(@RequestBody @Valid CarrosDto carro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carrosService.criarCarro(carro));
    }

    //#READ - listar todos
    @GetMapping("/listar")
    @Operation(summary = "Lista os carros do banco de dados", description = "Rota para listar todos os carros cadastrados.")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<List<CarrosDto>> listarCarros() {
        return ResponseEntity.ok(carrosService.listarCarros());
    }

    //#READ - listar por ID
    @GetMapping("/listar/{id}")
    @Operation(summary = "Busca carro por ID", description = "Rota para visualizar características de um carro específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "Carro não encontrado!")
    })
    public ResponseEntity<CarrosDto> buscarPorId(@PathVariable Long id) {
        Optional<CarrosDto> carro = carrosService.listarCarrosId(id);
        return carro.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //#UPDATE
    @PutMapping("/editar/{id}")
    @Operation(summary = "Edita um carro por ID", description = "Rota para editar dados de um carro específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carro editado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Carro não encontrado!")
    })
    public ResponseEntity<CarrosDto> atualizarCarro(@PathVariable Long id, @RequestBody @Valid CarrosDto dto) {
        return ResponseEntity.ok(carrosService.editarCarro(id, dto));
    }

    //#DELETE
    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta um carro por ID", description = "Rota para deletar um carro do banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Carro deletado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Carro não encontrado!")
    })
    public ResponseEntity<Void> deletarCarro(@PathVariable Long id) {
        carrosService.deletarCarro(id);
        return ResponseEntity.noContent().build();
    }

}
