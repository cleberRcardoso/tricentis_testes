package tricentis.page;


import org.openqa.selenium.support.PageFactory;
import tricentis.attributes.AttributesPriceOptionTricentis;

import static tricentis.utils.Utils.getPropertySettings;

public class PagePriceOptionTricentis extends AttributesPriceOptionTricentis {

    public PagePriceOptionTricentis() {
        PageFactory.initElements(getDriver() , this);
    }

    /**
     *  Seleciona o plano
     */
    public void selectPlan() {
        click(planRadioButton(getPropertySettings("tricentis.datapriceoption.planType")));
    }

}
