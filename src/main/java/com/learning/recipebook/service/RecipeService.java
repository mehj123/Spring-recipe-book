package com.learning.recipebook.service;

import com.learning.recipebook.command.RecipeCommand;
import com.learning.recipebook.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
    RecipeCommand findCommandById(Long l);
}
