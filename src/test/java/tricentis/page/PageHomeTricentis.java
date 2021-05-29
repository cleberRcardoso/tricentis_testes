package tricentis.page;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import tricentis.attributes.AttributesHomeTricentis;


public class PageHomeTricentis extends AttributesHomeTricentis {

    public PageHomeTricentis() {
        PageFactory.initElements(getDriver() , this);
    }

    /**
     * Acessa o próximo formulario
     */
    public void nextForm(String nextPage){
        click(buttonNext(nextPage));
    }

    /**
     * Valida email enviado com sucesso
     */
    public void checkEmail() {
        implicitWait(resultSendingEmail,10);
        Assert.assertEquals("Sending e-mail success!",getText(resultSendingEmail));
    }
}
