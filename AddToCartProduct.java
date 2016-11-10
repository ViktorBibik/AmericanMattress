package Americanmattress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Victor on 10.11.2016.
 */
public class AddToCartProduct extends MainPage {

    public AddToCartProduct(WebDriver driver){

        super(driver);
    }

    @FindBy(xpath = "//div[@id='product-options']//span[text()='Full']")
    public WebElement sizeFull;

    @FindBy(xpath = "//div[@id='addToCartDiv']//input[@id='qtydata']")
    public WebElement fieldQty;

    @FindBy(xpath = "//div[@id='addToCartDiv']//a[@id='addtoCartButton']")
    public WebElement addToCart;

}
