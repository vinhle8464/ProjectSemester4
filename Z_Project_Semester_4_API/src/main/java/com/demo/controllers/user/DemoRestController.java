package com.demo.controllers.user;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/demo")
public class DemoRestController implements ServletContextAware {

	private ServletContext servletContext;

	@RequestMapping(value = "demo1", method = RequestMethod.GET, produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> demo1() {
		try {
			return new ResponseEntity<String>("HelloWorld", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

		}
	}

	@RequestMapping(value = "demo2", method = RequestMethod.GET, produces = MimeTypeUtils.TEXT_HTML_VALUE)
	public ResponseEntity<String> demo2() {
		try {
			return new ResponseEntity<String>("<b><i><u>HelloWorld</u></i></b>", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

		}
	}

	@RequestMapping(value = "demo3/{fullname}", method = RequestMethod.GET, produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> demo3(@PathVariable("fullname") String fullname) {
		try {
			return new ResponseEntity<String>("Hello " + fullname, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

		}
	}

	@RequestMapping(value = "demo4/{a}/{b}", method = RequestMethod.GET, produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> demo4(@PathVariable("a") double a, @PathVariable("b") double b) {
		try {
			return new ResponseEntity<String>(String.valueOf(a + b), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

		}
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public ResponseEntity<Void> upload(@RequestParam("file") MultipartFile file) {
		try {
			System.out.println("file Name: " + file.getOriginalFilename());
			System.out.println("file type: " + file.getContentType());
			System.out.println("file size: " + file.getSize());
			String fileName = processUpload(file);
			System.out.println("fileName: " + fileName);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);

		}
	}

	@RequestMapping(value = "uploads", method = RequestMethod.POST)
	public ResponseEntity<Void> uploads(@RequestParam("file") MultipartFile[] files) {
		try {
			for (MultipartFile file : files) {
				System.out.println("file Name: " + file.getOriginalFilename());
				System.out.println("file type: " + file.getContentType());
				System.out.println("file size: " + file.getSize());
				String fileName = processUpload(file);
				System.out.println("fileName: " + fileName);
			}
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);

		}
	}

	private String processUpload(MultipartFile file) {
		try {
			String name = UUID.randomUUID().toString().replace("-", "");
			int lastIndex = file.getOriginalFilename().lastIndexOf(".");
			String fileName = name + file.getOriginalFilename().substring(lastIndex);
			byte[] bytes = file.getBytes();
			Path path = Paths.get(servletContext.getRealPath("/uploads/" + fileName));
			Files.write(path, bytes);
			return fileName;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;

	}

}
