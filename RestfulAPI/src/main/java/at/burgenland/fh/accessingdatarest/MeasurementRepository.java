package at.burgenland.fh.accessingdatarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "measurements", path = "measurements")
public interface MeasurementRepository extends PagingAndSortingRepository<Measurement, Long> {

}

