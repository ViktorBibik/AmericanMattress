package Americanmattress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Victor on 10.11.2016.
 */
public class MainPage {
    public MainPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

        @FindBy(xpath = "//div[@id='myModal-subscription']//button[@class='close']")
        public WebElement buttonClosePlagin;

        @FindBy(xpath = "//div[@id='display-nav-bar']//a[@href='http://americanmatt.constantretail.com/catalog/all/category=beds;category=headboards;category=futon-frames;category=recliners;/price-desc/1']")
        public  WebElement dropdownToggleFURNITURE;

        @FindBy(xpath ="//div[@id='display-nav-bar']//a[@href='https://www.americanmattress.com/catalog/adjustable/price-asc/1']")
        public  WebElement dropdownToggleAdjustableBeds;

        @FindBy(xpath ="//div[@class='col-sm-60 padding-none']//a[@class='dropdown-toggle'][@href='/catalog/all/category=mattress-sets;category=mattresses/price-asc/1']")
        public  WebElement dropdownToggleMattresses;
}
