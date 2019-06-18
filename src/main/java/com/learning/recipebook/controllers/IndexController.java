package com.learning.recipebook.controllers;

import com.learning.recipebook.domain.Category;
import com.learning.recipebook.domain.UnitOfMeasure;
import com.learning.recipebook.repositories.CategoryRepository;
import com.learning.recipebook.repositories.UnitOfMeasureRepository;
import com.learning.recipebook.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
public class IndexController {


    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model){

        log.debug("Loading index page");
        model.addAttribute("recipeList", recipeService.getRecipes());
        return "index";
    }
}
