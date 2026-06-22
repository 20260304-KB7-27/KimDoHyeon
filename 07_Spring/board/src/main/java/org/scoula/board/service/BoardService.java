package org.scoula.board.service;

import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {
    /* 게시글 전체 조회 */
    public List<BoardDTO> getList();

    /* 게시글 단건 조회 */
    public BoardDTO get(Long no);

    /* 게시글 생성 */
    public void create(BoardDTO board);

    /* 사진 업로드 */
//    public void upload(Long bno, List<MultipartFile> files);

    /* 게시글 수정 */
    public boolean update(BoardDTO board);

    /* 게시글 삭제 */
    public boolean delete(Long no);

    // 첨부파일 단건 조희
    BoardAttachmentVO getAttachment(Long no);
}