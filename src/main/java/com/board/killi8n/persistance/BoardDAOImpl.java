package com.board.killi8n.persistance;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.killi8n.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	SqlSession session;
	
	private static final String NAME_SPACE = "com.board.killi8n.mappers.BoardMapper";
	
	@Override
	public List<BoardVO> GetAllBoardList() {
		// TODO Auto-generated method stub
		return session.selectList(NAME_SPACE + ".selectBoardListAll");
	}

	@Override
	public void CreateBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		session.insert(NAME_SPACE + ".createBoard", boardVO);
	}	

	@Override
	public BoardVO ReadBoard(int bno) {
		// TODO Auto-generated method stub
		return session.selectOne(NAME_SPACE +  ".selectBoard", bno);
	}

	@Override
	public void UpdateBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		session.update(NAME_SPACE + ".updateBoard", boardVO);
	}

	@Override
	public void DeleteBoard(int bno) {
		// TODO Auto-generated method stub
		session.delete(NAME_SPACE + ".deleteBoard", bno);
	}

	@Override
	public int GetCount() {
		// TODO Auto-generated method stub
		return session.selectOne(NAME_SPACE + ".getCount");
	}

	@Override
	public List<BoardVO> GetListWithPages(Map<String, String> map) {
		// TODO Auto-generated method stub
		return session.selectList(NAME_SPACE + ".selectBoardWithPage", map);
	}

}
