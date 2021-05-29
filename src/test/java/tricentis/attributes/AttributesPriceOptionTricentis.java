package tricentis.attributes;

import org.openqa.selenium.WebElement;
import tricentis.utils.GeralPage;


public class AttributesPriceOptionTricentis extends GeralPage {


    protected WebElement planRadioButton(String plan){
        return findElementByXpath("//input[contains(@id,'select"+plan+"')]/..//span");
    }


}
