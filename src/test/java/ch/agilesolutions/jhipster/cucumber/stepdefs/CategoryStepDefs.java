package ch.agilesolutions.jhipster.cucumber.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import ch.agilesolutions.jhipster.web.rest.CategoryResource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CategoryStepDefs extends StepDefs {

    @Autowired
    private CategoryResource categoryResource;

    private MockMvc restCategoryMockMvc;

    @Before
    public void setup() {
        this.restCategoryMockMvc = MockMvcBuilders.standaloneSetup(categoryResource).build();
    }

    @When("I search category {int}")
    public void i_search_category(int categoryId) throws Throwable {
        actions = restCategoryMockMvc.perform(get("/api/categories/" + categoryId)
                .accept(MediaType.APPLICATION_JSON));
    }

    @Then("the category is found")
    public void the_category_is_found() throws Throwable {
        actions
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Then("its description is {string}")
    public void his_last_name_is(String lastName) throws Throwable {
        actions.andExpect(jsonPath("$.description").value(lastName));
    }

}
