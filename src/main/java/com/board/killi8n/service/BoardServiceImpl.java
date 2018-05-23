package com.board.killi8n.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.killi8n.domain.BoardVO;
import com.board.killi8n.persistance.BoardDAOImpl;

@Service
public class BoardServiceImpl implements BoardService {

	
	@Inject
	BoardDAOImpl dao;
	
	@Override
	public List<BoardVO> GetAllBoardList() {
		// TODO Auto-generated method stub
		return dao.GetAllBoardList();
	}

	@Override
	public void CreateBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		dao.CreateBoard(boardVO);
		
	}

	@Override
	public BoardVO ReadBoard(int bno) {
		// TODO Auto-generated method stub
		return dao.ReadBoard(bno);
	}

	@Override
	public void UpdateBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		dao.UpdateBoard(boardVO);
	}

	@Override
	public void DeleteBoard(int bno) {
		// TODO Auto-generated method stub
		dao.DeleteBoard(bno);
	}

	@Override
	public int GetCount() {
		// TODO Auto-generated method stub
		
		return dao.GetCount();
		
	}

	@Override
	public List<BoardVO> GetListWithPages(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.GetListWithPages(map);
	}

}
