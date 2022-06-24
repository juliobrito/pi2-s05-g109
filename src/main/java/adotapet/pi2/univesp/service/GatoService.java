package adotapet.pi2.univesp.service;

import adotapet.pi2.univesp.model.GatoModel;
import adotapet.pi2.univesp.repository.GatoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class GatoService {
    final
    GatoRepository gatoRepository;

    public GatoService(GatoRepository gatoRepository) {
        this.gatoRepository = gatoRepository;
    }

    @Transactional
    public GatoModel save(GatoModel gatoModel) {
        return gatoRepository.save(gatoModel);
    }

    public Page<GatoModel> findAll(Pageable pageable) {
        return gatoRepository.findAll(pageable);
    }

    public Optional<GatoModel> findById(int id) {
        return gatoRepository.findById(id);
    }

    @Transactional
    public void delete(GatoModel gatoModel) {
        gatoRepository.delete(gatoModel);
    }
}
