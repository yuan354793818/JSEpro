package noclassify;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class chorme {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--proxy-server=http://127.0.0.1:1080");
        //不打开浏览器
        //options.addArguments("--headless");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://rule34hentai.net/_images/660b172027c17f5117b7496c10537590/117073%20-%20Candy_Chiu%20Crocface%20Gravity_Falls.jpg");
        //driver.get("https://www.baidu.com");
        //driver.navigate().refresh();
        Thread.sleep(7000);
        WebElement img = driver.findElement(By.cssSelector("img"));
        Actions action = new Actions(driver);
        action.contextClick(img).build().perform();

        //action.sendKeys("v").build().perform();
        action.sendKeys(Keys.CONTROL,"s").build().perform();
        //driver.quit();
    }
}
