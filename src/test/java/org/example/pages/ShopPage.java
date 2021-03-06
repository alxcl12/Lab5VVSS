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
public class ShopPage extends PageObject {

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

    public List<String> getProduct() {
        WebElementFacade definitionList = find(By.className("right-block"));
        return definitionList.findElements(By.className("product-name")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
    }

    public void noProduct() {
        WebElementFacade definitionList = find(By.className("heading-counter"));

        System.out.println(definitionList.getText());
        assert (definitionList.getText().contains("0 results"));
    }

    public void clicksOn() {
        WebElementFacade definitionList = find(By.className("right-block"));
        definitionList.findElement(By.className("product-name")).click();
    }

    public void cartOperations() {
        WebElementFacade definitionList = find(By.name("Submit"));
        definitionList.click();

        WebElementFacade div = find(By.className("button-container"));
        div.findElement(By.tagName("a")).click();

        WebElementFacade tst = find(By.className("icon-minus"));
        tst.click();
    }

    public void go_checkout(){
        WebElementFacade cart = find(By.className("cart_block block exclusive"));
        cart.click();
    }
}