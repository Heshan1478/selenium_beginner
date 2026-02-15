package com.example.seleniumfirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;

public class LinkExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinktestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");

    }

    @Test
    public void LinkTests() throws InterruptedException {
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
         Thread.sleep(3000);

        String title = driver.getTitle();
          if(title.contains("404")){
              System.out.println("The link is broken");
          }else{
              System.out.println("The link is not broken");
          }
           driver.navigate().back();


           //04)Duplicate Link
        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();

          //05)count page links
        List<WebElement> countfullpagelinks = driver.findElements(By.tagName("a"));
        int pageLinkcount = countfullpagelinks.size();
        System.out.println("count of full page link:" + pageLinkcount);

          //06) Count layout links
         WebElement layoutelement = driver.findElement(By.className("layout-main-content"));
         List<WebElement> countlayoutLinks =  layoutelement.findElements(By.tagName("a"));
        System.out.println("count of layout links:" + countlayoutLinks.size());
    }

}
