package infra;

//import infra.general.Utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.Utils;

public class UiElement {

    private final By by;
    private final String desc;
    private  String title;
    protected WebElement element=null;
    private int index = 0;
    private static ExtentTest test;


    //אתחול הרוט מסוג UiElement הוא בעצם יכיל אלמנט שכבר אותר, וממנו יהיה אפשר להמשיך למצוא עוד אלמנטים אחריו
    //private UiElement root = null;

    //public static Reporter reporter = Reporter.reporter();

    //constructor

    //@Deprecated
    public UiElement(String desc, By by) {
        this.desc = desc;
        this.by = by;
        this.title = null;
        test=ExtendReport.getInstance().getTest();

    }

    public UiElement(String desc, By by, String title) {
        this.desc = desc;
        this.by = by;
        this.title = title;
    }

    //getters & setters

    public UiElement setIndex(int value) {
        this.index = value - 1;
        return this;
    }

    public int getIndex() {
        return index;
    }

    /*public UiElement root(UiElement root) {
        this.root = root;
        return this;
    }
*/
    public WebElement getElement() {
        return element;
    }


    //methods

    public void click() {
        //reporter.hasScreenshot().message("Click on the element [" + this.desc + "]", by.toString());
        //reporter.message("Click on the element [" + this.desc + "]", by.toString());
        test.log(Status.INFO,"Click on the element [" + this.desc + "]  [" + by + "]");
        findElement();
        element.click();
        //Utils.sleepMS(500);
//        reporter.takeScreenshot();
    }

    public void doubleClick() {
        findElement();
        test.log(Status.INFO,"DoubleClick on the element [" + this.desc + "]  [" + by + "]");
        Actions act = new Actions(Browser.getDriver());
        act.doubleClick(element);
        act.build().perform();
        Utils.waiting();
    }

    /* הפונקציה מקבלת משתנה דגל, המורה לה לבחור באפשרות של הcheckBox או להסיר את הבחירה ממנו
     */
    public void checkBox(Boolean bool) {
        if (bool == null) {
            return;
        }

        findElement();  //מציב בשרת את האלמנט שנמצא במיפוי

        if (bool) {  //אם הדגל אמת, בצע doChooseOption שזה בוחר באפשרות של הcheckBox , כמובן אם היא לא נבחרה כבר
            doChooseOption();

        } else {   //אם הדגל שקר, בצע הסרה של הבחירה מהcheckBox
            if (!element.isSelected())
                return;

            //Reporter.reporter().message("Unchecking the element [" + this.desc + "]", null);
            element.click();
            Utils.waiting();
        }
    }

    public void chooseRadio() {
        findElement();
        doChooseOption();
    }

    private void doChooseOption() {
        if (element.isSelected())
            return;

        //Reporter.reporter().message("Check on the element [" + this.desc + "]", null);
        element.click();
        Utils.waiting();
    }

    public String read() {
        String str = element.getText();

        if (str == null || str.isEmpty()) {
            str = element.getAttribute("value");
        }

        if (str == null || str.isEmpty()) {
            str = element.getAttribute("innerHTML");
        }

        return str;
    }


    public void input(String str) {
        if (str == null) {
            return;
        }

//        reporter.hasScreenshot().message("Input to element [" + this.desc + "] with value [" + str + "]", by.toString());
        findElement();
        element.clear();
        element.sendKeys(str);
        //Utils.sleep(1);
//        reporter.takeScreenshot();
    }

    public void inputWithEnter(String str) {
        if (str == null) {
            return;
        }

//        reporter.hasScreenshot().message("Input to element [" + this.desc + "] with value [" + str + "]", by.toString());
        findElement();
        element.clear();
        element.sendKeys(str);
        element.sendKeys(Keys.ENTER);
        test.log(Status.INFO,"Input to element [" + this.desc + "] with value [" + str + "]");
        //Utils.sleep(1);
//        reporter.takeScreenshot();
    }

    public boolean validateText(String str) {
        if (str == null) {
            return true;
        }

        if (!isExists()) {
            //reporter.error("The element [" + this.desc + "] is not exists", str + "\r\n" + by.toString());
            return false;
        }

        boolean result = this.element.getText().equals(str);
        //reporter.result("ValidateText: element Text [" + this.element.getText() + "] ,current Text [" + str + "]"
        //      , by.toString(), result);
        return result;
    }

    public boolean validateExists() {
        if (isExists()) {
            //reporter.message("The element [" + this.desc + "] is exists", by.toString());
            return true;
        }

        //reporter.error("The element [" + this.desc + "] is not exists", by.toString());
        ErrorsManage.setNumError();
        return false;
    }

    public boolean isExists() {
        findElement();
        return this.element != null;
    }

    public void isLinkTransitionTo()  {
        Utils.waiting();
        String actualTitle = Browser.getDriver().getTitle();
        System.out.println("actualTitle: [" + actualTitle  + "]");
        boolean equalsTitles = actualTitle.equalsIgnoreCase(title);
        if (equalsTitles) {
            System.out.println("The transition to the web [" + title + "] page was done successfully");
            test.log(Status.PASS, "The transition to the web [" + title + "] page was done successfully ");
        } else {
            System.out.println("The transition to the web [" + title + "] page was fail");
            test.log(Status.FAIL, "The transition to the web [" + title + "] page was fail");
            ErrorsManage.setNumError();
            Utils.addScreenshot();
        }
    }

    public void isLinkTransitionTo(String title)  {

        Utils.waiting();
        String actualTitle = Browser.getDriver().getTitle();
        System.out.println("actualTitle: [" + actualTitle  + "]");
        boolean equalsTitles = actualTitle.equalsIgnoreCase(title);
        if (equalsTitles) {
            System.out.println("The transition to the web [" + title + "] page was done successfully");
            test.log(Status.PASS, "The transition to the web [" + title + "] page was done successfully ");
        } else {
            System.out.println("The transition to the web [" + title + "] page was fail");
            test.log(Status.FAIL, "The transition to the web [" + title + "] page was fail");
            ErrorsManage.setNumError();
            Utils.addScreenshot();
        }
    }

    protected void findElement() {
        if(element==null) {
            test.log(Status.INFO,"Finding element: [" + desc + "] [" + by + "]");

            element = Browser.getDriver().findElement(by);
        }
    }

    public void select(String str) {
        findElement();
        //reporter.message("Select from drop-down [" + this.desc + "] the option: " + str, str + "\r\n" + by.toString());
        Select select = new Select(element);
        //select.selectByVisibleText(str);
        select.selectByValue(str);
    }

   /* public boolean validateChooseRadio() {
        if (!isExists()) {
            reporter.error("The element [" + this.desc + "] is not exists", by.toString());
            return false;
        }

        if (element.isSelected()) {
            reporter.message("The element [" + this.desc + "] is Selected", by.toString());
            return true;
        }
        reporter.error("The element [" + this.desc + "] is not Selected", by.toString());
        return false;
    }
*/
    /*
    private void runJS(String s) {
        ((JavascriptExecutor)Browser.driver()).executeScript("arguments[0]."+s, this.element);
    }

    public void clickJS() {
        runJS("click()");
    }

    public void setColor(String color) {
        runJS("style.color='" + color + "'");
    }

    public void dragAndDrop() {
        new Actions(Browser.driver()).moveToElement(element)
                .clickAndHold().moveByOffset(300, -30).release()
                .perform();
    }

    public void ctrlClick() {
        new Actions(Browser.driver()).keyDown(element, Keys.CONTROL).click().perform();
    }

    public void inputSeveralKey() {
        element.sendKeys(Keys.chord(Keys.CONTROL, "p"));
    }
*/

}




















