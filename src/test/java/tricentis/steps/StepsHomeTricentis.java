package tricentis.steps;

import io.cucumber.java.pt.Entao;
import tricentis.page.PageHomeTricentis;

public class StepsHomeTricentis {

    @Entao("valido que o email foi enviado com sucesso")
    public void validateEmail() {
       new PageHomeTricentis().checkEmail();
    }


}


