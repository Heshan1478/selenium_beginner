package com.example.seleniumfirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TexBoxExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinktestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");

    }

    @Test
    public void textBoxTests(){

        //01)Type your name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
                name.sendKeys("Heshan Anjana");

        //02)Append country to this city
        WebElement appendText =driver.findElement(By.id("j_idt88:j_idt91"));
                appendText.sendKeys("India");

        //03)Verify if tex box is disabled
        WebElement findBox = driver.findElement(By.name("j_idt88:j_idt93"));
             Boolean enabled =  findBox.isEnabled();
            System.out.println("Is Box enabled : " + enabled);

        //04)Clear the type text
         WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
         clearText.click();  



    }
}
