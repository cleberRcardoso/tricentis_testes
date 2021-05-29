package tricentis.steps;

import io.cucumber.java.es.E;
import io.cucumber.java.pt.Quando;

import org.junit.Assert;
import tricentis.page.*;

public class StepsFillForTricentis {

    @E("preencho o formulario {string} e pressione next")
    public void fillForm(String form) {
        switch (form.toLowerCase()) {
            case "enter vehicle data":
                new PageVehicleTricentis().fillFormVehicleData();
                new PageHomeTricentis().nextForm("enterinsurantdata");
                break;
            case "enter insurant data":
                new PageInsurantTricentis().fillInsuratForm();
                new PageHomeTricentis().nextForm("enterproductdata");
                break;
            case "enter product data":
                new PageProductTricentis().fillProductForm();
                new PageHomeTricentis().nextForm("selectpriceoption");
                break;
            case "select price option":
                new PagePriceOptionTricentis().selectPlan();
                new PageHomeTricentis().nextForm("sendquote");
                break;
            default:
                Assert.fail("Formulario informado não existe.");
                break;
        }

    }


    @Quando("preencho o fomrulario Send Quote e pressione Send")
    public void fillSendQuoteForm() {
        new PageSendQuoteTricentis().fillQuoteForm();
        new PageSendQuoteTricentis().seendingEmail();
    }
}
