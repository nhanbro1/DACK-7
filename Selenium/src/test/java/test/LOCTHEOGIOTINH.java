package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test
public class LOCTHEOGIOTINH {
    public static void TEST1(){
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            // Go to Web
            driver.get("https://www.pnj.com.vn/nhan/?itm_source=search&itm_medium=top_tim_kiem&itm_campaign=tu_khoa&itm_content=Nhan");
            Thread.sleep(2000);

            // lọc sản phẩm theo giới tính
            // chọn mục lọc giới tính
            driver.findElement(By.xpath("//div[@id='sw_elm_filter_43']")).click();
            Thread.sleep(2000);

            // chọn lọc những sản phẩm có giới tính là nam
            driver.findElement(By.xpath("//body/div[@id='tygh_container']/div[@id='tygh_main_container']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[7]/div[2]/ul[1]/li[1]/ul[1]/li[2]/label[1]")).click();
            Thread.sleep(8000);



        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();

    }
}
