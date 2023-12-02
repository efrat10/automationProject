package pages;


import infra.Browser;
import infra.UiElement;
import org.openqa.selenium.By;
import testCases.Constants;
import utils.Utils;

//The class defines UiElement && methods for search page
public class SearchPage {

    //Creating an object for field the search
    private final UiElement productSearchInput = new UiElement("productSearchInput", By.cssSelector("#header-big-screen-search-box"));

    //Creating an object for first choose in search (dress img)
    private final UiElement dress1Img = new UiElement("dress1Img", By.cssSelector("div[class='swiper-slide swiper-slide-active'] [data-testid='product_summary_image_d58846']"));

    //The function searches and selects a product
    public void SearchAndProductSelection(String item){
        productSearchInput.inputWithEnter(item);
        Utils.waiting();
        String titleExpect=item + " from | Next Israel";
        productSearchInput.isLinkTransitionTo(titleExpect);
        dress1Img.doubleClick();
        Utils.waiting();
        System.out.println(Browser.getDriver().getTitle());
        dress1Img.isLinkTransitionTo(Constants.TITLE_PRODUCT_PAGE);
    }

}
