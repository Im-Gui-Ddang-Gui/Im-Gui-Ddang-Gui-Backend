package com.example.ddangui.entity.board;

import com.example.ddangui.entity.type.enums.Field;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends CrudRepository<Board, Long> {

    Page<Board> findAllByIsAcceptedTrue(Pageable page);

    @Query("SELECT a FROM Board a INNER JOIN Type b WHERE a = b.board AND a.isAccepted = TRUE AND b.field = ?1")
    Page<Board> findAllByIsAcceptedTrueAndType(Field field, Pageable page);

}
