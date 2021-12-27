//package com.demo.controllers.admin;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Order;
//
//import com.demo.models.Account;
//import com.demo.repositories.admin.AccountRepositoryAdmin;
//
//@RestController
//@RequestMapping("/api/admin")
//public class PaginationRestController {
//
//	@Autowired
//	private AccountRepositoryAdmin accountRepositoryAdmin;
//	
//	@GetMapping("/tutorials")
//	  public ResponseEntity<Map<String, Object>> getAllTutorialsPage(
//	      @RequestParam(required = false) String username,
//	      @RequestParam(defaultValue = "0") int page,
//	      @RequestParam(defaultValue = "3") int size,
//	      @RequestParam(defaultValue = "id,desc") String[] sort) {
//
//	    try {
//	      List<Order> orders = new ArrayList<Order>();
//
//	      if (sort[0].contains(",")) {
//	        // will sort more than 2 fields
//	        // sortOrder="field, direction"
//	        for (String sortOrder : sort) {
//	          String[] _sort = sortOrder.split(",");
//	          orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
//	        }
//	      } else {
//	        // sort=[field, direction]
//	        orders.add(new Order(getSortDirection(sort[1]), sort[0]));
//	      }
//
//	      List<Account> accounts = new ArrayList<Account>();
//	      Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));
//
//	      Page<Account> pageTuts;
//	      if (username == null)
//	        pageTuts = accountRepositoryAdmin.findAll(pagingSort);
//	      else
//	        pageTuts = accountRepositoryAdmin.findByUsernameContaining(username, pagingSort);
//
//	      accounts = pageTuts.getContent();
//
//	      if (accounts.isEmpty()) {
//	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	      }
//
//	      Map<String, Object> response = new HashMap<>();
//	      response.put("tutorials", accounts);
//	      response.put("currentPage", pageTuts.getNumber());
//	      response.put("totalItems", pageTuts.getTotalElements());
//	      response.put("totalPages", pageTuts.getTotalPages());
//
//	      return new ResponseEntity<>(response, HttpStatus.OK);
//	    } catch (Exception e) {
//	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//	    }
//	  }
//}
