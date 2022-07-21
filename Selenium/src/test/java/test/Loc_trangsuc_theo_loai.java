package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

@Test
public class Loc_trangsuc_theo_loai {
    public static void locTheoLoai(){
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            // Go to Web
            driver.get("https://www.pnj.com.vn/nhan/?itm_source=search&itm_medium=top_tim_kiem&itm_campaign=tu_khoa&itm_content=Nhan");
            Thread.sleep(2000);

            // lọc sản phẩm theo thương hiệu
                // chọn mục lọc thương hiệu
            driver.findElement(By.xpath("//div[@id='sw_elm_filter_10']")).click();
            Thread.sleep(2000);

            // chọn lọc những sản phẩm có thương hiệu pnj
            driver.findElement(By.xpath("//body/div[@id='tygh_container']/div[@id='tygh_main_container']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/label[1]")).click();
            Thread.sleep(8000);



        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
