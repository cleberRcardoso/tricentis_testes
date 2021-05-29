package tricentis.attributes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import tricentis.utils.GeralPage;

public class AttributesHomeTricentis extends GeralPage {

    @FindBy(xpath = "//h2")
    protected WebElement resultSendingEmail;

    protected WebElement buttonNext(String nextPage) {
        return findElementByXpath("//button[contains(@id,'next" + nextPage + "')]");
    }

}
