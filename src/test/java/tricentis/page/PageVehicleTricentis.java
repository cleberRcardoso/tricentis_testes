package tricentis.page;


import org.openqa.selenium.support.PageFactory;
import tricentis.attributes.AttributesVehicleTricentis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static tricentis.utils.Utils.getPropertySettings;

public class PageVehicleTricentis extends AttributesVehicleTricentis {

    public PageVehicleTricentis() {
        PageFactory.initElements(getDriver() , this);
    }

    /**
     * Preenche formuçário dados veicular
     */
    public void fillFormVehicleData() {
        select(selectMake , getPropertySettings("tricentis.datacar.make"));
        select(selectModel , getPropertySettings("tricentis.datacar.model"));
        setText(fieldCylinderCapacity , getPropertySettings("tricentis.datacar.cylinderCapacity"));
        setText(fieldEnginePerformance , getPropertySettings("tricentis.datacar.engine"));
        selecteDate(getPropertySettings("tricentis.datacar.date"));
        select(selectNumberOfSeats , getPropertySettings("tricentis.datacar.seats"));
        click(selectDriven(getPropertySettings("tricentis.datacar.rightHandDriven")));
        select(selectNumberofSeatsMotorcycle , getPropertySettings("tricentis.datacar.numberofSeatsMotorcycle"));
        select(selectFuel , getPropertySettings("tricentis.datacar.fuelType"));
        setText(fielPayLoad , getPropertySettings("tricentis.datacar.payLoad"));
        setText(fieldTotalWeight , getPropertySettings("tricentis.datacar.totalWeight"));
        setText(fieldListprice , getPropertySettings("tricentis.datacar.price"));
        setText(fieldLicensePlateNumber , getPropertySettings("tricentis.datacar.plate"));
        setText(fieldAnnualMileage , getPropertySettings("tricentis.datacar.annualMileage"));
    }

    /**
     * Seleciona a data de fabricação através do calendario
     * @param date
     */
    private void selecteDate(String date) {
        moveToElement(buttoncalendar);
        click(buttoncalendar);
        String[] Date = date.split("/");
        verifyDate(Integer.valueOf(Date[1]) , Integer.valueOf(Date[2]));
        click(selectDay(Date[0]));

    }

    /**
     * Verifica data para caso seja necessario altera
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
