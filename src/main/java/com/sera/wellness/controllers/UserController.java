package com.sera.wellness.controllers;

import com.sera.wellness.forms.UserProfileForm;
import com.sera.wellness.models.*;
import com.sera.wellness.services.UserService;
import com.sera.wellness.forms.UserRegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET, value = "/signup")
    public String getForm(ModelMap model) {
        return "signup";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public String trySave(
            @ModelAttribute UserRegistrationForm form,
            ModelMap model) {
        try {
            service.signUp(form);

            return "redirect:/signin";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "signup";
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/signin")
    public String getLoginForm(HttpServletRequest request, ModelMap model) {
        if (request.getParameter("error") != null) {
            model.addAttribute("error", "Неправильный логин или пароль");
        }
        return "signin";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/profile")
    public String updateUser(ModelMap modelMap, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/signin";
        }

        User user = (User) authentication.getPrincipal();
        user = service.getThis(user.getId()).get();

        modelMap.addAttribute("getUser", user);
        return "profile";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/profile")
    public String updateUser(
            @ModelAttribute UserProfileForm profileForm,
            Authentication authentication) {
        if (authentication == null) {
            return "redirect:/signin";
        }
        User user = (User) authentication.getPrincipal();
        String fileName = user.getId() + profileForm.getPhoto().hashCode() + profileForm.getPhoto().getOriginalFilename();
        String fileDir = "uploads/" + fileName;
        if (!profileForm.getPhoto().isEmpty()) {
            service.savePhoto(fileDir, profileForm.getPhoto());
        } else {
            fileName = user.getPhotoSrc();
        }

        service.updateUser(user, profileForm, fileName);
        user = service.getThis(user.getId()).get();
        authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "redirect:/articles";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addToFriend")
    @ResponseStatus(HttpStatus.OK)
    public void addToFriend(Authentication authentication, @RequestParam("id") Long friendId) {
        User user = (User) authentication.getPrincipal();
        service.addToFriend(user, friendId);
    }



    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public String searchPage(ModelMap modelMap, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/signin";
        }
        User user = (User) authentication.getPrincipal();
        modelMap.addAttribute("user", user);


        return "search";
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsersAsJson(@RequestParam(value = "name") String name) {
        return service.findAllByName(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public String getAllMyFriends(Authentication authentication, ModelMap modelMap) {
        if (authentication == null) {
            return "redirect:/signin";
        }
        User user = (User) authentication.getPrincipal();

        modelMap.addAttribute("user", user);

        return "subscriptions";
    }

    @RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
    public String getFriend(@PathVariable Long id, ModelMap modelMap, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/signin";
        }
        User user = (User) authentication.getPrincipal();
        modelMap.addAttribute("user", user);

        modelMap.addAttribute("friend", service.getThis(id).get());

        return "user";
    }

    @RequestMapping(path = "dialogs/{id}",method = RequestMethod.GET)
    public String messages(@PathVariable Long id, ModelMap modelMap,Authentication authentication) {
        if (authentication==null) {
            return "redirect:/signin";
        }
        User user = (User) authentication.getPrincipal();
        modelMap.addAttribute("getUser", user);

        try{
            List<Message> messages = user.getMessages();
                    service.getMessagesByDialogId(id);
            for (Message message: messages) {
                for (User userToCheck: message.getDialog().getUsers())
                if (userToCheck.getId().equals(user.getId())){
                    modelMap.addAttribute("messages", messages);
                }
            }
        }
        catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return "messages";
    }

    @RequestMapping(path = "dialogs",method = RequestMethod.GET)
    public String messages(ModelMap modelMap,Authentication authentication) {
        if (authentication==null) {
            return "redirect:/signin";
        }
        User user = (User) authentication.getPrincipal();

        try{
            List<Dialog> dialogs = user.getDialogs();
            modelMap.addAttribute("dialogs", dialogs);
        }
        catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return "dialogs";
    }

    @RequestMapping(path = "dialogs/{id}",method = RequestMethod.POST)
    public String sendMessage(@PathVariable Long id, ModelMap modelMap, Authentication authentication, @RequestParam(value = "message") String messageText) throws InterruptedException {
        if (authentication==null) {
            return "redirect:/signin";
        }
        User user = (User) authentication.getPrincipal();


        modelMap.addAttribute("getUser", user);
        Message newMessage = Message.builder()
                .dialog(service.getDialog(id).get())
                .text(messageText)
                .user(user)
                .build();
        user.getMessages().add(newMessage);
        service.updateUser(user);

        try{
            List<Message> messages = service.getMessagesByDialogId(id);
            for (Message message: messages) {
                for (User userToCheck: message.getDialog().getUsers())
                    if (userToCheck.getId().equals(user.getId())){
                        modelMap.addAttribute("messages", messages);
                    }
            }
        }
        catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

        return "redirect:/dialogs/"+id;
    }



}
