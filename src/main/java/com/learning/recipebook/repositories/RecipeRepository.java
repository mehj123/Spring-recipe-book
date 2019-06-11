package com.learning.recipebook.repositories;

import com.learning.recipebook.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
