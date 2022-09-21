package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }


    public void openLoginForm() {
        WebElement loginBtn = wd.findElement(By.xpath("//a[@class='navigation-link'][normalize-space()='Log in']"));
        loginBtn.click();
    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }

    public void submitLogin() {
        WebElement loginButton = wd.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }

    public boolean isLogged() {
        List<WebElement> list = wd.findElements(By.xpath("//button[text()='Sign Out']"));
        return list.size() > 0;
    }

    public void logout() {
        wd.findElement(By.xpath("//button[text()='Sign Out']")).click();
    }

    public boolean isLoggedIn() {
        WebElement loggedIn = wd.findElement(By.xpath("//h1[normalize-space()='Logged in']"));
        if (loggedIn.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
    public void loginSuccessfulOK(){
        wd.findElement(By.xpath("//button[normalize-space()='Ok']")).click();
    }
}
