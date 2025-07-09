package lucas.AluguelDeCarros.Mapper;

import lucas.AluguelDeCarros.DTO.CarrosDto;
import lucas.AluguelDeCarros.Model.CarrosModel;
import org.springframework.stereotype.Component;

@Component
public class CarrosMapper {

    public CarrosModel map (CarrosDto carrosDto){
        CarrosModel carrosModel = new CarrosModel();
        carrosModel.setId(carrosDto.getId());
        carrosModel.setModelo(carrosDto.getModelo());
        carrosModel.setMarca(carrosDto.getMarca());
        carrosModel.setPlaca(carrosDto.getPlaca());
        carrosModel.setCor(carrosDto.getCor());
        carrosModel.setAno(carrosDto.getAno());
        carrosModel.setImgUrl(carrosDto.getImgUrl());
        carrosModel.setMotorista(carrosDto.getMotorista());

        return carrosModel;
    }

    public CarrosDto map(CarrosModel carrosModel){
        CarrosDto carrosDto = new CarrosDto();
        carrosDto.setId(carrosModel.getId());
        carrosDto.setModelo(carrosModel.getModelo());
        carrosDto.setMarca(carrosModel.getMarca());
        carrosDto.setPlaca(carrosModel.getPlaca());
        carrosDto.setCor(carrosModel.getCor());
        carrosDto.setAno(carrosModel.getAno());
        carrosDto.setImgUrl(carrosModel.getImgUrl());
        carrosDto.setMotorista(carrosModel.getMotorista());

        return carrosDto;
    }
}
