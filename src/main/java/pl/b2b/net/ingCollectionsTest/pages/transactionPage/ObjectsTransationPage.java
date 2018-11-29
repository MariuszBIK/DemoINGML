package pl.b2b.net.ingCollectionsTest.pages.transactionPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ObjectsTransationPage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    public ObjectsTransationPage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = DataTransactionPage.ASSERT_TRANSACTION_PAGE)
    private WebElement transactionPageAssert;

    public WebElement getTransactionPageAssert() {
        wait.until(ExpectedConditions.visibilityOf(transactionPageAssert));
        return transactionPageAssert;
    }

    @FindAll(@FindBy (xpath = DataTransactionPage.KONTA_UZYTKOWNIKA))
    private List<WebElement> kontaUzytkownika;

    public void wybierzKontoUzytkownika (String nazwaKonta)
    {
        for (WebElement kontoUzytkownika: kontaUzytkownika)
        {
            if (kontoUzytkownika.getAttribute ("innerHTML").equals(nazwaKonta)){
                kontoUzytkownika.click();
                break;
            }
        }
    }

}
