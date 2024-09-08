package org.example.board.mapper;

import org.example.board.domain.Board;

import java.util.List;

public interface BoardMapper {
    List<Board> getList();
    Board detail(Long id);
    int create(Board board);
    int update(Board board);
    int delete(Long id);
}
