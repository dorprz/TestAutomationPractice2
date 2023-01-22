import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Git - system kontroli wersji
//obietkowość java (teoria): klasa, interfejs, czym się rózni klasa abstrakcyjna od intersejsu
// lokalizowanie lementów na stronie : XPath / css/ atrybut
public class UltimateQATest extends BaseTestSetup {
//wzorzec projetkowy: Page Object Pattern
    @Test
    public void testOne() {
        //jak mozemy lokazlizowac elementy: np przez id, classname, xpath, cssSelector
        WebElement buttonUsingId = driver.findElement(By.id("idExample"));
        Assertions.assertTrue(buttonUsingId.isDisplayed());
        buttonUsingId.click();
//log.info
        WebElement textButtonSuccess = driver.findElement(By.className("entry-title"));
        Assertions.assertEquals("Button success", textButtonSuccess.getText());
        //input[@id='et_pb_contact_name_0']   1 out of 1
        // input[@class='input et_contact_error']   1 out of 2
        // input[@class='input et_contact_error' and @id='et_pb_contact_name_0']
        // input[@placeholder='Name']
        // *[@placeholder='Name']
        // *[] - ogolna postac XPath
        //*[text()-"Email Me!"]
        //*[contains(text(), 'Email Me')]
        // *[@id=et_pb_contact_form_0']/div/p
    }
    @Test
    public void testTwo() throws InterruptedException {
        WebElement inputName = driver.findElement(By.xpath("//input[@id='et_pb_contact_name_0']"));
        inputName.sendKeys("Tester");
        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='et_pb_contact_email_0']"));
    inputEmail.sendKeys("tester@tester.pl");
    //Java: wyjątki w Java (Java exceptions))
        //sposoby oczekiwań w Selenium: Thread.sleep, implicit wait, explicit wait
        Thread.sleep(5000);
        WebElement buttonEmailMe = driver.findElement(By.xpath("//*[text()=\"Email Me!\"]"));
    Assertions.assertTrue(buttonEmailMe.isDisplayed());
    buttonEmailMe.click();
        Thread.sleep(5000);
    //typy oczekiwań
        WebElement textThanks = driver.findElement(By.xpath("//*[@id='et_pb_contact_form_0']//p"));
        Assertions.assertEquals("Thanks for contacting us", textThanks.getText());
        }

}
