package tricentis.page;


import org.openqa.selenium.support.PageFactory;
import tricentis.attributes.AttributesSendQuoteTricentis;
import tricentis.utils.GenerateName;

import static tricentis.utils.Utils.getPropertySettings;

public class PageSendQuoteTricentis extends AttributesSendQuoteTricentis {

    public PageSendQuoteTricentis() {
        PageFactory.initElements(getDriver() , this);
    }

    /**
     *  Preenche o formulario cotacao
     */
    public void fillQuoteForm() {
        setText(fieldEmail,getPropertySettings("tricentis.datasendquote.email"));
        setText(fieldPhone,getPropertySettings("tricentis.datasendquote.phone"));
        setText(fieldUsername, "Auto" + GenerateName.getRandomName());
        setText(fieldPassword,getPropertySettings("tricentis.datasendquote.password"));
        setText(fieldConfirmPassword,getPropertySettings("tricentis.datasendquote.confirmPassword"));
        setText(textAreaComments,getPropertySettings("tricentis.datasendquote.comments"));
    }

    /**
     * Realiza envio do email
     */
    public void seendingEmail(){
        click(buttonSend);
    }

}
