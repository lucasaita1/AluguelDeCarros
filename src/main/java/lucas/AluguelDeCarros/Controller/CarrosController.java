package lucas.AluguelDeCarros.Controller;


import jakarta.validation.Valid;
import lucas.AluguelDeCarros.DTO.CarrosDto;
import lucas.AluguelDeCarros.Service.CarrosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carros")
public class CarrosController {

    private final CarrosService carrosService;

    public CarrosController(CarrosService carrosService) {
        this.carrosService = carrosService;
    }

    //CRUD

    //#CREAT
    @PostMapping ("/criar")
    public ResponseEntity<CarrosDto> adicionarCarro(@RequestBody @Valid CarrosDto carro) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(carrosService.criarCarro(carro));
    }


    //#READ --> listar todos
    @GetMapping ("/listar")
    public ResponseEntity<List<CarrosDto>> listarCarros() {
        return ResponseEntity.ok(carrosService.listarCarros());
    }

    //#READ --> Listar por ID

    @GetMapping("/listar/{id}")
    public ResponseEntity<CarrosDto> buscarPorId(@PathVariable Long id) {
        Optional<CarrosDto> carroId = carrosService.listarCarrosId(id);

        return carroId
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    //#UPDATE
    @PutMapping("editar/{id}")
    public ResponseEntity<CarrosDto> carroAtualizado(@PathVariable Long id, @RequestBody @Valid CarrosDto dto) {
        return ResponseEntity.ok(carrosService.editarCarro(id, dto));
    }

    //#DELETE
    @DeleteMapping("deletar/{id}")
    public ResponseEntity<Void> deletarCarro (@PathVariable Long id) {
        carrosService.deletarCarro(id);
        return ResponseEntity.noContent().build();
    }

}
