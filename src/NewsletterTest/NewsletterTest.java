package NewsletterTest;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewsletterTest extends BaseDriver {
    @Test(priority = 1)
    public void test1(){
        login();

        WebElement newsButton = driver.findElement(By.xpath("//div[@class='list-group']//a[text()='Newsletter']"));
        newsButton.click();

        WebElement yesButton = driver.findElement(By.cssSelector("input[value='1']"));
        yesButton.click();

        WebElement conButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        conButton.click();

        WebElement successMessage = driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']"));
        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertTrue(successMessage.getText().contains("successfully updated"));
    }

    @Test(priority = 2)
    public void test2(){
        WebElement newsButton = driver.findElement(By.xpath("//div[@class='list-group']//a[text()='Newsletter']"));
        newsButton.click();

        WebElement radioYesCheck = driver.findElement(By.cssSelector("input[value='1']"));
        WebElement radioNoCheck = driver.findElement(By.cssSelector("input[value='0']"));

        if (radioYesCheck.isSelected()){
            radioNoCheck.click();
        }

        WebElement conButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        conButton.click();

        MyMethods.successMessageValidation();
    }

}
