package org.mumu.Controller;

import io.vertx.core.json.JsonObject;
import org.mumu.Models.Category;
import org.mumu.Service.CategoryService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CatergoryController {

    @Inject
    CategoryService categoryService;

    @GET
    public List<Category> getCategory() {
        return categoryService.categoryList();
    }

    @POST
    public Category postCategory(JsonObject body){
        return categoryService.categoryPost(body);
    }
}
