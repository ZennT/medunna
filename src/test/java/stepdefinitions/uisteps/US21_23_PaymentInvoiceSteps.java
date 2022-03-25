package stepdefinitions.uisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.SignInPage;
import pages.StaffPage;
import utilities.Driver;


import java.util.*;

public class US21_23_PaymentInvoiceSteps {
    SignInPage signinpage = new SignInPage();
    StaffPage staffPage = new StaffPage();


    @Given("user sign in with staff credential")
    public void userSignInWithStaffCredential() {
        Driver.waitAndSendText(signinpage.username, "staff079");
        Driver.waitAndSendText(signinpage.password, "staff");
        Driver.waitAndClick(signinpage.loginButton);

    }

    @And("user clicks my pages dropdown")
    public void userClicksMyPagesDropdown() {
        Driver.waitAndClick(staffPage.myPagesDropdownButton);
    }

    @And("user clicks search patient button")
    public void userClicksSearchPatientButton() {
        Driver.wait(3);
        Driver.waitAndClick(staffPage.searchPatientButton);

    }

    @Then("user search patient with snn id {string} in the search box")
    public void userSearchPatientWithSnnIdInTheSearchBox(String ssn) {
        Driver.wait(5);
        Driver.waitAndSendText(staffPage.searchSSNButton, ssn);
        Driver.wait(5);
    }

    @Then("user clicks show appointment")
    public void userClicksShowAppointment() {

        Driver.waitAndClick(staffPage.showAppointments);
        Driver.wait(3);
    }

    @Then("user verifies patient's status")
    public void userVerifiesPatientSStatus() {
        Driver.wait(5);
        Assert.assertTrue(staffPage.statusCompleted.isDisplayed());
    }


    @Then("user clicks payment_invoice process")
    public void userClicksPaymentInvoiceProcess() {
        Driver.waitAndClick(staffPage.paymentInvoice);
    }


    @And("user clicks create invoice button")
    public void userClicksCreateInvoiceButton() {
        Driver.waitAndClick(staffPage.createInvoice);
    }

    @And("user clicks save button")
    public void userClicksSaveButton() {
        Driver.waitAndClick(staffPage.createBillSaveButton);
    }

    @And("user verifies the success message")
    public void userVerifiesTheSuccessMessage() {
        Driver.wait(3);
        Assert.assertTrue(staffPage.paymentSuccessToastContainer.isDisplayed());
    }


    @And("user see the following fields in the invoice page")
    public void userSeeTheFollowingFieldsInTheInvoicePage() {

        List<WebElement> allLinks = Driver.getDriver().findElements(By.xpath("//table"));
        Iterator<WebElement> itr = allLinks.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next().getText());
        }
        List<WebElement> checkList = new ArrayList<>();
        for (int i = 0; i < allLinks.size(); i++) {
            checkList.add(allLinks.get(i));//10 records
        }
        Assert.assertTrue(allLinks.containsAll(checkList));


    }

    @And("user clicks show invoice button")
    public void userClicksShowInvoiceButton() {
        Driver.waitAndClick(staffPage.showInvoice);
    }

    @And("user verify invoice page")
    public void userVerifyInvoicePage() {
        Assert.assertTrue(staffPage.invoiceText.isDisplayed());
    }


    @And("user gets no patients found message")
    public void userGetsNoPatientsFoundMessage() {
        Driver.wait(1);
        Assert.assertTrue(staffPage.noPatientsFoundMessage.isDisplayed());

    }

    @And("user signout")
    public void userSignout() {
        //Driver.wait(3);
        Driver.waitAndClick(staffPage.staffDropdown);
        Driver.waitAndClick(staffPage.signOutStaff, 4);
        Driver.wait(5);


    }


    @And("user verifies patient's {string} unapproved not able to create an invoice")
    public void userVerifiesPatientSUnapprovedNotAbleToCreateAnInvoice(String status) {

        String unapproved = staffPage.statusUnapproved.getText().toUpperCase();
        Assert.assertEquals(unapproved, status);
        if (status == unapproved) {
            Assert.assertFalse(staffPage.paymentInvoice.isDisplayed());

        }
    }

    @And("user verifies patient's {string} not able to create an invoice")
    public void userVerifiesPatientSNotAbleToCreateAnInvoice(String status) {
        String cancelled = staffPage.statusCancelled.getText().toUpperCase(Locale.ROOT);
        Assert.assertEquals(cancelled, status);
        if (status == cancelled) {
            Assert.assertFalse(staffPage.paymentInvoice.isDisplayed());

//
        }
    }

    @And("user verifies patient's {string} to able to create an invoice")
    public void userVerifiesPatientSToAbleToCreateAnInvoice(String status) {
        String completed = staffPage.statusCompleted.getText().toUpperCase(Locale.ROOT);
        Assert.assertEquals(completed, status);
        if (staffPage.statusCompleted.isDisplayed()) {
            Assert.assertTrue(staffPage.paymentInvoice.isDisplayed());
        }
    }


    @And("user verifies patient's {string} pending to not able to create an invoice")
    public void userVerifiesPatientSPendingToNotAbleToCreateAnInvoice(String status) {
        String pending = staffPage.statusPending.getText();
        Assert.assertEquals(pending, status);
        if (status == pending) {
            Assert.assertFalse(staffPage.paymentInvoice.isDisplayed());
        }
    }


    @And("user verifies patient's {string}  to create an invoice")
    public void userVerifiesPatientSToCreateAnInvoice(String status) {


        for (int i = 0; i < staffPage.statusList.size(); i++) {
            try {
                if (status.equalsIgnoreCase(String.valueOf(staffPage.statusList.get(i).getText()))) {
                    Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div/div/div/div/div/table/tbody/tr[" + (i + 1) + "]/td/div/a[3]")).isDisplayed());
                    System.out.println("Assertion is successful for " + status);
                    System.out.println("=========================");


                } else {
                    List<WebElement> test = Driver.getDriver().findElements(By.xpath("//div/div/div/div/div/table/tbody/tr[" + (i + 1) + "]/td/div/a[3]"));
                    if (test.size() == 0) {
                        System.out.println("WebElement is not visible.");
                        System.out.println("Assertion is successful for " + staffPage.statusList.get(i).getText());

                    }

                }
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("element not available");
            }

        }
    }

    @Then("user selects patient's status")
    public void userSelectsPatientS() {
        Driver.waitAndClick(staffPage.editStatusDropdown);
        Driver.wait(2);
        Driver.selectByValue(staffPage.editStatusDropdown, "PENDING");
        Driver.wait(2);
        // Driver.selectByValue(staffPage.editStatusDropdown, "COMPLETED");
        Driver.wait(2);
        Driver.selectByValue(staffPage.editStatusDropdown, "CANCELLED");
        Driver.wait(2);
        Driver.selectByValue(staffPage.editStatusDropdown, "UNAPPROVED");
        Driver.wait(2);

    }

    @And("user clicks view result button")
    public void userClicksViewResultButton() {
        Driver.waitAndClick(staffPage.viewResultsButton);
    }

    @And("user clicks show test button")
    public void userClicksShowTestButton() {
        Driver.waitAndClick(staffPage.showTestsButton);

    }

    @And("user verify test results")
    public void userVerifyTestResults() {
        Assert.assertTrue(staffPage.testResultText.isDisplayed());
    }

    @And("user verifies the success message changes")
    public void userVerifiesTheSuccessMessageChanges() {
        Driver.wait(3);
        Assert.assertTrue(staffPage.patientSuccessToastContainer.isDisplayed());
    }

    @Then("user selects patient's {string}")
    public void userSelectsPatientS(String status) {
        Driver.waitAndClick(staffPage.editStatusDropdown);
        Driver.selectByValue(staffPage.editStatusDropdown, status);


    }

    @And("user leaves blank Anamnesis, Treatment or Diagnosis as required fields")
    public void userLeavesBlankAnamnesisTreatmentOrDiagnosisAsRequiredFields() {
        Driver.wait(2);
        staffPage.anamnesisText.clear();
        Driver.waitAndSendText(staffPage.anamnesisText, "");
        staffPage.treatmentText.clear();
        Driver.waitAndSendText(staffPage.treatmentText, "");
        staffPage.diagnosisText.clear();
        Driver.waitAndSendText(staffPage.diagnosisText, "");

    }

    @Then("user clicks patient edit button")
    public void userClicksPatientEditButton() {
        Driver.waitAndClick(staffPage.editButton);
    }


    @And("user selects doctor for patient")
    public void userSelectsDoctorForPatient() {
        Driver.waitAndClick(staffPage.physicianDropdown);
        Driver.selectByValue(staffPage.physicianDropdown, "10512");

    }
}