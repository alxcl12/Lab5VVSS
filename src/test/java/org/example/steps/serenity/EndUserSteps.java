package org.example.steps.serenity;

import org.example.pages.ShopPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    ShopPage shopPage;

    @Step
    public void enters(String keyword) {
        shopPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        shopPage.lookup_terms();
    }

    @Step
    public void clicks_on_product() {
        shopPage.clicksOn();
    }

    @Step
    public void should_see_product(String definition) {
        assertThat(shopPage.getProduct(), hasItem(containsString(definition)));
    }

    @Step
    public void should_not_see_products() {
        shopPage.noProduct();
    }

    @Step
    public void is_the_home_page() {
        shopPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
}