package com.learning.recipebook.domain;

import lombok.Data;

import javax.persistence.*;
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
}
