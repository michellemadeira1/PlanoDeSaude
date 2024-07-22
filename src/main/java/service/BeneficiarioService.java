package service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import model.Beneficiario;
import model.BeneficiarioDto;
import model.DocumentoDto;
import repository.BeneficiarioRepository;

@Service
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    
   
    
    public ResponseEntity<Beneficiario> postarBeneficiario(Beneficiario beneficiario) {
        Optional<Beneficiario> usuarioExiste = beneficiarioRepository.findByNome(beneficiario.getNome());

        if (usuarioExiste.isPresent()) {
            return ResponseEntity.status(406).build();
        } else {
            return ResponseEntity.ok(beneficiarioRepository.save(beneficiario));
        }
    }

   
    public ResponseEntity<List<Beneficiario>> findAllBeneficiarios() {
        List<Beneficiario> listaDeUsuario = beneficiarioRepository.findAll();

        if (listaDeUsuario.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(listaDeUsuario);
        }
    }

   
    public ResponseEntity<Beneficiario> findBeneficiarioById(Long id) {
        return beneficiarioRepository.findById(id)
                .map(idExiste -> ResponseEntity.status(200).body(idExiste))
                .orElse(ResponseEntity.status(404).build());
    }

    public ResponseEntity<Beneficiario> atualizarBeneficiario(Long id, Beneficiario beneficiarioDetails) {
        return beneficiarioRepository.findById(id)
                .map(beneficiario -> {
                    beneficiario.setNome(beneficiarioDetails.getNome());
                    beneficiario.setTelefone(beneficiarioDetails.getTelefone());
                    beneficiario.setDataNascimento(beneficiarioDetails.getDataNascimento());
                    beneficiario.setDataAtualizacao(beneficiarioDetails.getDataAtualizacao());
                    return ResponseEntity.status(201).body(beneficiarioRepository.save(beneficiario));
                }).orElse(ResponseEntity.status(401).build());
    }

    
    
    public BeneficiarioDto getBeneficiarioByIdDto(Long id) {
        Beneficiario beneficiario = beneficiarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Beneficiário não encontrado"));
        
        BeneficiarioDto dto = new BeneficiarioDto();
        dto.setId(beneficiario.getId());
        dto.setNome(beneficiario.getNome());
        dto.setTelefone(beneficiario.getTelefone());
        dto.setDataNascimento(beneficiario.getDataNascimento());
        dto.setDataInclusao(beneficiario.getDataInclusao());
        dto.setDataAtualizacao(beneficiario.getDataAtualizacao());
        
        // Mapeia a lista de documentos
        List<DocumentoDto> documentosDto = beneficiario.getDocumentos().stream()
                .map(doc -> {
                    DocumentoDto docDTO = new DocumentoDto();
                    docDTO.setId(doc.getId());
                    docDTO.setTipoDocumento(doc.getTipoDocumento());
                    docDTO.setDescricao(doc.getDescricao());
                    docDTO.setDataInclusao(doc.getDataInclusao());
                    docDTO.setDataAtualizacao(doc.getDataAtualizacao());
                    return docDTO;
                })
                .collect(Collectors.toList());
        
        dto.setDocumentos(documentosDto);
        return dto;
    }

    
    public Beneficiario getBeneficiarioById(Long id) {
        Beneficiario beneficiario = beneficiarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Beneficiário não encontrado"));
        // Força a inicialização das coleções
        beneficiario.getDocumentos().size();
        return beneficiario;
    }
  
    public boolean deleteBeneficiario(Long id) {
        return beneficiarioRepository.findById(id)
                .map(beneficiario -> {
                    beneficiarioRepository.delete(beneficiario);
                    return true;
                }).orElse(false);
    }
}
