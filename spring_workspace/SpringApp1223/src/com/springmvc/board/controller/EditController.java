package com.springmvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.model2.board.model.BoardDAO;
import com.model2.domain.Board;

public class EditController implements Controller{
	private BoardDAO boardDAO;
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//3�ܰ�: �Ͻ�Ű��
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		
		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		board.setBoard_id(board_id);
		
		int result = boardDAO.update(board);
		
		ModelAndView mav = new ModelAndView();
		if (result == 0) {
			mav.addObject("msg", "��������");
			mav.setViewName("error/result");
		} else {
			//��Ʈ�ѷ��� �� �� ���ļ� �� ���..
			mav.setViewName("redirect:/board/detail?board_id="+board.getBoard_id());
			//������ jsp�� �����带 ���ϴ� ���
//			mav.setViewName("board/detail");
		}
		
		return mav;
	}

}