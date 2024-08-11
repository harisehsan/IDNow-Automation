package base;

import org.openqa.selenium.*;

import java.util.Random;


public class BaseMobile extends BaseUtil {

    StringBuilder stringBuilder = new StringBuilder();

    protected String verifyAllNameElementsAreDisplayed(String[] names)
    {
        for (String name: names)
        {
            if (!iosDriver.findElement(By.name(name)).isDisplayed())
                stringBuilder.append(name+"\n");
        }
        return stringBuilder.toString();
    }

    protected WebElement selectRandomNameElement(String[] names)
    {
        Random random = new Random();
        return iosDriver.findElement(By.name(names[random.nextInt(names.length)]));
    }
}
