package com.demo.services.admin;

import java.util.List;

import org.springframework.data.domain.Page;

import com.demo.entites.CommentAjax;
import com.demo.entites.RoleAjax;
import com.demo.models.Comment;

public interface CommentServiceAdmin {

	
	public List<Comment> findAllComment();

	public Comment findById(int id);

	public CommentAjax findByIdAjax(int commentId);
	

	public Page<Comment> getPage(int currentPage, int pageSize, String sort);

}
