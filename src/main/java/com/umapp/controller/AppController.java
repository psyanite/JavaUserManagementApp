package com.umapp.controller;

import java.util.List;
import java.util.Locale;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.umapp.model.User;
import com.umapp.service.UserService;
 
@Controller
@RequestMapping("/")
public class AppController {
 
    @Autowired
    UserService service;
     
    @Autowired
    MessageSource messageSource;
 
    /*
     * This method will list all existing users.
     */
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
 
        List<User> users = service.getAllUsers();
        model.addAttribute("users", users);
        return "list";
    }
 
    /*
     * This method will provide the medium to add a new user.
     */
    @RequestMapping(value = { "/create" }, method = RequestMethod.GET)
    public String createUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "create";
    }
 
    /*
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    @RequestMapping(value = { "/create" }, method = RequestMethod.POST)
    public String createUser(@Valid User user, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "create";
        }
 
        if(!service.isUsernameUnique(user.getUserId(), user.getUsername())){
            FieldError usernameError =new FieldError("user","username",messageSource.getMessage("non.unique.username", new String[]{user.getUsername()}, Locale.getDefault()));
            result.addError(usernameError);
            return "create";
        }
         
        service.createUser(user);
 
        model.addAttribute("success", "User " + user.getUserId() + " created successfully");
        return "success";
    }
 
 
    /*
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = { "/user/edit/{id}" }, method = RequestMethod.GET)
    public String editUser(@PathVariable String id, ModelMap model) {
    	// TODO: Add error handing for parseInt if null
        User user = service.getUserById(Integer.parseInt(id));
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "create";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = { "/user/edit/{id}" }, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result,
            ModelMap model, @PathVariable String id) {
 
        if (result.hasErrors()) {
            return "create";
        }
 
        if(!service.isUsernameUnique(user.getUserId(), user.getUsername())){
            FieldError usernameError =new FieldError("user","username",messageSource.getMessage("non.unique.username", new String[]{user.getUsername()}, Locale.getDefault()));
            result.addError(usernameError);
            return "create";
        }
 
        service.updateUser(user);
 
        model.addAttribute("success", "User " + user.getUserId()  + " updated successfully");
        return "success";
    }
 
     
    /*
     * This method will delete an user by it's SSN value.
     */
    @RequestMapping(value = { "/user/delete/{id}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String id) {
    	// TODO: Add error handing for parseInt if null
        service.deleteUserById(Integer.parseInt(id));
        return "redirect:/list";
    }
 
}