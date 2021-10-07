package TestNG.Selenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;

public class WebTableUtility {
	public  static List<ArrayList<String>> get_Dynamic_TwoDimension_TablElemnts( List<WebElement> rowItems,  List<WebElement> columnItems)
    {


        //List<WebElement> rowItems = driver.findElements(By.xpath("//div[@class='su-table su-table-alternate']//tr"));
        //List<WebElement> coloumnItems = driver.findElements(By.xpath("//div[@class='su-table su-table-alternate']//tr//td"));
        String[] columnList = new String[columnItems.size() / rowItems.size()];
        List<ArrayList<String>> gridData = new ArrayList<ArrayList<String>>();
        int x = 0;
        for (int i = 0; i < rowItems.size(); i++) {
            for (int j = 1; j < columnList.length; j++) {
                columnList[j] = columnItems.get(i).getText();
                // gridData.addAll(coloumnList[j]);
            }
            x++;
            gridData.add(new ArrayList<String>(Arrays.asList(columnList)));

        }
        return gridData;
    }
}
