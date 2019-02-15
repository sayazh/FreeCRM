package Tests;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class freeCRMtest extends TestBase {

    @Test
    public void signUp(){
        driver.findElement(By.linkText("Sign Up")).click();
        select = new Select(driver.findElement(By.id("payment_plan_id")));
        select.selectByIndex(1);

        //Web Elements
        WebElement firstName = driver.findElement(By.name("first_name"));
        WebElement lastName =driver.findElement(By.name("surname"));
        WebElement email =driver.findElement(By.name("email"));
        WebElement emailconfirm =driver.findElement(By.name("email_confirm"));
        WebElement userName =driver.findElement(By.name("username"));
        WebElement passWd = driver.findElement(By.name("password"));
        WebElement confirmPassWd =driver.findElement(By.name("passwordconfirm"));
        WebElement agreeTerms = driver.findElement(By.name("agreeTerms"));
        WebElement submitButton =driver.findElement(By.id("submitButton"));

        //Fake information
        String fakeFirstName =fake.name().firstName();
        String fakeLastName =fake.name().lastName();
        String fakeEmail =fake.name().username()+"@gmail.com";
        String fakeUserName =fakeFirstName+"12356";
        String fakePassword ="password123";

       firstName.sendKeys(fakeFirstName);
       lastName.sendKeys(fakeLastName);
       email.sendKeys(fakeEmail);
       emailconfirm.sendKeys(fakeEmail);
       userName.sendKeys(fakeUserName);
       passWd.sendKeys(fakePassword);
       confirmPassWd.sendKeys(fakePassword);
       agreeTerms.click();
       submitButton.click();

       WebElement company = driver.findElement(By.id("company_name"));
       WebElement phoneNumber = driver.findElement(By.id("phone"));
       WebElement checkbox2 = driver.findElement(By.name("copy_address"));
               company.sendKeys("cybertek");
       phoneNumber.sendKeys(fake.phoneNumber().phoneNumber());
       WebElement continueButton =driver.findElement(By.name("btnSubmit"));
       checkbox2.click();
       continueButton.click();

       WebElement registration =driver.findElement(By.name("finish"));
       registration.click();
       String expectedConfirm =driver.findElement(By.xpath("//div[@class='text_orange']")).getText();
       String actualConfirmMessage ="Your account is now registered.";
        System.out.println("Expected confirmation message: "+expectedConfirm+" | Actual confirmation message: "+actualConfirmMessage);
        Assert.assertEquals(expectedConfirm, actualConfirmMessage);

    }

}
