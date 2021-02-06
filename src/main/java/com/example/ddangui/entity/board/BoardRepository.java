package com.example.ddangui.entity.board;

import com.example.ddangui.entity.type.enums.Types;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends CrudRepository<Board, Long> {

    Page<Board> findAllByIsAcceptedTrue();

    @Query("SELECT a FROM Board a INNER JOIN Type b WHERE a = b.board AND a.isAccepted = TRUE AND b.types = ?1")
    Page<Board> findAllByIsAcceptedTrueAndType(Types types);

}
