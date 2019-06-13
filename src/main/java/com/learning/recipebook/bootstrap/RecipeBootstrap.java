package com.learning.recipebook.bootstrap;

import com.learning.recipebook.domain.*;
import com.learning.recipebook.repositories.CategoryRepository;
import com.learning.recipebook.repositories.RecipeRepository;
import com.learning.recipebook.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes(){

        List<Recipe> recipeList = new ArrayList<>(2);

        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
        if(!eachUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        if(!tableSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        if(!teaSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");
        if(!dashUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");
        if(!pintUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");
        if(!cupUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure teaSpoonUom = teaSpoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = pintUomOptional.get();
        UnitOfMeasure cupUom = cupUomOptional.get();

        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category not found");
        }
        Optional<Category> italianCategoryOptional = categoryRepository.findByDescription("Italian");
        if(!italianCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category not found");
        }
        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
        if(!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category not found");
        }
        Optional<Category> fastFoodCategoryOptional = categoryRepository.findByDescription("Fast Food");
        if(!fastFoodCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category not found");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category italianCategory = italianCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();
        Category fastFoodCategory = fastFoodCategoryOptional.get();


        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(30);
        guacRecipe.setDifficulty(Difficulty.HARD);
        guacRecipe.setDirections("1 Cut avocado, remove flesh:</b> Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See <a href=\"https://www.simplyrecipes.com/recipes/how_to_cut_and_peel_an_avocado/\">How to Cut and Peel an Avocado</a>.) Place in a bowl.</p>\n" +
                "<p><img width=\"600\" height=\"400\" src=\"https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-1-800-600x400.jpg\" class=\"attachment-sr-venti size-sr-venti lazyload\" alt=\"\" srcset=\"data:image/gif;base64,R0lGODlhAQABAAAAACH5BAEKAAEALAAAAAABAAEAAAICTAEAOw==\" sizes=\"(max-width: 600px) 100vw, 600px\" data-srcset=\"https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-1-800.jpg 800w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-1-800-300x200.jpg 300w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-1-800-768x512.jpg 768w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-1-800-600x400.jpg 600w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-1-800-440x293.jpg 440w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-1-800-200x133.jpg 200w\" data-sizes=\"auto\" data-src=\"https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-1-800-600x400.jpg\" /></p>\n" +
                "<p><b>2 Mash with a fork:</b> Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)</p>\n" +
                "<p><img width=\"600\" height=\"400\" src=\"https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-2-800-600x400.jpg\" class=\"attachment-sr-venti size-sr-venti lazyload\" alt=\"\" srcset=\"data:image/gif;base64,R0lGODlhAQABAAAAACH5BAEKAAEALAAAAAABAAEAAAICTAEAOw==\" sizes=\"(max-width: 600px) 100vw, 600px\" data-srcset=\"https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-2-800.jpg 800w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-2-800-300x200.jpg 300w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-2-800-768x512.jpg 768w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-2-800-600x400.jpg 600w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-2-800-440x293.jpg 440w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-2-800-200x133.jpg 200w\" data-sizes=\"auto\" data-src=\"https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-2-800-600x400.jpg\" /></p>\n" +
                "<p><strong>3 Add salt, lime juice, and the rest:</strong> Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.</p>\n" +
                "<p>Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.</p>\n" +
                "<p>Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.</p>\n" +
                "<p><b>4 Cover with plastic and chill to store:</b> Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.</p>\n" +
                "<p>Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.</p>");


        Notes guacNotes = new Notes();
        guacNotes.setRecipe(guacRecipe);
        guacNotes.setRecipeNotes("<p>For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.</p>\n" +
                "<p>Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our <a href=\"https://www.simplyrecipes.com/recipes/strawberry_guacamole/\">Strawberry Guacamole</a>).</p>\n" +
                "<p>The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.</p>\n" +
                "<p>To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.</p>\n" +
                "<p>For a deviled egg version with guacamole, try our <a href=\"https://www.simplyrecipes.com/recipes/guacamole_deviled_eggs/\">Guacamole Deviled Eggs</a>!</p>");

        guacRecipe.setNotes(guacNotes);

        guacRecipe.getIngredient().add(new Ingredient("ripe avocados",new BigDecimal(2),eachUom, guacRecipe));
        guacRecipe.getIngredient().add(new Ingredient("Kosher salt",new BigDecimal(.5),teaSpoonUom, guacRecipe));
        guacRecipe.getIngredient().add(new Ingredient("fresh lime juice or lemon juice",new BigDecimal(1),tableSpoonUom, guacRecipe));
        guacRecipe.getIngredient().add(new Ingredient("minced red onion or thinly sliced green onion",new BigDecimal(2),tableSpoonUom, guacRecipe));
        guacRecipe.getIngredient().add(new Ingredient("serrano chiles, stems and seeds removed, minced",new BigDecimal(2),eachUom, guacRecipe));
        guacRecipe.getIngredient().add(new Ingredient("cilantro (leaves and tender stems), finely chopped\n",new BigDecimal(2),teaSpoonUom, guacRecipe));

        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);

        recipeList.add(guacRecipe);


        Recipe tacoRecipe = new Recipe();
        tacoRecipe.setDescription("Perfect Taco Recipe");
        tacoRecipe.setPrepTime(20);
        tacoRecipe.setCookTime(50);
        tacoRecipe.setDifficulty(Difficulty.EASY);
        tacoRecipe.setDirections("<p><strong>1 Prepare a gas or charcoal grill for medium-high, direct heat.</strong></p>\n" +
                "<p><strong>2 Make the marinade and coat the chicken:</strong> In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.</p>\n" +
                "<p>Set aside to marinate while the grill heats and you prepare the rest of the toppings.</p>\n" +
                "<p><img width=\"600\" height=\"400\" src=\"https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1-600x400.jpg\" class=\"attachment-sr-venti size-sr-venti lazyload\" alt=\"Spicy Grilled Chicken Tacos\" srcset=\"data:image/gif;base64,R0lGODlhAQABAAAAACH5BAEKAAEALAAAAAABAAEAAAICTAEAOw==\" sizes=\"(max-width: 600px) 100vw, 600px\" data-srcset=\"https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1.jpg 1200w, https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1-300x200.jpg 300w, https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1-768x512.jpg 768w, https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1-1024x683.jpg 1024w, https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1-600x400.jpg 600w, https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1-440x293.jpg 440w, https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1-200x133.jpg 200w\" data-sizes=\"auto\" data-src=\"https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1-600x400.jpg\" /></p>\n" +
                "<p><strong>3 Grill the chicken: </strong>Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.</p>\n" +
                "<p><strong>4</strong> <strong>Warm the tortillas</strong>: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.</p>\n" +
                "<p>Wrap warmed tortillas in a tea towel to keep them warm until serving.</p>\n" +
                "<p><strong>5 Assemble the tacos:</strong> Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.</p>");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipe(tacoRecipe);
        tacoNotes.setRecipeNotes("p class=\"note\">This post may contain links to Amazon or other partners; your purchases via these links can benefit Simply Recipes.\n" +
                        "                       <a href=\"https://www.simplyrecipes.com/about#affiliate\">Read more about our affiliate linking policy</a>.\n" +
                        "                   </p>");

        tacoRecipe.setNotes(tacoNotes);

        tacoRecipe.getIngredient().add(new Ingredient("ripe avocados",new BigDecimal(2),eachUom,tacoRecipe));
        tacoRecipe.getIngredient().add(new Ingredient("Kosher salt",new BigDecimal(.5),teaSpoonUom,tacoRecipe));
        tacoRecipe.getIngredient().add(new Ingredient("fresh lime juice or lemon juice",new BigDecimal(1),tableSpoonUom,tacoRecipe));
        tacoRecipe.getIngredient().add(new Ingredient("minced red onion or thinly sliced green onion",new BigDecimal(2),tableSpoonUom,tacoRecipe));
        tacoRecipe.getIngredient().add(new Ingredient("serrano chiles, stems and seeds removed, minced",new BigDecimal(2),eachUom,tacoRecipe));
        tacoRecipe.getIngredient().add(new Ingredient("cilantro (leaves and tender stems), finely chopped\n",new BigDecimal(2),teaSpoonUom,tacoRecipe));

        tacoRecipe.getCategories().add(americanCategory);
        tacoRecipe.getCategories().add(mexicanCategory);

        recipeList.add(tacoRecipe);
        return recipeList;


    }
}
