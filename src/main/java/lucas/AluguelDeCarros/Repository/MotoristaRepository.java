package lucas.AluguelDeCarros.Repository;

import lucas.AluguelDeCarros.Model.MotoristaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository extends JpaRepository<MotoristaModel, Long> {
}
