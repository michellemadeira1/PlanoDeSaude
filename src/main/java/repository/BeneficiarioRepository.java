package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.Beneficiario;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
    
    /**
     * Encontra todos os beneficiários com seus documentos associados.
     * @return Uma lista de beneficiários com documentos.
     */
    @Query("SELECT b FROM Beneficiario b JOIN FETCH b.documentos")
    List<Beneficiario> findAllWithDocumentos();
    
    /**
     * Encontra beneficiários pelo ID.
     * @param id O ID do beneficiário.
     * @return Uma lista de beneficiários com o ID especificado.
     */
    List<Beneficiario> findBeneficiarioById(Long id);

    /**
     * Encontra um beneficiário pelo nome.
     * @param nome O nome do beneficiário.
     * @return Um Optional contendo o beneficiário, se encontrado.
     */
    Optional<Beneficiario> findByNome(String nome);
    
    
}
