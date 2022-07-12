package test;

import org.testng.annotations.Test;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


@Test
public class TIMKIEMSP {
    public static void testtimkiem(){
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
            By buttonSearch = By.xpath("//body/div[@id='tygh_container']/div[@id='tygh_main_container']/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]");
            WebElement btnSearch = driver.findElement(buttonSearch);
            btnSearch.click();
            Thread.sleep(2000);

            // Hiển thị kiểm thử thành công
            System.out.println("kiểm tra tìm kiếm thành công");

        }catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
