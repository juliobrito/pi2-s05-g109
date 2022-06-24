package adotapet.pi2.univesp.controller;

import adotapet.pi2.univesp.dto.GatoDto;
import adotapet.pi2.univesp.model.GatoModel;
import adotapet.pi2.univesp.service.GatoService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/gato")
public class GatoController {

    private final GatoService gatoService;

    public GatoController(GatoService gatoService) {
        this.gatoService = gatoService;
    }

    @PostMapping
    public ResponseEntity<Object> savegato(@RequestBody @Valid GatoDto gatoDto){
        var gatoModel = new GatoModel();
        BeanUtils.copyProperties(gatoDto, gatoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(gatoService.save(gatoModel));
    }

    @GetMapping
    public ResponseEntity<Page<GatoModel>> getAllGato(@PageableDefault Pageable peageable){
        return ResponseEntity.status(HttpStatus.OK).body(gatoService.findAll(peageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneGato(@PathVariable(value = "id") int id){
        Optional<GatoModel> gatoModelOptional = gatoService.findById(id);
        if(!gatoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Gato não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(gatoModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteGato(@PathVariable(value = "id") int id){
        Optional<GatoModel> gatoModelOptional = gatoService.findById(id);
        if(!gatoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Gato não encontrado.");
        }
        gatoService.delete(gatoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Exclusão realizada.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateGato(@PathVariable(value = "id") int id,
                                                 @RequestBody @Valid GatoDto gatoDto) {
        Optional<GatoModel> gatoModelOptional = gatoService.findById(id);
        if (!gatoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Gato não encontrado.");
        }
        var gatoModel = gatoModelOptional.get();
        gatoModel.setIdade(gatoDto.getIdade());
        gatoModel.setPorte(gatoDto.getPorte());
        gatoModel.setSaude(gatoDto.getSaude());
        gatoModel.setVacina(gatoDto.getVacina());
        gatoModel.setCuidado_especial(gatoDto.getCuidado_especial());
        return ResponseEntity.status(HttpStatus.CREATED).body(gatoService.save(gatoModel));
    }
}
