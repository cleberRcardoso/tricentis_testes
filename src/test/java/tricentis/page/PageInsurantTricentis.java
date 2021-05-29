package tricentis.page;

import org.openqa.selenium.support.PageFactory;
import tricentis.attributes.AttributesInsurantTricentis;
import tricentis.utils.GenerateName;

import static tricentis.utils.Utils.getPropertySettings;

public class PageInsurantTricentis extends AttributesInsurantTricentis {

    public PageInsurantTricentis() {
        PageFactory.initElements(getDriver() , this);
    }

    /**
     * Realiza preenchimento do formuçário dados do seguro
     */
    public void fillInsuratForm() {
        setText(fieldFirstName , GenerateName.getRandomName());
        setText(fieldLastName , GenerateName.getRandomName());
        setText(fieldBirthday,getPropertySettings("tricentis.datasafe.birthDay"));
        click(selectGender(getPropertySettings("tricentis.datasafe.gender")));
        setText(fieldStreetAddress , getPropertySettings("tricentis.datasafe.streetAddress"));
        select(selectCountry , getPropertySettings("tricentis.datasafe.country"));
        setText(fieldZipCode , getPropertySettings("tricentis.datasafe.zipCode"));
        setText(fieldCity , getPropertySettings("tricentis.datasafe.city"));
        select(selectOccupation , getPropertySettings("tricentis.datasafe.occupation"));
        click(selectHoobies(getPropertySettings("tricentis.datasafe.hobbies")));
        setText(fieldWebsite , getPropertySettings("tricentis.datasafe.website"));
    }

}
