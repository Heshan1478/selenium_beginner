package com.example.seleniumfirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExample {

    WebDriver driver;

    @BeforeMethod
    public void dropDownTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/select.xhtml");
    }

    @Test
    public void leafgroundpageDropDowntest() throws InterruptedException {

        //1.1) Ways of select values in basic dropdown
        WebElement dropDown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Playwright");
        Thread.sleep(3000);

        //1.2) Get the number of dropdown options
        //generics
        List<WebElement> listofoptions = select.getOptions();
        int size = listofoptions.size();
        System.out.println("No of element in dropdown :" + size);

        for (WebElement element:listofoptions){
            System.out.println(element.getText());
        }


    }


    //1.3) Using sendkeys select dropdown value
}
