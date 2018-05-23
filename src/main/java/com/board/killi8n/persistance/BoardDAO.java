package com.board.killi8n.persistance;

import java.util.List;
import java.util.Map;

import com.board.killi8n.domain.BoardVO;



public interface BoardDAO {
	public List<BoardVO> GetAllBoardList();
	public void CreateBoard(BoardVO boardVO);
	public BoardVO ReadBoard(int bno);
	public void UpdateBoard(BoardVO boardVO);
	public void DeleteBoard(int bno);
	public int GetCount();
	public List<BoardVO> GetListWithPages(Map<String, String> map);
}
