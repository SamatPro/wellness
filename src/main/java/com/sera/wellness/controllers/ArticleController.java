package com.sera.wellness.controllers;

import com.sera.wellness.forms.ArticleAddForm;
import com.sera.wellness.forms.CommentForm;
import com.sera.wellness.models.Article;
import com.sera.wellness.models.User;
import com.sera.wellness.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/articles")
public class ArticleController {
    /* @Autowired
     private HttpSession session;*/
    @Autowired
    private ArticleService service;


    @RequestMapping(method = RequestMethod.GET)
    public String getAll(ModelMap modelMap, Authentication authentication) {
        if (authentication != null) {
            modelMap.addAttribute("user", authentication.getPrincipal());
        }
        modelMap.addAttribute("articles", service.getAll());
//        for (Article article : service.getAll()) {
//            System.out.println(article.getMainImg().getFileName());
//        }
        return "articles";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getArticle(@PathVariable Long id, ModelMap modelMap, Authentication authentication) {
        User user = null;
        if (authentication != null) {
            user = (User) authentication.getPrincipal();
        }
        try {
            Article article = service.getArticle(id);
            modelMap.addAttribute("avgGrade",service.getAvgGrade(id));
            if (user != null) {
                modelMap.addAttribute("user", user);
                modelMap.addAttribute("usersGrade", service.getUsersGrade(user.getId(), id));//оценка если есть
                modelMap.addAttribute("isFavorite", user.getFavoriteArticles().contains(article)); //избранная?
            }
            //System.out.println(article.getMainImg());
            modelMap.addAttribute("article", article);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return "article";
    }

    @RequestMapping(path = "add", method = RequestMethod.GET)
    public String getArticleForm(ModelMap modelMap, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/signin";
        }
        return "addArticle";
    }


    @RequestMapping(path = "add", method = RequestMethod.POST)
    public String addArticle(@RequestParam("title") String title,
                             @RequestParam("text") String text,
                             @RequestParam("file") MultipartFile file,
                             ModelMap modelMap,
                             Authentication authentication) {
        ArticleAddForm form = ArticleAddForm.builder()
                .title(title)
                .text(text)
                .file(file)
                .build();
        if (authentication == null) {
            return "redirect:/signin";
        }
        User user = (User) authentication.getPrincipal();
        service.addArticle(form, user);
        return "redirect:/articles";
    }

    @GetMapping("/favorite")
    public String getFavoriteArticles(ModelMap modelMap, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/signin";
        }
        User user = (User) authentication.getPrincipal();
        List<Article> articleList = user.getFavoriteArticles();
        articleList = service.convertImgToNormal(articleList);
        modelMap.addAttribute("articles", user.getFavoriteArticles());
        return "favoriteArticles";
    }

    @PostMapping("/addfavorite")
    public String addFavorite(@RequestParam("article_id") Long articleId,
                              ModelMap modelMap, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/signin";
        }
        User user = (User) authentication.getPrincipal();
        modelMap.addAttribute("addedOrDeleted", service.addFavoriteArticle(articleId, user));// true = added, else = deleted
        return "redirect:/articles/favorite";
    }

    @PostMapping("/addComment")
    public String addComment(@ModelAttribute CommentForm commentForm, ModelMap modelMap, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/signin";
        }
        User user = (User) authentication.getPrincipal();
        service.addComment(commentForm, user.getId());
        return "redirect:/articles/" + commentForm.getArticleId();
    }

    @PostMapping("/{id}/evaluate")
    public String evaluate(@RequestParam("grade") Short grade, @PathVariable("id") Long articleId, Authentication authentication, ModelMap modelMap) {
        if (authentication == null) {
            return "redirect:/signin";
        }
        User user = (User) authentication.getPrincipal();
        try {
            service.evaluate(user.getId(), articleId, grade);
        } catch (IllegalArgumentException e) {
            return "redirect:/fuckingcheater";
        }
        return "redirect:/articles/" + articleId;
    }


}
