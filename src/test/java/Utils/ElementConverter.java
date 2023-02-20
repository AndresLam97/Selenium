package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementConverter {

    public static By convertElementToByForPageObject(WebElement webElement)
    {
        if(!webElement.toString().contains("DefaultElementLocator")) {
            String[] elementInformation = webElement.toString().split("->")[1].split(":");
            String locator = elementInformation[0].trim();
            String elementData = elementInformation[1].substring(0, elementInformation[1].length() - 1);
            switch (locator) {
                case "id":
                    return By.id(elementData);
                case "xpath":
                    return By.xpath(elementData);
                case "css selector":
                    return By.cssSelector(elementData);
                case "tag name":
                    return By.tagName(elementData);
                case "name":
                    return By.name(elementData);
                case "link text":
                    return By.linkText(elementData);
                case "class name":
                    return By.className(elementData);
                default:
                    return null;
            }
        } else
        {
            String elementString = webElement.toString();
            String cuttedString = elementString.substring(42,elementString.length()-1);
            String locator = cuttedString.split(":")[0];
            String findData = cuttedString.split(":")[1].trim();
            switch(locator)
            {
                case "By.xpath": return By.xpath(findData);
                case "By.id": return By.id(findData);
                case "By.cssSelector": return By.cssSelector(findData);
                case "By.linkText": return By.linkText(findData);
                case "By.className": return By.className(findData);
                case "By.name": return By.name(findData);
                case "By.tagName": return By.tagName(findData);
                default: return null;
            }
        }
    }
}
