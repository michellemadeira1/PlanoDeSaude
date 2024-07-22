package service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import model.Beneficiario;
import model.BeneficiarioDto;
import model.Documento;
import model.DocumentoDto;
import repository.DocumentoRepository;

@Service
@Transactional
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    /**
     * Salva um documento no repositório.
     * @param documento O documento a ser salvo.
     * @return O documento salvo.
     */
    public Documento saveDocumento(Documento documento) {
        return documentoRepository.save(documento);
    }

    /**
     * Recupera todos os documentos do repositório e os converte para DTOs.
     * @return Uma lista de todos os documentos como DTOs.
     */
    
    
    public List<DocumentoDto> findAllDocumentos() {
        List<Documento> documentos = documentoRepository.findAll();
        documentos.forEach(doc -> {
            if (doc.getBeneficiario() != null) {
                doc.getBeneficiario().getNome();  // Acessar um campo para inicializar o proxy
            }
        });
        return documentos.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }




    /**
     * Busca documentos por ID do beneficiário.
     * @param beneficiarioId O ID do beneficiário.
     * @return Uma lista de documentos associados ao beneficiário.
     */
    public List<Documento> findDocumentosByBeneficiarioId(Long beneficiarioId) {
        return documentoRepository.findByBeneficiarioId(beneficiarioId);
    }

    /**
     * Busca documentos por tipo de documento, ignorando maiúsculas e minúsculas.
     * @param tipoDocumento O tipo de documento.
     * @return Uma lista de documentos do tipo especificado.
     */
    public List<Documento> findDocumentosByTipoDocumento(String tipoDocumento) {
        return documentoRepository.findByTipoDocumentoIgnoreCase(tipoDocumento);
    }

    /**
     * Deleta um documento por ID.
     * @param id O ID do documento a ser deletado.
     * @return True se o documento foi deletado, false caso contrário.
     */
    public boolean deleteDocumento(Long id) {
        return documentoRepository.findById(id).map(documento -> {
            documentoRepository.delete(documento);
            return true;
        }).orElse(false);
    }
    
    public ResponseEntity<Documento> atualizarDocumento(Long id, Documento documentoDetails) {
        return documentoRepository.findById(id)
                .map(documento -> {
                    documento.setTipoDocumento(documentoDetails.getTipoDocumento());
                    documento.setDescricao(documentoDetails.getDescricao());
                    documento.setDataInclusao(documentoDetails.getDataInclusao());
                    documento.setDataAtualizacao(documentoDetails.getDataAtualizacao());
                    Documento updatedDocumento = documentoRepository.save(documento);
                    return ResponseEntity.ok(updatedDocumento);
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    /**
     * Converte uma entidade Documento para um DTO DocumentoDto.
     * @param documento A entidade Documento a ser convertida.
     * @return O DTO correspondente DocumentoDto.
     */
    private DocumentoDto convertToDto(Documento documento) {
        DocumentoDto dto = new DocumentoDto();
        dto.setId(documento.getId());
        dto.setTipoDocumento(documento.getTipoDocumento());
        dto.setDescricao(documento.getDescricao());
        dto.setDataInclusao(documento.getDataInclusao());
        dto.setDataAtualizacao(documento.getDataAtualizacao());

        // Verifica se o beneficiário está presente e adiciona os detalhes ao DTO
        if (documento.getBeneficiario() != null) {
            BeneficiarioDto beneficiarioDto = new BeneficiarioDto();
            beneficiarioDto.setId(documento.getBeneficiario().getId());
            beneficiarioDto.setNome(documento.getBeneficiario().getNome());
            beneficiarioDto.setTelefone(documento.getBeneficiario().getTelefone());
            beneficiarioDto.setDataNascimento(documento.getBeneficiario().getDataNascimento());
            beneficiarioDto.setDataInclusao(documento.getBeneficiario().getDataInclusao());
            beneficiarioDto.setDataAtualizacao(documento.getBeneficiario().getDataAtualizacao());

            // Adiciona o beneficiário ao DTO do documento
            dto.setBeneficiario(beneficiarioDto);
        }

        return dto;
    }
    
   
    
}
