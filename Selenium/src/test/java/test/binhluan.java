package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class binhluan {
    public static void addBinhluat() {
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

            // chọn phần bình luận
            driver.findElement(By.xpath("//h3[@id='discussion']")).click();

            // chọn thêm mới một bình luận
            driver.findElement(By.xpath("//a[contains(text(),'Viết bình luận')]")).click();

            // điền from bình luận

            // họ tên
            driver.findElement(By.xpath("//input[@id='dsc_name_54667']")).sendKeys("nguyenbanhan");

            // chọn số sao
            driver.findElement(By.xpath("//label[contains(text(),'Tuyệt vời!')]")).click();

            // Thêm nội dung bình luận
            driver.findElement(By.xpath("//label[contains(text(),'Tuyệt vời!')]")).sendKeys("thêm bình luận mới");

            // click gửi bình luận
            driver.findElement(By.xpath("//button[contains(text(),'Gửi')]")).click();


        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
