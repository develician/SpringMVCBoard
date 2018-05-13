package com.board.killi8n.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.killi8n.domain.BoardVO;
import com.board.killi8n.service.BoardServiceImpl;

@Controller
public class BoardController {
	
	@Inject
	BoardServiceImpl service;
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public String boardIndex(Model model) {
		List<BoardVO> boards;
		
		try {
			boards = service.GetAllBoardList();
			model.addAttribute("boards", boards);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "board/boardIndex";
	}
	
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public String boardWrite(String actionState, Model model) {
		actionState = "write";
		model.addAttribute("actionState", actionState);
		return "board/boardWrite";
		
		
	}
	
	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	public String boardWriteAction(BoardVO vo, Model model) {
		
		try {
			service.CreateBoard(vo);
			model.addAttribute("message", "Success!");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "board/writeSuccess";
	}
	
	@RequestMapping(value="/board/{id}", method=RequestMethod.GET)
	public String boardDetail(@PathVariable int id, BoardVO vo, Model model) {
		
		try {
			vo = service.ReadBoard(id);
			model.addAttribute("vo", vo);
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return "board/boardDetail";
	}
	
	@RequestMapping(value="/board/update/{id}", method=RequestMethod.POST)
	public String boardUpdateAction(Model model, BoardVO vo, @PathVariable int id) {
		try {
			service.UpdateBoard(vo);
			model.addAttribute("message", "updated!");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "board/writeSuccess";
	}
	
	@RequestMapping(value="/board/update/{id}", method=RequestMethod.GET)
	public String boardUpdate(Model model, BoardVO vo, @PathVariable int id, String actionState) {
		try {
			actionState = "update";
			vo = service.ReadBoard(id);
			model.addAttribute("vo", vo);
			model.addAttribute("actionState", actionState);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "board/boardWrite";
	}
	
	@RequestMapping(value="/board/remove/{id}", method=RequestMethod.GET)
	public String boardDetail(@PathVariable int id, Model model) {
		
		try {
			model.addAttribute("confirmMessage", "정말로 " + id + "번 게시물을 삭제할까요?");
			model.addAttribute("bno", id);
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return "board/removeConfirm";
	}
	
	
	@RequestMapping(value="/board/delete/{id}", method=RequestMethod.POST)
	public String boardRemove(@RequestParam(value="bno", defaultValue="0", required=false) int bno, Model model)
	{
		try {
			service.DeleteBoard(bno);
			model.addAttribute("message", "removed!");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "board/writeSuccess";
	}
	
	
}
