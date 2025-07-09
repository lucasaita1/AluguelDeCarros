package lucas.AluguelDeCarros.Mapper;

import lucas.AluguelDeCarros.DTO.MotoristaDto;
import lucas.AluguelDeCarros.Model.MotoristaModel;
import org.springframework.stereotype.Component;

@Component
public class MotoristaMapper {

    public MotoristaModel map(MotoristaDto motoristaDto){
        MotoristaModel motoristaModel = new MotoristaModel();
        motoristaModel.setId(motoristaDto.getId());
        motoristaModel.setCpf(motoristaDto.getCpf());
        motoristaModel.setEmail(motoristaDto.getEmail());
        motoristaModel.setDataDeNascimento(motoristaDto.getDataDeNascimento());
        motoristaModel.setNomeCompleto(motoristaDto.getNomeCompleto());
        motoristaModel.setImgUrl(motoristaDto.getImgUrl());
        motoristaModel.setCarro(motoristaDto.getCarro());

        return motoristaModel;
    }

    public MotoristaDto map(MotoristaModel motoristaModel){
        MotoristaDto motoristaDto = new MotoristaDto();
        motoristaDto.setId(motoristaModel.getId());
        motoristaDto.setCpf(motoristaModel.getCpf());
        motoristaDto.setEmail(motoristaModel.getEmail());
        motoristaDto.setDataDeNascimento(motoristaModel.getDataDeNascimento());
        motoristaDto.setNomeCompleto(motoristaModel.getNomeCompleto());
        motoristaDto.setImgUrl(motoristaModel.getImgUrl());
        motoristaDto.setCarro(motoristaModel.getCarro());

        return motoristaDto;
    }
}
