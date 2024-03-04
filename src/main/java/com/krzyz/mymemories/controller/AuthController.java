package com.krzyz.mymemories.controller;

import com.krzyz.mymemories.dto.UserDto;
import com.krzyz.mymemories.model.User;
import com.krzyz.mymemories.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class AuthController {

    UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }



    @GetMapping("register")
    public String getRegisterTemplate(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "/register";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/register/save")
    public String registration( @ModelAttribute("user") UserDto userDto,
                                BindingResult result,
                                Model model){

        System.out.println(userDto.getEmail());
        //checking if the user provided all the necessary credentials
        if(userDto.getEmail().isEmpty() || userDto.getPassword().isEmpty() || userDto.getName().isEmpty()){
            result.rejectValue("email", "101",
                    "default error message");
        }
        //checking if the user already exists in the database
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", "101",
                    "There is already an account registered with the same email");
        }
        //checking if the result of the action has errors
        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "redirect:/register?failure";
        }
        //creating the roles set for the user
        userService.saveUser(userDto);

        return "redirect:/register?success";
    }
}
