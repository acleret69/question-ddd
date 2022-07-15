package fr.gamedev.question.question.repository;

import fr.gamedev.question.question.data.PendingResponse;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "PendingResponse", path = "PendingResponse")
public interface PendingResponseRepository extends PagingAndSortingRepository<PendingResponse, Long> {

}
