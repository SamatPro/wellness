package com.sera.wellness.controllers;


import com.sera.wellness.forms.AddPersonalProductForm;
import com.sera.wellness.forms.EatenProductForm;
import com.sera.wellness.models.EatenProduct;
import com.sera.wellness.models.Product;
import com.sera.wellness.models.User;
import com.sera.wellness.services.FoodService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@NoArgsConstructor
@Controller
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/mypersonalproducts")
    public String getAllPersonalProducts(ModelMap modelMap, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/signin";
        }
        User user = (User) authentication.getPrincipal();
        modelMap.addAttribute("personalProducts", foodService.getAllPersonalProducts(user));
        return "personalProducts";
    }

    @GetMapping("/allproducts")
    public String getCommonProducts(ModelMap modelMap) {
        modelMap.addAttribute("products", foodService.getAllCommonProducts());
        return "commonProducts";
    }

    @PostMapping("/addpersonalproduct")
    public String addPersonalProduct(
//                @RequestParam String name,
//                @RequestParam MultipartFile img,
//                @RequestParam Float protein,
//                @RequestParam Float fats,
//                @RequestParam Float carbohydrates,
//                @RequestParam Float calories,
//                @RequestParam Boolean type,
            @RequestBody AddPersonalProductForm form,
            ModelMap modelMap,
            Authentication authentication) {
        if (authentication == null) {
            return "redirect:/signin";
        }
        User user = (User) authentication.getPrincipal();
        foodService.addPersonalProduct(form, user);
        return "redirect:/mypersonalproducts";
    }

    @GetMapping("/eatentoday")
    public String getEatenProduct(ModelMap modelMap, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/signin";
        }
        User user = (User) authentication.getPrincipal();
        List<EatenProduct> eatenProductList = null;
        try {
            eatenProductList = foodService.getAllEatenProductsToday(user);
        } catch (IllegalArgumentException e) {
            return "redirect:/fuckingcheater";
        }
        modelMap.addAttribute("eatenProducts",eatenProductList);
        return "eatentoday";
    }

    @PostMapping("/addeatentoday")
    public String addEatenToday(
//            @RequestParam Long productId,
//            @RequestParam Short count,
            @RequestBody EatenProductForm form,
            ModelMap modelMap, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/signin";
        }
        User user = (User) authentication.getPrincipal();
        try {
            foodService.addEatenProduct(form, user);
        } catch (IllegalArgumentException e) {
            return "redirect:/fuckingcheater";
        }
        return "redirect:/eatentoday";
    }

    @PostMapping("/deleteeatentoday")
    public String deleteEatenToday(@RequestParam Long id,ModelMap modelMap, Authentication authentication) {
        foodService.deleteEatenToday(id);
        return "redirect:/eatentoday";
    }

}
