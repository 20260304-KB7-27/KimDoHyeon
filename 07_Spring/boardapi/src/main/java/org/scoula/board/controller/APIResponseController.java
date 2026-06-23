package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.scoula.common.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/board")
@RequiredArgsConstructor // -> final / not null로 된 필드를 포함하는 생성자를 만들어 줌.
public class APIResponseController {

    private final BoardService service;

    @GetMapping("/{no}")
    public ApiResponse<BoardDTO> getById(@PathVariable Long no) {

        BoardDTO boardDTO = service.get(no);
        return ApiResponse.ok(boardDTO);
    }
}
