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
import com.demo.models.Role;
import com.demo.models.RoleInfo;
import com.demo.services.user.AccountService;
import com.demo.services.user.RoleService;

@RestController
@RequestMapping("api/user/role")
public class RoleRestController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "findbyid/{roleId}", method = RequestMethod.GET,	
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<RoleInfo> findbyid(@PathVariable("roleId") String roleId){
		try {
			return new ResponseEntity<RoleInfo>(roleService.find(roleId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RoleInfo>( HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "findall", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RoleInfo>> findall(){
		try {
			return new ResponseEntity<List<RoleInfo>>(roleService.findAllRole(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<RoleInfo>>( HttpStatus.BAD_REQUEST);
			
		}
	}
	

}
