package com.timebank.controller;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.timebank.model.User;

@Controller
@RequestMapping(value="/upload")
public class ProfileController {
	 private static final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.
	  String filePath ="C:\\Users\\Narcisa\\git\\TImebankRepo\\timebankRegistration\\src\\main\\resources\\uploads";

	  @Autowired 
		HttpSession session;
	  
	  
	  @RequestMapping(method = RequestMethod.GET)
	 public void showImage(HttpServletRequest request,
	            HttpServletResponse response) throws FileNotFoundException, IOException {
		    response.setContentType("image/jpeg");
			javax.servlet.ServletOutputStream out;
			out = response.getOutputStream();
			User user = (User) session.getAttribute("user");
			System.out.println(user.getProfilePicture());
			String profilePicture = user.getProfilePicture();
			FileInputStream fin = new FileInputStream(profilePicture);
			
			BufferedInputStream bin = new BufferedInputStream(fin);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			int ch =0; ;
			while((ch=bin.read())!=-1)
			{
			bout.write(ch);
			}
			
			bin.close();
			fin.close();
			bout.close();
			out.close();
			}
		 
	 
	 private static void close(Closeable resource) {
	        if (resource != null) {
	            try {
	                resource.close();
	            } catch (IOException e) {
	                // Do your thing with the exception. Print it, log it or mail it.
	                e.printStackTrace();
	            }
	        }
	    }
}
