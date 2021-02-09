package com.example.ddangui.entity.comment;

import com.example.ddangui.entity.board.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    Page<Comment> findAllByBoard(Board board, Pageable page);

    void deleteAllByBoard(Board board);

}
