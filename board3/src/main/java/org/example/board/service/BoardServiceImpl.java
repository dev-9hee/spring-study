package org.example.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.example.board.domain.Board;
import org.example.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    @Override
    public List<Board> getList() {
        return boardMapper.getList();
    }

    @Override
    public void create(Board board) { boardMapper.create(board); }

    @Override
    public Board detail(Long id) {
        return boardMapper.detail(id);
    }

    @Override
    public Board delete(Long id) {
        boardMapper.delete(id);
        return detail(id);
    }

    // 문제 5-2. 게시글 수정 기능 구현하기
    @Override
    public Board update(Board board) {
        // 아래의 코드는 JAVA 의 컴파일 에러를 막기 위한 코드입니다.
        // 조건에 맞는 코드로 코드를 수정하여 주세요.
        // 조건 : boardMapper 를 이용하여 실제로 게시글을 업데이트한 이후, 업데이트 된 게시글을 리턴하는 기능
        boardMapper.update(board);
        return detail(board.getId());
    }
}
