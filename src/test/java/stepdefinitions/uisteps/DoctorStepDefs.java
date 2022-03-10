package stepdefinitions.uisteps;

import io.cucumber.java.en.And;
import pages.SignInPage;
import utilities.Driver;

public class DoctorStepDefs {

    SignInPage signInPage = new SignInPage();

    @And("user provides  doctor username")
    public void doctorProvidesUsername() {
        String doctorUsername = "doctor79";
        Driver.waitAndSendText(signInPage.username, doctorUsername);
    }


    @And("user provides doctor password")
    public void doctorProvidesPassword() {
        String doctorPassword = "doctor";
        Driver.waitAndSendText(signInPage.password, doctorPassword);
    }
    // new branch


    // deneme  Murat Irmak
    //Ummu
//unal



    // ozen
    //cetin


}
