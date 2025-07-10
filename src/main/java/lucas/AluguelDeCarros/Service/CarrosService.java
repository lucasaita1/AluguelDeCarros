package lucas.AluguelDeCarros.Service;


import lucas.AluguelDeCarros.DTO.CarrosDto;
import lucas.AluguelDeCarros.Mapper.CarrosMapper;
import lucas.AluguelDeCarros.Model.CarrosModel;
import lucas.AluguelDeCarros.Repository.CarrosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarrosService {

    private final CarrosRepository carrosRepository;
    private final CarrosMapper carrosMapper;

    public CarrosService(CarrosRepository carrosRepository, CarrosMapper carrosMapper) {
        this.carrosRepository = carrosRepository;
        this.carrosMapper = carrosMapper;
    }


    //Metodo resposável pelo post
    public CarrosDto criarCarro (CarrosDto carrosDto) {

        if (carrosDto.getAno() >= 2010) {
            CarrosModel carrosModel = carrosMapper.map(carrosDto);
            carrosRepository.save(carrosModel);
            return carrosMapper.map(carrosModel);
        }

        throw new CarroInvalidoException("Carro com ano " + carrosDto.getAno() + ", muito ultrapassado!");
    }

    //Metodo responsável pelo get
    public List<CarrosDto> listarCarros () {
        List<CarrosModel> carrosModels = carrosRepository.findAll();
        return carrosModels.stream()
                .map(carrosMapper::map)
                .collect(Collectors.toList());
    }

    //Metodo responsável pelo get e listar somente o ID
    public Optional<CarrosDto> listarCarrosId (Long id){
        Optional<CarrosModel> carrosModel = carrosRepository.findById(id);
        return carrosModel.map(carrosMapper::map);

    }

    //Metodo responsável pelo put
    public CarrosDto editarCarro (Long id, CarrosDto carrosDto) {
        Optional<CarrosModel> carroExistente = carrosRepository.findById(id);
        if (carroExistente.isPresent()) {
            CarrosModel existente = carroExistente.get();

            existente.setModelo(carrosDto.getModelo());
            existente.setMarca(carrosDto.getMarca());
            existente.setAno(carrosDto.getAno());
            existente.setPlaca(carrosDto.getPlaca());
            existente.setCor(carrosDto.getCor());
            existente.setImgUrl(carrosDto.getImgUrl());

            CarrosModel atualizado = carrosRepository.save(existente);
            return carrosMapper.map(atualizado);
        }
        throw new CarroInvalidoException("Carro com ID " + id + " não encontrado.");
    }

    //Metodo responsável pelo delete
    public boolean deletarCarro(Long id) {
        if (carrosRepository.existsById(id)) {
            carrosRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
