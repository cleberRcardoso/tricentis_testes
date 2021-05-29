package tricentis.steps;

import io.cucumber.java.pt.Dado;

import static tricentis.utils.Hooks.*;

public class StepsLoadTricentis {

    @Dado("que acessei o Tricentis no chorme")
    public void openWebsite() {
        openBrowser();
        navigate("url.tricentis");
    }
}
