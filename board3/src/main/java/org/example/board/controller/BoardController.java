package org.example.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.example.board.domain.Board;
import org.example.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Log4j
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    // @RequiredArgsConstructor 에 의해 의존성이 자동으로 주입 됩니다
    private final BoardService boardService;
    private final String context = "/board";

    // 문제 1. 게시판 목록 기능 구현하기    
    @GetMapping("/list")
    public String listPage(Model model) {
        // 여기 부분에 코드를 완성하여, 게시판 목록 기능을 완성시켜 주세요
        List<Board> boardList = boardService.getList();
        model.addAttribute("boardList", boardList);
        return context + "/list";
    }

    // 게시글 작성 모드 페이지로 이동하는 메서드 -> 이미 완성 된 상태
    @GetMapping("/create")
    public String createPage() {
        return context + "/create";
    }

    // 문제 2. 게시글 작성 기능 구현하기
    @PostMapping("/create")
    public String create(
            @ModelAttribute Board newBoard
    ) {
        // 여기 부분에 코드를 완성하여, 게시글 작성 기능을 완성시켜 주세요
        boardService.create(newBoard);
        return "redirect:/board/list";
    }

    // 문제 3. 게시글 내용 보기 기능 구현하기
    @GetMapping("/detail")
    public String detailPage(
            @RequestParam("id") Long id,
            Model model
    ) {
        // 여기 부분에 코드를 완성하여, 게시글 내용 보기 기능을 완성시켜 주세요
        Board board = boardService.detail(id);
        model.addAttribute("board", board);
        return context + "/detail";
    }

    // 문제 4. 게시글 삭제 기능 구현하기
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        // 여기 부분에 코드를 완성하여, 게시글 삭제 기능을 완성시켜 주세요
        boardService.delete(id);
        return "redirect:/board/list";
    }

    // 문제 5-1. 게시글 수정 기능 구현하기
    @GetMapping("/update")
    public String updatePage(
            @RequestParam("id") Long id,
            Model model
    ) {
        // 여기 부분에 코드를 완성하여, 게시글 수정 페이지 이동 기능을 완성시켜 주세요
        Board board = boardService.detail(id);
        model.addAttribute("board", board);
        return context + "/update";
    }

    // 문제 5-2. 게시글 수정 기능 구현하기
    @PostMapping("/update")
    public String update(
            @ModelAttribute Board updateBoard
    ) {
        // 여기 부분에 코드를 완성하여, 게시글 수정 기능을 완성시켜 주세요
        boardService.update(updateBoard);
        return "redirect:/board/list";
    }
}
