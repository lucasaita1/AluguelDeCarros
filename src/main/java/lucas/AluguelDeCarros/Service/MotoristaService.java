package lucas.AluguelDeCarros.Service;


import lucas.AluguelDeCarros.DTO.MotoristaDto;
import lucas.AluguelDeCarros.Mapper.MotoristaMapper;
import lucas.AluguelDeCarros.Model.MotoristaModel;
import lucas.AluguelDeCarros.Repository.MotoristaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MotoristaService {

    private final MotoristaRepository motoristaRepository;
    private final MotoristaMapper motoristaMapper;

    public MotoristaService(MotoristaRepository motoristaRepository, MotoristaMapper motoristaMapper) {
        this.motoristaRepository = motoristaRepository;
        this.motoristaMapper = motoristaMapper;
    }

    //Metodo responsável pelo Post
    public MotoristaDto criarMotorista(MotoristaDto motoristaDto) {
        LocalDate dataNascimento = motoristaDto.getDataDeNascimento();
        int idade = Period.between(dataNascimento, LocalDate.now()).getYears();

        if (idade < 18) {
            throw new MotoristaInvalidadoException("Cadastro não permitido. Motorista com " + idade + " anos.");
        }
        MotoristaModel model = motoristaMapper.map(motoristaDto);
        MotoristaModel salvo = motoristaRepository.save(model);
        return motoristaMapper.map(salvo);
    }

    //Metodo responsável pelo Get -> Listar todos por motoristas
    public List<MotoristaDto> listarMotoristas(){
        List<MotoristaModel> motoristaModels = motoristaRepository.findAll();
        return motoristaModels.stream()
                .map(motoristaMapper::map)
                .collect(Collectors.toList());
    }

    //Metodo responsável pelo Get -> Listar por ID
    public Optional<MotoristaDto> listarMotoristaPorID (Long id){
        Optional<MotoristaModel> motoristaModel = motoristaRepository.findById(id);
        return motoristaModel.map(motoristaMapper::map);
    }

    //Metodo responsável pelo Put
    public MotoristaDto editarMotorista(Long id, MotoristaDto motoristaDto) {
        Optional<MotoristaModel> motoristaExistente = motoristaRepository.findById(id);

        if (motoristaExistente.isPresent()) {
            MotoristaModel existente = motoristaExistente.get();

            existente.setNomeCompleto(motoristaDto.getNomeCompleto());
            existente.setEmail(motoristaDto.getEmail());
            existente.setCpf(motoristaDto.getCpf());
            existente.setDataDeNascimento(motoristaDto.getDataDeNascimento());
            existente.setImgUrl(motoristaDto.getImgUrl());

            MotoristaModel atualizado = motoristaRepository.save(existente);
            return motoristaMapper.map(atualizado);
        }

        throw new MotoristaInvalidadoException("Motorista com ID " + id + " não encontrado.");
    }

    //Metodo responsável pelo Delete
    public boolean deletarMotorista (Long id){
        if (motoristaRepository.existsById(id)){
            motoristaRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
