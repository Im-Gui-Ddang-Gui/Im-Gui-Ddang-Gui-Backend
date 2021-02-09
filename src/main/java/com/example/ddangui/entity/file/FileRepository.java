package com.example.ddangui.entity.file;

import com.example.ddangui.entity.board.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileRepository extends CrudRepository<File, Long> {
    Optional<File> findByBoard(Board board);
}
