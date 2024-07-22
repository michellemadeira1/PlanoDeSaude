package controller;

import java.util.List;
import java.util.Optional;

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
import service.DocumentoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/documentos")
@Tag(name = "Documentos", description = "Endpoints para gerenciar documentos")
public class DocumentoController {

	
    @Autowired
    private DocumentoService documentoService;

    
    
    @ApiOperation(value = "Cria um novo documento")
    @PostMapping
    public ResponseEntity<Documento> createDocumento(@RequestBody Documento documento) {
        Documento novoDocumento = documentoService.saveDocumento(documento);
        return new ResponseEntity<>(novoDocumento, HttpStatus.CREATED);
    }

    
    @ApiOperation(value = "Obtém todos os documentos")
    @GetMapping("/todos")
    public ResponseEntity<List<DocumentoDto>> getAllDocumentos() {
        List<DocumentoDto> documentos = documentoService.findAllDocumentos();  // Certifique-se de que o serviço retorna List<DocumentoDto>
        return new ResponseEntity<>(documentos, HttpStatus.OK);
    }

    
    @ApiOperation(value = "Obtém documentos pelo ID do beneficiário")
    @GetMapping("/{beneficiarioId}/documentos")
    public ResponseEntity<List<Documento>> getDocumentosByBeneficiarioId(@PathVariable("beneficiarioId") Long beneficiarioId) {
        List<Documento> documentos = documentoService.findDocumentosByBeneficiarioId(beneficiarioId);
        if (documentos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(documentos, HttpStatus.OK);
        }
    }
    
    
    @ApiOperation(value = "Atualiza um documento existente")
    @PostMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarDocumento(@PathVariable Long id, @RequestBody @Valid Documento documento) {
        return documentoService.atualizarDocumento(id, documento);
    }
   
    
    @ApiOperation(value = "Deleta um documento pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocumento(@PathVariable Long id) {
        boolean isDeleted = documentoService.deleteDocumento(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
