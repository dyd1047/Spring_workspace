package com.springmvc.comment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.model2.comment.model.CommentDAO;

public class CommentListController implements Controller{
	CommentDAO commentDAO = new CommentDAO();

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//3단계: work
		String board_id = request.getParameter("board_id");
		List commentList = commentDAO.selectAll(Integer.parseInt(board_id));
		
		//4단계
		ModelAndView mav = new ModelAndView();
		mav.addObject("commentList", commentList);
		mav.setViewName("comment/list");
		
		return mav;
	}

}
