package com.demo.repositories.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entites.CommentAjax;
import com.demo.models.Comment;

@Repository
public interface CommentRepositoryAdmin extends JpaRepository<Comment, Integer> {

	@Query("select new com.demo.entites.CommentAjax(commentId, account.fullname, quiz.title, comment, status, createDate) from Comment where commentId = :commentId")
	public CommentAjax findByIdAjax(@Param("commentId") int commentId);
	
}
