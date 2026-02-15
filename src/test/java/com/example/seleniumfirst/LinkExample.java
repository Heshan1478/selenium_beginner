package com.example.seleniumfirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinktestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");

    }

    @Test
    public void LinkTests(){
        //01) Take me to dashboard
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();

        //02)find my destination
         WebElement wheretoGo = driver.findElement(By.partialLinkText("Find the URL "));
         String path = wheretoGo.getAttribute("href");
         System.out.println("This link is going to : " + path);

        //03) Am I broken link?
         WebElement brokenlink = driver.findElement(By.linkText("Broken?"));
         brokenlink.click();

          String title = driver.getTitle();
          if(title.contains("404")){
              System.out.println("The link is broken");
          }else{
              System.out.println("The link is not broken");
          }
           driver.navigate().back();


          //04)Duplicate Link
        homeLink.click();



    }

}
