package com.timebank.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.timebank.model.User;
import com.timebank.service.UserService;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class SignupController implements ServletContextAware{

	ServletContext servletContext;
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String viewSignup (ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "signup";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String afterSignup (@Valid User user, BindingResult result, ModelMap modelMap,@RequestParam(value = "image", required = false) MultipartFile image) {
        if(result.hasErrors()) {
            return "signup";
        }
        List<User> users = userService.getUsers();
        for(User singleUser : users) {
            if(singleUser.getEmail().equals(user.getEmail())) {
                modelMap.addAttribute("resultMessage", "There is already a registered user with the same email id!");
                return "result";
            }
        }
        
   	 if (!image.isEmpty()) {
   	 try {
   	 validateImage(image);
   	 saveImage(user.getFirstName() +user.getLastName() + ".jpg",image);
  
   	 } catch (Exception e) {
   		 e.printStackTrace();
   	
   	 }
   	 }
 	 String profilePicturePath ="C:\\Users\\Narcisa\\git\\TImebankRepo\\timebankRegistration\\src\\main\\resources\\uploads"
		 		+ "\\"+ user.getFirstName() +user.getLastName() + ".jpg";
   	 user.setProfilePicture(profilePicturePath);
   	 System.out.println(profilePicturePath);
        System.out.println(modelMap.get("firstName"));
        userService.addUser(user);
        modelMap.addAttribute("resultMessage", "Congratulations " + user.getFullName() + "! You are Successfully Signed up.");
        return "result";
    }
    private void validateImage(MultipartFile image) {
   	 if (!image.getContentType().equals("image/jpeg")) {
   	 throw new RuntimeException("Only JPG images are accepted");
   	 }
   	 }
    
    private void saveImage(String filename, MultipartFile image)
    		 throws RuntimeException, IOException {
    		 try {
    		 File file = new File( "C:\\Users\\Narcisa\\git\\TImebankRepo\\timebankRegistration\\src\\main\\resources\\uploads"
    		 		+ "\\"
    		 + filename);
    		  
    		 FileUtils.writeByteArrayToFile(file, image.getBytes());
    		 System.out.println("Go to the location:  " + file.toString()
    		 + " on your computer and verify that the image has been stored.");
    		 } catch (IOException e) {
    		 throw e;
    		 }
    		 }

	@Override
	public void setServletContext(ServletContext servletContext) {
            this.servletContext = servletContext;		
	}
}
