package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import model.Beneficiario;
import model.Documento;
import model.DocumentoDto;
import service.BeneficiarioService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/beneficiarios")
@Tag(name = "Beneficiários", description = "Endpoints para gerenciar beneficiários")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService beneficiarioService;
    

    @ApiOperation(value = "Cria um novo beneficiário")
    @PostMapping
    public ResponseEntity<Beneficiario> criarBeneficiario(@RequestBody @Valid Beneficiario beneficiario) {
        return beneficiarioService.postarBeneficiario(beneficiario);
    }

    @ApiOperation(value = "Obtém um beneficiário pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<Beneficiario> obterBeneficiarioPorId(@PathVariable Long id) {
        return beneficiarioService.findBeneficiarioById(id);
    }
    
  
    @ApiOperation(value = "Obtém todos os beneficiários")
    @GetMapping("/todos")
    public ResponseEntity<List<Beneficiario>> obterTodosBeneficiarios() {
        return beneficiarioService.findAllBeneficiarios();
    }

    
    @ApiOperation(value = "Atualiza um beneficiário pelo id")
    @PostMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarBeneficiario(@PathVariable Long id, @RequestBody @Valid Beneficiario beneficiario) {
        return beneficiarioService.atualizarBeneficiario(id, beneficiario);
    }

    
    @ApiOperation(value = "Deleta um beneficiário pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBeneficiario(@PathVariable Long id) {
        boolean isDeleted = beneficiarioService.deleteBeneficiario(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
