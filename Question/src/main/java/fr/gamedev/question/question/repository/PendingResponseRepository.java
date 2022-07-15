package fr.gamedev.question.question.repository;

import fr.gamedev.question.question.data.PendingResponse;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "pendingResponse", path = "pendingResponse")
public interface PendingResponseRepository extends PagingAndSortingRepository<PendingResponse, Long> {
    List<PendingResponse> findPendingResponsesByIdUser(@Param("idUser") long idUser);
}
