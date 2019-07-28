package com.learning.recipebook.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private String source;
    private String url;
    private Integer servings;
    @Lob
    private String directions;
    @Enumerated(value=EnumType.STRING)
    private Difficulty difficulty;
    @Lob
    private Byte[] image;

    @ManyToMany
    @JoinTable(name="recipe_category",
        joinColumns = @JoinColumn(name="recipe_id"),
            inverseJoinColumns =@JoinColumn(name="category_id"))
    private Set<Category> categories = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredient = new HashSet<>();

    @OneToOne(cascade= CascadeType.ALL)
    private Notes notes;

    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    public Recipe addIngredient(Ingredient ingredient){
        ingredient.setRecipe(this);
        this.ingredient.add(ingredient);
        return this;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", prepTime=" + prepTime +
                ", cookTime=" + cookTime +
                ", source='" + source + '\'' +
                ", url='" + url + '\'' +
                ", servings=" + servings +
                ", directions='" + directions + '\'' +
                ", difficulty=" + difficulty +
                ", image=" + Arrays.toString(image) +
                ", categories=" + categories +
                ", ingredient=" + ingredient +
                ", notes=" + notes +
                '}';
    }
}
