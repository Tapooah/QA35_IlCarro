import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("pablo.thebestqa@gmail.com", "TheBestTester_123");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLoggedIn());
        app.getHelperUser().loginSuccessfulOK();
    }
}
