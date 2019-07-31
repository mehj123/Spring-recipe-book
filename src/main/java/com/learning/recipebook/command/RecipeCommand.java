package com.learning.recipebook.command;

import com.learning.recipebook.domain.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {
    private Long id;

    @NotBlank
    @Size(min=2, max=255)
    private String description;

    @Min(1)
    @Max(999)
    @NotNull
    private Integer prepTime;

    @Min(1)
    @Max(999)
    @NotNull
    private Integer cookTime;

    @Min(1)
    @Max(100)
    @NotNull
    private Integer servings;

    private String source;

    @URL
    @NotBlank
    private String url;

    @NotBlank
    private String directions;

    private Set<IngredientCommand> ingredient = new HashSet<>();
    private Difficulty difficulty;
    private NotesCommand notes;
    private Set<CategoryCommand> categories = new HashSet<>();
    private Byte[] image;
}
