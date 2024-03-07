package testCases;

import infra.Browser;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class LoginTestWithParameterize {
    private String email;
    private String password;
    static LoginPage loginPage;

    @BeforeClass
    public static void beforeClass() throws Exception {
        Browser.getDriver().navigate().to("https://account.next.co.il/en/Login");
        loginPage = new LoginPage();
    }

    public LoginTestWithParameterize(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"efratnti@gmail.com", "1234abcd"});
        data.add(new Object[]{"cohen@gmail.com", "5678aaaa"});
        data.add(new Object[]{"12@gmail.com", "45678bbbb"});
        return data;
    }

    @Test
    public void loginTest() {
        loginPage.fillPage(email, password);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        Browser.getDriver().quit();
    }
}

