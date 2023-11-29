package pages;


import infra.Browser;
import infra.UiElement;
import org.openqa.selenium.By;
import utils.Utils;

//The class defines locators && methods for search page
public class SearchPage {
    //WebDriver driver;


    //Creating an object for field the search
    private final UiElement productSearchInput = new UiElement("productSearchInput", By.cssSelector("#header-big-screen-search-box"));

    //private final By searchLocator = By.id("header-big-screen-search-box");


    //Locator for first choose in search (dress img)
    //Creating an object for first choose in search
    //private final By dress1Locator =By.xpath("//body/main[@id='next-plp-entrypoint']/div[@id='platform_modernisation_plp']/div[@id='plp']/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]");
    private final UiElement dress1Img = new UiElement("dress1Img", By.cssSelector("div[class='swiper-slide swiper-slide-active'] [data-testid='product_summary_image_d58846']"));


    public void SearchAndProductSelection(String item){
        productSearchInput.inputWithEnter(item);

        Utils.waiting();
        String title= Browser.getDriver().getTitle();
        System.out.println(title);
        dress1Img.doubleClick();
    }

    //constructor
    /*public SearchPage(WebDriver driver) {
        this.driver = driver;
    }*/

    //Method to type string for search
    /*public void typeSearch(String dataSearch) throws IOException, ParserConfigurationException, SAXException {
        Browser.getDriver().findElement(searchLocator).sendKeys(dataSearch);
        Browser.getDriver().findElement(searchLocator).sendKeys(Keys.ENTER);

    }*/

    //method for click on first choose btn (first dress img)
/*    public void doubleClickOndress1Img() throws IOException, ParserConfigurationException, SAXException {
        Actions act = new Actions(Browser.getDriver());
        act.doubleClick(Browser.getDriver().findElement(dress1Locator));
        act.build().perform();
    }*/
}
