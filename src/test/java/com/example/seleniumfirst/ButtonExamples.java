package com.example.seleniumfirst;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExamples {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver = new ChromeDriver();
        Dimension newsize = new Dimension(800,600 );
        driver.manage().window().setSize(newsize);
        driver.get("https://www.leafground.com/button.xhtml");

    }

    @Test
    public void buttonTest(){

        //1)click and confirm title
         WebElement Click = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']"));
         Click.click();
         String expectedTitle = "Dashboard";
         String actualTitle = driver.getTitle();
         if (expectedTitle.equals(actualTitle)){
             System.out.println(("Actual title same as expected"));
         }else {
             System.out.println("Actual title not same as expected");
         }

        //Assert.assertEquals(actualTitle,expectedTitle,"title miss match");

        //2)Find the position of the submit button
        driver.navigate().back();
        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xypoint = getPosition.getLocation();
         int x = xypoint.getX();
         int y = xypoint.getY();
        System.out.println("X position is : " + x + " Y position is : " + y);

        //3) Find the save button color
         WebElement buttoncolor = driver.findElement(By.id("j_idt88:j_idt96"));
         String color = buttoncolor.getCssValue("background-color");
         System.out.println("Button colour is : " + color);

        //4) Find the height and width of this button
        WebElement Size = driver.findElement(By.id("j_idt88:j_idt98"));
        int height = Size.getSize().getHeight();
        int width = Size.getSize().getWidth();
        System.out.println("Height : " + height + " " + "width : " + width);

    }

}
