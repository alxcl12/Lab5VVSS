package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import org.example.steps.serenity.EndUserSteps;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {

    @Managed(uniqueSession = true, driver="chrome")
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;


    @Test
    public void search_blouse(){
        anna.is_the_home_page();
        anna.looks_for("blouse");
        anna.should_see_product("Blouse");
    }

    @Test
    public void search_mazare(){
        anna.is_the_home_page();
        anna.looks_for("mazare");
        anna.should_not_see_products();
    }

    @Test
    public void sequence_test(){
        anna.is_the_home_page();
        anna.looks_for("blouse");
        anna.clicks_on_product();
        anna.cart_operation();
    }

} 