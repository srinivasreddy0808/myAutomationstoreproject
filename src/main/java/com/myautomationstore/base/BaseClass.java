package com.myautomationstore.base;

import com.myautomationstore.actiondriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BaseClass {
    public  static Properties prop;
    public  static WebDriver driver;
    @BeforeAll
    public static  void  loadConfig( ) {
        try {
            prop = new Properties();
            System.out.println("super constructor invoked");
            FileInputStream ip= new FileInputStream( System.getProperty("user.dir") + File.separator
                    + "Configuration" + File.separator
                    + "Config.properties");
            prop.load(ip);
            System.out.println("driver: "+driver);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  static  void  launchApp( ) {
        String browserName = prop.getProperty("browser");
        if (browserName.contains("Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

// Disable password manager completely
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.default_content_setting_values.notifications", 2); // Optional: block notifications

            options.setExperimentalOption("prefs", prefs);

// Additional flags
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-extensions"); // Remove extensions that might trigger password manager
            options.addArguments("--disable-notifications");
            options.addArguments("--no-default-browser-check");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);

        }else if(browserName.contains("FireFox"))  {
            WebDriverManager.firefoxdriver().setup();

            driver = new FirefoxDriver();

        }else if(browserName.contains("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();

        Action.implicitWait(driver,10);
        Action.pageLoadTimeOut(driver,30);
        driver.get(prop.getProperty("url"));


    }

}
