package tricentis.page;


import org.openqa.selenium.support.PageFactory;
import tricentis.attributes.AttributesProductTricentis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static tricentis.utils.Utils.getPropertySettings;

public class PageProductTricentis extends AttributesProductTricentis {

    public PageProductTricentis() {
        PageFactory.initElements(getDriver() , this);
    }

    /**
     * Preenche dados do formulário dados de produtos
     */
    public void fillProductForm() {
        startDate(getPropertySettings("tricentis.dataproduct.startDate"));
        select(selectInsuranceSum , getPropertySettings("tricentis.dataproduct.insuranceSum"));
        select(selectMeritRating , getPropertySettings("tricentis.dataproduct.meritRating"));
        select(selectDamageInsurance , getPropertySettings("tricentis.dataproduct.damageInsurance"));
        click(selectProducts(getPropertySettings("tricentis.dataproduct.products")));
        select(selectCourtesyCar, getPropertySettings("tricentis.dataproduct.courtesyCar"));
    }

    /**
     * Seleciona a data de fabricação através do calendario
     *
     * @param date
     */
    private void startDate(String date) {
        moveToElement(buttoncalendar);
        click(buttoncalendar);
        String[] Date = date.split("/");
        verifyDate(Integer.valueOf(Date[1]) , Integer.valueOf(Date[2]));
        click(selectDay(Date[0]));

    }

    /**
     * Verifica a data para caso necessario altera
     *
     * @param year
     * @param month
     */
    private void verifyDate(int month , int year) {
        int actualyear = Integer.valueOf(getText(actualYear));

        while (actualyear != year) {
            if (actualyear > year) {
                click(buttonPreviousMonth);
            } else {
                click(buttonNextMonth);
            }
            actualyear = Integer.valueOf(getText(actualYear));
        }

        int actualmonth = intMonth(getText(actualMonth));
        while (actualmonth != month) {
            if (actualmonth > month) {
                click(buttonPreviousMonth);
            } else {
                click(buttonNextMonth);
            }
            actualmonth = intMonth(getText(actualMonth));
        }
    }

    /**
     * Convert o mes para int
     * @param monthName
     * @return
     */
    private int intMonth(String monthName) {
        Date date = null;
        try {
            date = new SimpleDateFormat("MMMM" , Locale.US).parse(monthName);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.get(Calendar.MONTH);
        return cal.get(Calendar.MONTH) + 1;
    }


}
