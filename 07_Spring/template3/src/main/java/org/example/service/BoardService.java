package org.example.service;

import org.example.domain.BoardVO;
import org.example.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private BoardMapper mapper;

    @Autowired // DI
    public BoardService(BoardMapper mapper){
        this.mapper = mapper;
    }

    public List<BoardVO> getAllBoardByMapper() {
        // 전처리
        List<BoardVO> boardVOS = mapper.selectAllByMapper();

        return boardVOS;
    }


    public List<BoardVO> getAllBoardByAnnotation() {
        // 전처리
        List<BoardVO> boardVOS = mapper.selectAllByAnnotation();

        return boardVOS;
    }

}
