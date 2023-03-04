package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import javax.sound.sampled.Line;

public abstract class BasePage {

    protected WebDriver driver;
    String name;

    public BasePage(WebDriver driver){
        this.driver=driver;
    PageFactory.initElements(driver, this);
    }

    public static void main(String[] args) {

    }
    }


