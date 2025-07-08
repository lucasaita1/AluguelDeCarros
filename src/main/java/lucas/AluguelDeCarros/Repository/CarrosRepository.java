package lucas.AluguelDeCarros.Repository;

import lucas.AluguelDeCarros.Model.CarrosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrosRepository  extends JpaRepository<CarrosModel, Long> {

}
