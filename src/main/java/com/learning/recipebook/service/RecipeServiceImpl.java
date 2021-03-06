package com.learning.recipebook.service;

import com.learning.recipebook.command.IngredientCommand;
import com.learning.recipebook.command.RecipeCommand;
import com.learning.recipebook.converter.RecipeCommandToRecipe;
import com.learning.recipebook.converter.RecipeToRecipeCommand;
import com.learning.recipebook.domain.Recipe;
import com.learning.recipebook.exceptions.NotFoundException;
import com.learning.recipebook.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    @Transactional
    public RecipeCommand findCommandById(Long l) {
        return recipeToRecipeCommand.convert(findById(l));
    }

    @Override
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(recipeCommand);
        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        return recipeToRecipeCommand.convert(savedRecipe);

    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("In the service layer");
        Set<Recipe> recipeList = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeList::add);
        return recipeList;
    }

    @Override
    public Recipe findById(Long id){
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if(!recipeOptional.isPresent()){
            throw new NotFoundException("Recipe not found for recipe id : "+ id);
        }
        return recipeOptional.get();
    }

    @Override
    public IngredientCommand findByRecipeId(long anyLong) {
        return null;
    }
}
