package adotapet.pi2.univesp.controller;

import adotapet.pi2.univesp.dto.CachorroDto;
import adotapet.pi2.univesp.model.CachorroModel;
import adotapet.pi2.univesp.service.CachorroService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cachorro")
public class CachorroController {

    private final CachorroService cachorroService;

    public CachorroController(CachorroService cachorroService) {
        this.cachorroService = cachorroService;
    }

    @PostMapping
    public ResponseEntity<Object> saveCachorro(@RequestBody @Valid CachorroDto cachorroDto){
        var cachorroModel = new CachorroModel();
        BeanUtils.copyProperties(cachorroDto, cachorroModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(cachorroService.save(cachorroModel));
    }

    @GetMapping
    public ResponseEntity<Page<CachorroModel>> getAllCachorro(@PageableDefault Pageable peageable){
        return ResponseEntity.status(HttpStatus.OK).body(cachorroService.findAll(peageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCachorro(@PathVariable(value = "id") int id){
        Optional<CachorroModel> cachorroModelOptional = cachorroService.findById(id);
        if(!cachorroModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cachorro não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cachorroModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCachorro(@PathVariable(value = "id") int id){
        Optional<CachorroModel> cachorroModelOptional = cachorroService.findById(id);
        if(!cachorroModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cachorro não encontrado.");
        }
        cachorroService.delete(cachorroModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Exclusão realizada.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCachorro(@PathVariable(value = "id") int id,
                                                 @RequestBody @Valid CachorroDto cachorroDto) {
        Optional<CachorroModel> cachorroModelOptional = cachorroService.findById(id);
        if (!cachorroModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cachorro não encontrado.");
        }
        var cachorroModel = cachorroModelOptional.get();
        cachorroModel.setIdade(cachorroDto.getIdade());
        cachorroModel.setPorte(cachorroDto.getPorte());
        cachorroModel.setSaude(cachorroDto.getSaude());
        cachorroModel.setVacina(cachorroDto.getVacina());
        cachorroModel.setCuidado_especial(cachorroDto.getCuidado_especial());
        return ResponseEntity.status(HttpStatus.CREATED).body(cachorroService.save(cachorroModel));
    }
}
