package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.Properties.GIT_HUB_LOGIN;
import static org.example.Properties.GIT_HUB_PASS;

public class AppTest {
    
    @Test
    public void openMainGooglePage(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Paula_Girdea\\IdeaProjects\\webdriver_practice\\src\\test\\resources\\webdriver\\chromedriver.exe");

        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://www.google.com");
        WebElement searchField = webDriver.findElement(By.name("q"));
        Assert.assertTrue(searchField.isDisplayed(), "Search field should be displayed");
    //    Assert.assertTrue(!searchField.isDisplayed(), "Search field should be displayed");


   //    webDriver.close();
        webDriver.quit();
    }
    @Test
    public void gitHubLoginTest() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Paula_Girdea\\IdeaProjects\\webdriver_practice\\src\\test\\resources\\webdriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://github.com/login");

        WebElement loginField = driver.findElement(By.id("login_field"));
        loginField.sendKeys(GIT_HUB_LOGIN);

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(GIT_HUB_PASS);

        WebElement signInButton = driver.findElement(By.name("commit"));
        signInButton.click();


       // driver.quit();
    }

}
