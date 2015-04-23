package Royal.pais.logic.ejb;

import Royal.pais.logic.api.IPaisLogic;
import Royal.pais.logic.converter.PaisConverter;
import Royal.pais.logic.dto.PaisDTO;
import Royal.pais.logic.dto.PaisPageDTO;
import Royal.pais.logic.entity.PaisEntity;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless 
@LocalBean
public class PaisLogic implements IPaisLogic{

    @PersistenceContext(unitName = "RoyalPU")
    protected EntityManager entityManager;

    public PaisDTO createCountry(PaisDTO country) {
        PaisEntity entity = PaisConverter.persistenceDTO2Entity(country);
        entityManager.persist(entity);
        return PaisConverter.entity2PersistenceDTO(entity);
    }

    public List<PaisDTO> getCountries() {
        Query q = entityManager.createQuery("select u from CountryEntity u");
        return PaisConverter.entity2PersistenceDTOList(q.getResultList());
    }

    public PaisPageDTO getCountries(Integer page, Integer maxRecords) {
        Query count = entityManager.createQuery("select count(u) from CountryEntity u");
        Long regCount = 0L;
        regCount = Long.parseLong(count.getSingleResult().toString());
        Query q = entityManager.createQuery("select u from CountryEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        PaisPageDTO response = new PaisPageDTO();
        response.setTotalRecords(regCount);
        response.setRecords(PaisConverter.entity2PersistenceDTOList(q.getResultList()));
        return response;
    }

    public PaisDTO getCountry(Long id) {
        return PaisConverter.entity2PersistenceDTO(entityManager.find(PaisEntity.class, id));
    }

    public void deleteCountry(Long id) {
        PaisEntity entity = entityManager.find(PaisEntity.class, id);
        entityManager.remove(entity);
    }

    public void updateCountry(PaisDTO country) {
        PaisEntity entity = entityManager.merge(PaisConverter.persistenceDTO2Entity(country));
        PaisConverter.entity2PersistenceDTO(entity);
    }

    public PaisDTO getMostPopulated() {
        Query query = entityManager.createQuery("select u from CountryEntity u WHERE u.population = (SELECT MAX(v.population) from CountryEntity v)");
        return PaisConverter.entity2PersistenceDTO((PaisEntity)query.getSingleResult());
    }

    public PaisDTO getLeastPopulated() {
        Query query = entityManager.createQuery("select u from CountryEntity u WHERE u.population = (SELECT MIN(v.population) from CountryEntity v)");
        return PaisConverter.entity2PersistenceDTO((PaisEntity)query.getSingleResult());
    }
}
