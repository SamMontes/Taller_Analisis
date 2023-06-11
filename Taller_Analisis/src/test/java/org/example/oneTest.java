package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class oneTest {
    public WebDriver driver;

    /*public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.get("httpps://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void escribirEnLaBarraDeBusqueda() {
        WebElement barra;
        barra = driver.findElement(By.cssSelector("APjFqb"));
        barra.click();
        barra.sendKeys("uca");
    }

    public void cerrarPagina() {
        driver.quit();
    }*/


    public void setUpPage(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    public void login(){
        WebElement user_barra;
        user_barra = driver.findElement(By.id("user-name"));
        user_barra.sendKeys("standard_user");

        WebElement password_barra;
        password_barra = driver.findElement(By.id("password"));
        password_barra.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();
    }

    public void añadirAlCarrito(){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }

    public void irAlCarrito(){
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    public void eliminarArticulo(){
        driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
    }

    public void checkout(){
        driver.findElement(By.id("checkout")).click();
    }

    @Test
    public void verificarFuncionamientoPaginaWeb() {
        setUpPage();
        login();
        añadirAlCarrito();
        irAlCarrito();
        eliminarArticulo();
        checkout();
    }
}

