package lucas.AluguelDeCarros.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lucas.AluguelDeCarros.DTO.MotoristaDto;
import lucas.AluguelDeCarros.Service.MotoristaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/motoristas")
@RequiredArgsConstructor
public class MotoristaController {

    private final MotoristaService motoristaService;

    //#CREATE
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo motorista", description = "Rota para o usuário criar um novo motorista.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Motorista criado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do motorista.")
    })
    public ResponseEntity<MotoristaDto> adicionarMotorista(@RequestBody @Valid MotoristaDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(motoristaService.criarMotorista(dto));
    }

    //#READ - listar todos
    @GetMapping("/listar")
    @Operation(summary = "Lista os motoristas", description = "Rota para visualizar todos os motoristas cadastrados.")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<List<MotoristaDto>> listarMotoristas() {
        return ResponseEntity.ok(motoristaService.listarMotoristas());
    }

    //#READ - listar por ID
    @GetMapping("/listar/{id}")
    @Operation(summary = "Busca motorista por ID", description = "Rota para visualizar dados de um motorista específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "Motorista não encontrado!")
    })
    public ResponseEntity<MotoristaDto> buscarPorId(@PathVariable Long id) {
        Optional<MotoristaDto> motorista = motoristaService.listarMotoristaPorID(id);
        return motorista.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //#UPDATE
    @PutMapping("/editar/{id}")
    @Operation(summary = "Edita um motorista por ID", description = "Rota para editar os dados de um motorista.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Motorista editado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Motorista não encontrado!")
    })
    public ResponseEntity<MotoristaDto> atualizarMotorista(@PathVariable Long id, @RequestBody @Valid MotoristaDto dto) {
        return ResponseEntity.ok(motoristaService.editarMotorista(id, dto));
    }

    //#DELETE
    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta um motorista por ID", description = "Rota para deletar um motorista do sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Motorista deletado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Motorista não encontrado!")
    })
    public ResponseEntity<Void> deletarMotorista(@PathVariable Long id) {
        motoristaService.deletarMotorista(id);
        return ResponseEntity.noContent().build();
    }
}


