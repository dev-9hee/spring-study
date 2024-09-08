package org.example.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.example.board.domain.Board;
import org.example.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j
@RequestMapping("/rest/board")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BoardRestController {
    // @RequiredArgsConstructor 에 의해 의존성이 자동으로 주입 됩니다
    private final BoardService boardService;

    // 문제 1. 게시판 목록 기능 구현하기    
    @GetMapping("/list")
    public ResponseEntity<List<Board>> listPage() {
        // 여기 부분에 코드를 완성하여, 게시판 목록 기능을 완성시켜 주세요
        List<Board> boardList = boardService.getList();

        if (boardList.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(boardList);
    }

    // 문제 2. 게시글 작성 기능 구현하기
    @PostMapping("/create")
    public ResponseEntity<String> create(
            @RequestBody Board newBoard
    ) {
        // 여기 부분에 코드를 완성하여, 게시글 작성 기능을 완성시켜 주세요
        boardService.create(newBoard);
        return ResponseEntity.ok("수정 성공!!");
    }

    // 문제 3. 게시글 내용 보기 기능 구현하기
    @GetMapping("/detail/{id}")
    public ResponseEntity<Board> detailPage(
            @PathVariable("id") Long id
    ) {
        // 여기 부분에 코드를 완성하여, 게시글 내용 보기 기능을 완성시켜 주세요
        Board detailBoard = boardService.detail(id);
        if (detailBoard == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(detailBoard);
    }

    // 문제 4. 게시글 삭제 기능 구현하기
    @PostMapping(value = "/delete", produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> delete(@RequestParam("id") Long id) {
        // 여기 부분에 코드를 완성하여, 게시글 삭제 기능을 완성시켜 주세요
        boardService.delete(id);
        return ResponseEntity.ok("삭제 성공!");
    }

    // 문제 5-2. 게시글 수정 기능 구현하기
    @PostMapping("/update")
    public ResponseEntity<String> update(
            @RequestBody Board updateBoard
    ) {
        // 여기 부분에 코드를 완성하여, 게시글 수정 기능을 완성시켜 주세요
        Board update = boardService.update(updateBoard);
        if (update == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("수정 성공!");
    }
}
