package Americanmattress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Victor on 10.11.2016.
 */
public class StoreFurniturePage extends MainPage {

    public StoreFurniturePage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//div[@class='product-info']//a[@class='product-description' and @href='/catalog/fenton-bed-p1408942?option=2473405']")
    public WebElement linkFentonBedProduct;

    @FindBy(xpath = "//div[@id='display-nav-bar']//a[@href='http://americanmatt.constantretail.com/catalog/all/category=beds;category=headboards;category=futon-frames;category=recliners;/price-desc/1']")
    public  WebElement dropdownToggleFURNITURE;

    @FindBy(xpath ="//div[@id='display-nav-bar']//a[@href='https://www.americanmattress.com/catalog/adjustable/price-asc/1']")
    public  WebElement dropdownToggleAdjustableBeds;

    @FindBy(xpath ="//div[@class='col-sm-60 padding-none']//a[@class='dropdown-toggle'][@href='/catalog/all/category=mattress-sets;category=mattresses/price-asc/1']")
    public  WebElement dropdownToggleMattresses;
}
