package Americanmattress;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

/**
 * Created by Victor on 10.11.2016.
 */
public class MainClassAmericanmattress {
    public WebDriver driver;

    @FindBy(xpath = "//div[@class='cart-box']//input[@class='cart-quantity']")
    public WebElement cartQuantity;

    @BeforeClass
    public void setUp() throws Exception {

        System.setProperty("webdriver.gecko.driver","D:\\Selenium\\geckodriver.exe");
        //System.setProperty("webdriver.gecko.driver","D:\\Selenium\\geckodriver-v0.10.0-win64\\geckodriver.exe");

        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("reader.parse-on-load.enabled",false);
        driver = new FirefoxDriver(firefoxProfile);
    }

    @Test
    public void addValidUser() throws Exception {

        driver.get("https://www.americanmattress.com/");

        MainPage mainPage = new MainPage(driver);
        FurnitureElements furnitureElements = new FurnitureElements(driver);
        StoreFurniturePage storeFurniturePage = new StoreFurniturePage(driver);
        AddToCartProduct addToCartProduct = new AddToCartProduct(driver);

        mainPage.buttonClosePlagin.click();
        Thread.sleep(2000);
        mainPage.dropdownToggleFURNITURE.click();
        furnitureElements.linkMetalBad.click();
        //Thread.sleep(2000);
        ImplicitWait(driver);
        storeFurniturePage.linkFentonBedProduct.click();


        //mainPage.buttonClosePlagin.click();
        addToCartProduct.sizeFull.click();
        /*
        * ПОСЛЕ ВВОДА БУКВЕННОГО СИМВОЛА В ПОЛЕ "Qty" И НАЖАТИЯ НА КНОПКУ "ADD TO CART" ПРОИСХОДИТ ОДНОВРЕМЕННОЕ АВТОМАТИЧЕСКОЕ НАЖАТИЕ НА КНОПКУ ENTER В ПОЛЕ "Qty"
        * ЕСЛИ УБРАТЬ ОДНОВРЕМЕННОЕ АВТОМАТИЧЕСКОЕ НАЖАТИЕ НА КНОПКУ ENTER В ПОЛЕ "Qty" БАГ НЕ БУДЕТ ВОСПРОИЗВОДИТСЯ:)
         */
        addToCartProduct.fieldQty.sendKeys("s");
        addToCartProduct.fieldQty.sendKeys(Keys.RETURN);
        addToCartProduct.addToCart.click();

        File file= new File("browser.data");
        try{
            file.delete();
            file.createNewFile();
            FileWriter filewriter = new FileWriter(file);
            BufferedWriter bufwriter = new BufferedWriter(filewriter);

            for(Cookie ck : driver.manage().getCookies()){
                bufwriter.write(( ck.getName() + ";"
                        +ck.getValue() + ";"
                        +ck.getDomain() + ";"
                        +ck.getPath() + ";"
                        +ck.getExpiry() + ";"
                        +ck.getName() + ";"
                        +ck.isSecure()));
                System.out.println(ck);
                bufwriter.newLine();
            }
            bufwriter.flush();
            bufwriter.close();
            filewriter.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        Thread.sleep(2000);
        String body = driver.findElement(By.xpath("//div[@class='col-xs-30']//span[@data-bind='text: orderItemCount']")).getText();
        Assert.assertEquals(body, "1 item");
    }
    public static void ImplicitWait(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
}
