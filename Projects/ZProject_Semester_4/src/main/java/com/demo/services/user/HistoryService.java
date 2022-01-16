package com.demo.services.user;


import org.springframework.data.domain.Page;

import com.demo.models.History;
public interface HistoryService {

	public History findById(int id);

	public History create(History history);

	public History update(History history);

	public Page<History> getAllHistoryByAccountId(int currentPage, int pageSize, String sort, int accountId);
		
}
