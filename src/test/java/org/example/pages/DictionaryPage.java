package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("http://automationpractice.com/index.php")
public class DictionaryPage extends PageObject {

    @FindBy(name="search_query")
    private WebElementFacade searchTerms;

    @FindBy(name="submit_search")
    private WebElementFacade lookupButton;

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        lookupButton.click();
    }

    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.className("product_list grid row"));
        return definitionList.findElements(By.className("product-name")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
    }
}