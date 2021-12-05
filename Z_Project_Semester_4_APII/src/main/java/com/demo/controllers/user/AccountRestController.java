package com.demo.controllers.user;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.demo.models.AccountInfo;
import com.demo.models.AccountInfoCreate;
import com.demo.models.RoleInfo;
import com.demo.services.AccountService;

@RestController
@RequestMapping("api/user/account")
public class AccountRestController {

	@Autowired
	private AccountService accountService;
	
	
	@RequestMapping(value = "findall", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AccountInfo>> findall(){
		try {
			return new ResponseEntity<List<AccountInfo>>(accountService.findAllAccount(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<AccountInfo>>( HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@RequestMapping(value = "findbyid/{username}", method = RequestMethod.GET,	
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountInfo> findbyid(@PathVariable("username") String username){
		try {
		
			return new ResponseEntity<AccountInfo>(accountService.findByUsername(username), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<AccountInfo>( HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST,
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountInfo> create(@RequestBody AccountInfoCreate accountInfoCreate){
		try {
		
			return new ResponseEntity<AccountInfo>(accountService.create(accountInfoCreate), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<AccountInfo>( HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT,
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountInfo> create(@PathVariable("id") int id, @RequestBody AccountInfo accountInfo){
		try {
		
			return new ResponseEntity<AccountInfo>(accountService.update(id, accountInfo), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<AccountInfo>( HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		try {
			accountService.delete(id);
			return new ResponseEntity<Void>( HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>( HttpStatus.BAD_REQUEST);
			
		}
	}
	

	

}
