package com.learning.recipebook.repositories;

import com.learning.recipebook.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
