package org.example.board.service;

import org.example.board.domain.Board;

import java.util.List;

public interface BoardService {
    List<Board> getList();
    Board detail(Long id);
    void create(Board board);
    Board update(Board board);
    Board delete(Long id);
}
