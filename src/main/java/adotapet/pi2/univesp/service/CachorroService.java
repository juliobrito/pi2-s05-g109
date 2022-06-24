package adotapet.pi2.univesp.service;

import adotapet.pi2.univesp.model.CachorroModel;
import adotapet.pi2.univesp.repository.CachorroRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CachorroService {
    final
    CachorroRepository cachorroRepository;

    public CachorroService(CachorroRepository cachorroRepository) {
        this.cachorroRepository = cachorroRepository;
    }

    @Transactional
    public CachorroModel save(CachorroModel cachorroModel) {
        return cachorroRepository.save(cachorroModel);
    }

    public Page<CachorroModel> findAll(Pageable pageable) {
        return cachorroRepository.findAll(pageable);
    }

    public Optional<CachorroModel> findById(int id) {
        return cachorroRepository.findById(id);
    }

    @Transactional
    public void delete(CachorroModel cachorroModel) {
        cachorroRepository.delete(cachorroModel);
    }
}
