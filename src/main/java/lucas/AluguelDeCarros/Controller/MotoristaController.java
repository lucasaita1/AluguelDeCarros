package lucas.AluguelDeCarros.Controller;


import jakarta.validation.Valid;
import lucas.AluguelDeCarros.DTO.MotoristaDto;
import lucas.AluguelDeCarros.Service.MotoristaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/motorista")
public class MotoristaController {

    private MotoristaService motoristaService;

    public MotoristaController(MotoristaService motoristaService) {
        this.motoristaService = motoristaService;
    }

    //CRUD


    //#CREAT
    @PostMapping("/criar")
    public ResponseEntity<MotoristaDto> adicionarMotorista(@RequestBody @Valid MotoristaDto motoristaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(motoristaService.criarMotorista(motoristaDto));
    }

    //#READ
    @GetMapping("/listar")
    public ResponseEntity<List<MotoristaDto>> listarMotoristas() {
        return ResponseEntity.ok(motoristaService.listarMotoristas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoristaDto> buscarPorId(@PathVariable Long id) {
        Optional<MotoristaDto> carroId = motoristaService.listarMotoristaPorID(id);

        return carroId
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //#UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<MotoristaDto> atualizar(@PathVariable Long id, @RequestBody @Valid MotoristaDto motoristaDto) {
        return ResponseEntity.ok(motoristaService.editarMotorista(id, motoristaDto));
    }

    //#DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMotorista(@PathVariable Long id) {
        motoristaService.deletarMotorista(id);
        return ResponseEntity.noContent().build();
    }
}


