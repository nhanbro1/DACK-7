package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class Addproductocart {
    public static void addProduct(){
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            // Go to Web
            driver.get("https://www.pnj.com.vn/");
            Thread.sleep(2000);

            // Nhập sản phẩm cần tìm
            driver.findElement(By.id("search_input")).click();
            driver.findElement(By.id("search_input")).sendKeys("nhẫn vàng");
            Thread.sleep(2000);

            // Click button search
            By buttonSearch = By.xpath("//body/div[@id='tygh_container']/div[@id='tygh_main_container']/" +
                    "div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]");
            WebElement btnSearch = driver.findElement(buttonSearch);
            btnSearch.click();
            Thread.sleep(2000);

            // chọn sản phẩm muốn mua
            driver.findElement(By.xpath("//img[@id='det_img_1100054667']")).click();
            Thread.sleep(2000);

            // Chọn size sản phẩm
            driver.findElement(By.xpath("//label[@id='option_description_54667_25010_816001']")).click();
            Thread.sleep(2000);

            // Thêm vào giỏ hàng
            driver.findElement(By.xpath("//button[@id='button_cart_54667']")).click();
            Thread.sleep(2000);

            System.out.println("Sản phẩm đã được thêm vào giỏ hàng");

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();


    }
}
