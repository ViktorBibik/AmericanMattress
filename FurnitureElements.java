package Americanmattress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Victor on 10.11.2016.
 */
public class FurnitureElements extends MainPage {

    public FurnitureElements(WebDriver driver) {

        super(driver);
    }


    @FindBy(xpath = "//div[@id='display-nav-bar']//a[@href='/catalog/fenton-fontane-dynasty-baroque/category=beds/price-asc/1']")
    public WebElement linkMetalBad;

    @FindBy(xpath = "//div[@id='display-nav-bar']//a[@href='/catalog/fenton-fontane-dynasty/category=headboards/price-asc/1']")
    public  WebElement linkMetalHeadboard;

}
