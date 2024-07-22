package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {
    
    /**
     * Encontra documentos pelo ID do beneficiário.
     * @param beneficiarioId O ID do beneficiário.
     * @return Uma lista de documentos associados ao beneficiário.
     */
    List<Documento> findByBeneficiarioId(Long beneficiarioId);
    
    /**
     * Encontra documentos pelo tipo de documento, ignorando maiúsculas e minúsculas.
     * @param tipoDocumento O tipo de documento.
     * @return Uma lista de documentos do tipo especificado.
     */
    List<Documento> findByTipoDocumentoIgnoreCase(String tipoDocumento);
}
