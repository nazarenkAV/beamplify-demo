package com.solvd.beamplify;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;

public class BeamplifyDemoTests implements IAbstractTest {

    /* Apidocs
    *  Steps -> 1. Go to  beamplify.com
                2. Tap on Get a Quote
                3. Scroll the page down, tap on Next button (right blue arrow)
    *  Expected result ->   Why are you looking for life insurance? page is open
    */
    @Test
    public void verifyHomePageWorkflow(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        GetQuotePage getQuote = homePage.clickGetQuoteButton();
        getQuote.switchToQuoteWindow("Amplify");
        getQuote.clickNextButton();
        String text = getQuote.getlifeInsuranceMessage();
        assertEquals(text,
                "Why are you looking for life insurance?",
                "FATAL!, Not same");
    }


    /* Apidocs
    *  Steps -> 1. Mark checkboxes (for example, 'Pay off my debts' and 'Leave an inheritance')
                2. Tap Next button
    *  Expected result ->   What's your date of birth? is open
    */
    @Test(dependsOnMethods = {"verifyHomePageWorkflow"})
    public void verifyCheckboxesCanBeSelected(){
        GetQuotePage getQuote = new GetQuotePage(getDriver());
        getQuote.selectCheckBoxes();
        getQuote.clickNextButton();
        String text = getQuote.getDateOfBirthMessage();
        assertEquals(text,
                "What’s your date of birth",
                "FATAL!, Not same");
    }


    /* Apidocs
    *  Steps -> 1. Enter valid DoB (for example, 01/01/2001)
                2. Tap Next button
    *  Expected result ->   What's your gender? page is open
    */
    @Test(dependsOnMethods = {"verifyCheckboxesCanBeSelected"})
    public void verifyIfCanEnterDateOfBirth(){
        GetQuotePage getQuote = new GetQuotePage(getDriver());
        getQuote.setDateOfBirth("07031997");
        getQuote.clickNextButton();
        String text = getQuote.getGenderMessage();
        assertEquals(text,
                "What’s your gender?",
                "FATAL!, Not same");
    }


    /* Apidocs
    *  Steps -> 1. Choose Gender (for example, Female)
                2. Tap Next button
    *  Expected result ->   What's your zip code?  page is open
    */
    @Test(dependsOnMethods = {"verifyIfCanEnterDateOfBirth"})
    public void verifyIfCanChooseGender(){
        GetQuotePage getQuote = new GetQuotePage(getDriver());
        getQuote.clickFemaleButton();
        getQuote.clickNextButton();
        String text = getQuote.getZipCodeMessage();
        assertEquals(text,
                "What’s your zip code?",
                "FATAL!, Not same");
    }


   /* Apidocs
   *  Steps -> 1. Enter correct zip code (5 numbers)
               2. Tap Next button
   *  Expected result ->    What is your annual household income?  page is open
   */
    @Test(dependsOnMethods = {"verifyIfCanChooseGender"})
    public void verifyCanEnterZipCode(){
        GetQuotePage getQuote = new GetQuotePage(getDriver());
        getQuote.setZipCode();                           // See description method
        getQuote.clickNextButton();
        String text = getQuote.getHouseholdMessage();
        assertEquals(text,
                "What is your annual household income?",
                "FATAL!, Not same");
    }


   /* Apidocs
   *  Steps ->  1. Choose household income from drop-down list (for example, $50.000 - 99.999)
                2. "What is your occupation" field: enter the occupation (for example, Software developer)
                3. Tap Next button
   *  Expected result ->    What's a comfortable amount for you to contribute towards a policy on a monthly basis?  page is open
   */
    @Test(dependsOnMethods = {"verifyCanEnterZipCode"})
    public void verifyCanSelectAnualHousehold(){
        GetQuotePage getQuote = new GetQuotePage(getDriver());
        getQuote.selectAnnualHouseholdDropdown();
        getQuote.setOccupationField("Software developer");
        getQuote.clickNextButton();
        String text = getQuote.getComfortableAmountMessage();
        assertEquals(text,
                "What's a comfortable amount for you to contribute towards a policy on a monthly basis?",
                "FATAL!, Not same");
    }


   /* Apidocs
   *  Steps ->  1. Choose a comfortable amount by moving the slider (for example, 250$)
                2. Tap Next button
   *  Expected result ->    Height and Weight page is open
   */
    @Test(dependsOnMethods = {"verifyCanSelectAnualHousehold"})
    public void verifyCanChoseComfortableAmount(){
        GetQuotePage getQuote = new GetQuotePage(getDriver());
        getQuote.moveAmountRange(30);
        getQuote.clickNextButton();
        String height = getQuote.getHeightMessage();
        String weight = getQuote.getWeightMessage();
        assertEquals(height,
                "Height",
                "FATAL!, Not same");
        assertEquals(weight,
                "Weight",
                "FATAL!, Not same");
    }


    /* Apidocs
   *  Steps ->  1. Choose Height from drop-down list (5.7)
                2. Enter Weight (65)
                3. Tap Next button
   *  Expected result ->    Have you used tobacco, nicotine, or cannabis products in the last 3 years? page is open
   */
    @Test(dependsOnMethods = {"verifyCanChoseComfortableAmount"})
    public void verifyCanEnterHeightWeight(){
        GetQuotePage getQuote = new GetQuotePage(getDriver());
        getQuote.selectHeightDropdown();
        getQuote.setWeightField("40");
        getQuote.clickNextButton();
        String text = getQuote.getCannabisMessage();
        assertEquals(text,
                "Have you used tobacco, nicotine, or cannabis products in the last 3 years?",
                "FATAL!, Not same");
    }


   /* Apidocs
   *  Steps ->  1. Choose NO (user didn't use tobacco....)
                2. Tap Next button
   *  Expected result ->    Have you been diagnosed with any of the following conditions in the last 10 years? page is open
   */
    @Test(dependsOnMethods = {"verifyCanEnterHeightWeight"})
    public void verifyRedirectionToPageNoTobacco(){
        GetQuotePage getQuote = new GetQuotePage(getDriver());
        getQuote.clickNoButton();
        getQuote.clickNextButton();
        String text = getQuote.getConditionsMessage();
        assertEquals(text,
                "Have you been diagnosed with any of the following conditions in the last 10 years?",
                "FATAL!, Not same");
    }


    /* Apidocs
    *  Steps -> 1. Mark checkbox (choose NONE OF THE ABOVE in our case)
                2. Tap Next button
    *  Expected result ->   Have you had DUI, moving violation, or suspended license in the last 5 years? page is open
    */
    @Test(dependsOnMethods = {"verifyRedirectionToPageNoTobacco"})
    public void verifyCanchooseDiagnos(){
        GetQuotePage getQuote = new GetQuotePage(getDriver());
        getQuote.clickNoneOfTheAboveButton();
        getQuote.clickNextButton();
        String text = getQuote.getMovingViolationMessage();
        assertEquals(text,
                "Have you had DUI, moving violation, or suspended license in the last 5 years?",
                "FATAL!, Not same");
    }


    /* Apidocs
    *  Steps -> 1. Choose NO (user didn't have DUI....)
                2. Tap Next button
    *  Expected result ->   - Recommended option page is open
                            - Preliminary quote is shown
    */
    @Test(dependsOnMethods = {"verifyCanchooseDiagnos"})
    public void verifyCanChooseNoDUI(){
        GetQuotePage getQuote = new GetQuotePage(getDriver());
        getQuote.clickNoButton();
        getQuote.clickNextButton();
        getQuote.setFirstNameField("Leon");
        getQuote.setEmailField("lion@gmail.com");
        getQuote.setPhoneField();
        getQuote.clickSaveButton();
        String text1 = getQuote.getRecommendedOptionMessage();
        assertEquals(text1,
                "Recommended option",
                "FATAL!, Not same");
        String text2 = getQuote.getPreliminaryQuotesButtonMessage();
        assertEquals(text2,
                "Get Pre-Approved",
                "FATAL!, Not same");
    }

    /* Apidocs
    *  Steps -> 1. Choose Year Coverage by moving the slider (for example, $1 000 000)
                2. Choose Coverage period (for example, 15 years)
                3. Tap on Get Pre-Approved button
    *  Expected result ->   Get pre-approved for the best rates! page is open
    */
    @Test(dependsOnMethods = {"verifyCanChooseNoDUI"})
    public void verifyCanChooseYearAndPeriodRange(){
        GetQuotePage getQuote = new GetQuotePage(getDriver());
        getQuote.moveYearCoverageRange(15);
        getQuote.moveCoveragePeriodRange(-1);
        getQuote.clickPreliminaryQuotesButton();
        String text = getQuote.getPreApprovedMessage();
        assertEquals(text,
                "Get pre-approved for the best rates!",
                "FATAL!, Not same");
    }


    /* Apidocs
    *  Steps -> 1. Fill out the form
                2. Mark checkbox
                3. Tap Next button
    *  Expected result ->   Almost there!  page is open
    */
    @Test(dependsOnMethods = {"verifyCanChooseYearAndPeriodRange"})
    public void verifyCanAddInfoAboutUser(){
        GetQuotePage getQuote = new GetQuotePage(getDriver());
        getQuote.setFirstNameFormField("Leon");
        getQuote.setLastNameFormField("Bolsonaro");
        getQuote.clickAuthorizationCheckBox();
        getQuote.clickNextFormButton();
        String text = getQuote.getAlmostThereMessage();
        assertEquals(text,
                "Almost there!",
                "FATAL!, Not same");
    }


    /* Apidocs
    *  Steps -> 1. Choose comfortable date from drop-down list
                2. Choose time
                3. Tap Submit button
    *  Expected result ->   Family life insurance plan page is open
    */
    @Test(dependsOnMethods = {"verifyCanAddInfoAboutUser"})
    public void verifyCanChooseDateTime4Call(){
        GetQuotePage getQuote = new GetQuotePage(getDriver());
        getQuote.selectDateCall();
        getQuote.selectHourCall();
        getQuote.clickSubmitButton();
        String text = getQuote.getFamilyLifeMessage();
        assertEquals(text,
                "Family life insurance plan",
                "FATAL!, Not same");
    }


    /* Apidocs
    *  Steps -> 1. Choose relationship from dropdown list
                2. Enter DoB
                3. Tap on Add another one
                4. Repeat items 1,2
                5. Tap Submit button
    *  Expected result ->   - Thank you page is open
                            - Chosen data 'Date' and 'Time' are pointed
    */
    @Test(dependsOnMethods = {"verifyCanChooseDateTime4Call"})
    public void verifyCanAddFamilyMembers(){
        GetQuotePage getQuote = new GetQuotePage(getDriver());
        getQuote.selectRelationshipDropdown1();
        getQuote.setDateOfBirth("07031997");
        getQuote.selectRelationshipDropdown2();     // Se on detail tomorrow
        getQuote.setDateOfBirth2("07031997");
        getQuote.clickLastSubmitButton();
        String text1 = getQuote.getThanksUMessage();
        assertEquals(text1,
                "Thank you!",
                "FATAL!, Not same");
        String text2 = getQuote.getScheduleCallMessage();
        assertTrue(text2.contains("Your scheduled call"),
                "FATAL!, Not same");
    }

}
