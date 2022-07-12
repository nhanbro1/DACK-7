package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

@Test
public class Dathang {
    public static void testDatHang(){
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            // Go to Web
            driver.get("https://www.pnj.com.vn/");
            Thread.sleep(2000);
            // Nhập sản phẩm cần tìm
            driver.findElement(By.id("search_input")).sendKeys("nhẫn vàng");
            Thread.sleep(2000);
            // Click button search
            By buttonSearch = By.xpath("//body/div[@id='tygh_container']/div[@id='tygh_main_container']/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]");
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

            // Giỏ hàng lúc này có 1 sp
            // Đến giỏ hàng
            driver.findElement(By.xpath("//span[contains(text(),'Giỏ hàng')]")).click();

            //  Tăng số lượng sản phẩm lên 2
            driver.findElement(By.xpath("//a[contains(text(),'+')]")).click();
            Thread.sleep(2000);

            //  Điền thông tin khách hàng
            // Chọn giới tính là nam
            driver.findElement(By.xpath("//body/div[@id='tygh_container']/div[@id='tygh_ma" +
                    "in_container']/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[1]")).click();
            Thread.sleep(2000);

            // Nhập tên người dùng
            driver.findElement(By.xpath("//input[@id='elm_firstname']")).sendKeys("Nguễn " +
                    "bá nhân");
            Thread.sleep(2000);

            // Nhập số điện thoại
            driver.findElement(By.xpath("//input[@id='elm_cm-phone']")).sendKeys("0123456789");
            Thread.sleep(2000);

            // Nhập địa chỉ email
            driver.findElement(By.xpath("//input[@id='elm_cm-email']")).sendKeys("gmail@gmail" +
                    ".com");
            Thread.sleep(2000);

            //Nhập ngày sinh
            driver.findElement(By.xpath("//input[@id='birthday']")).sendKeys("30-03-2002");
            Thread.sleep(2000);

            // Nhập địa chỉ giao hàng

            // Chọn tỉnh là HỒ CHÍ MINH
            Select select = new Select(driver.findElement(By.xpath("//body/div[@id='tygh_container']/div[@id='tygh_main_container']/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/div[3]/div[1]/div[1]/div[1]/span[1]/span[1]")));
            select.selectByVisibleText("HỒ CHÍ MINH");


            Thread.sleep(2000);

            // Chọn quận là tân phú
            driver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys("QUẬN TÂN PHÚ");
            Thread.sleep(2000);


            // Chọn phường là phú thạnh
            driver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys("PHƯỜNG PHÚ THẠNH");
            Thread.sleep(2000);

            // Nhập địa chỉ chi tiết
            driver.findElement(By.xpath("//input[@id='elm_mp__address']")).sendKeys("Đây là" +
                    " địa chỉ chi tiết");
            Thread.sleep(2000);

            // Click nút đặc hàng
            driver.findElement(By.xpath("//button[@id='btn_quick_checkout']")).click();
            Thread.sleep(2000);

            System.out.println("Đaẹt hàng thành công");




        }
        catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();

    }
}
