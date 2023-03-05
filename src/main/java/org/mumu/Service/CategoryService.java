package org.mumu.Service;

import io.vertx.core.json.JsonObject;
import org.mumu.Models.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CategoryService {

    public List<Category> categoryList(){
        return Category.listAll();
    }


    @Transactional
    public Category categoryPost(JsonObject body){
        Category category = new Category();
        category.name_category = body.getString("name");
        category.persist();
        return category;
    }

    public Category categoryGetByName(String name_categroy){
        return Category.find("name_category = ?1", name_categroy).firstResult();
    }

}
