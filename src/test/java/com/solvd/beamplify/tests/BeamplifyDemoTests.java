package com.solvd.beamplify.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.beamplify.GetQuotePage;
import com.solvd.beamplify.services.IGetAQuoteService;

public class BeamplifyDemoTests implements IAbstractTest, IGetAQuoteService {

    @Test
    public void verifyHomePageWorkflow() {
        GetQuotePage getQuotePage = goToInsuranceReasonWithDefaults(getDriver());
        assertEquals(getQuotePage.getlifeInsuranceMessage(), "Why are you looking for life insurance?", "FATAL!, Not same");
    }

    @Test
    public void verifyCheckboxesCanBeSelected() {
    	GetQuotePage getQuotePage = goToGetDOBWithDefaults(getDriver());
        assertEquals(getQuotePage.getDateOfBirthMessage(), "What’s your date of birth", "FATAL!, Not same");
    }

    @Test()
    public void verifyIfCanEnterDateOfBirth() {
    	GetQuotePage getQuotePage = goToGenderWithDefaults(getDriver());
        assertEquals(getQuotePage.getGenderMessage(), "What’s your gender?", "FATAL!, Not same");
    }

    @Test()
    public void verifyIfCanChooseGender() {
    	GetQuotePage getQuotePage = goToZipCodeWithDefaults(getDriver());
        assertEquals(getQuotePage.getZipCodeMessage(), "What’s your zip code?", "FATAL!, Not same");
    }


    @Test()
    public void verifyCanEnterZipCode() {
    	GetQuotePage getQuotePage = goToIncomeWithDefaults(getDriver());
        assertEquals(getQuotePage.getHouseholdMessage(), "What is your annual household income?", "FATAL!, Not same");
    }


    @Test()
    public void verifyCanSelectAnualHousehold() {
    	GetQuotePage getQuotePage = goToMonthlyContributionWithDefaults(getDriver());
        assertEquals(getQuotePage.getComfortableAmountMessage(),
                "What's a comfortable amount for you to contribute towards a policy on a monthly basis?",
                "FATAL!, Not same");
    }

    @Test()
    public void verifyCanChoseComfortableAmount() {
    	GetQuotePage getQuotePage = goToBodyParametersWithDefaults(getDriver());
        assertEquals(getQuotePage.getHeightMessage(), "Height", "FATAL!, Not same");
        assertEquals(getQuotePage.getWeightMessage(), "Weight", "FATAL!, Not same");
    }

    @Test()
    public void verifyCanEnterHeightWeight() {
    	GetQuotePage getQuotePage = goToTobaccoWithDefaults(getDriver());
        assertEquals(getQuotePage.getCannabisMessage(),
                "Have you used tobacco, nicotine, or cannabis products in the last 3 years?",
                "FATAL!, Not same");
    }

    @Test()
    public void verifyRedirectionToPageNoTobacco(){
    	GetQuotePage getQuotePage = goToConditionsWithDefaults(getDriver());
        assertEquals(getQuotePage.getConditionsMessage(),
                "Have you been diagnosed with any of the following conditions in the last 10 years?",
                "FATAL!, Not same");
    }

    @Test()
    public void verifyCanchooseDiagnos(){
    	GetQuotePage getQuotePage = goToDUIWithDefaults(getDriver());
        assertEquals(getQuotePage.getMovingViolationMessage(),
                "Have you had DUI, moving violation, or suspended license in the last 5 years?",
                "FATAL!, Not same");
    }

    @Test()
    public void verifyCanChooseNoDUI(){
    	GetQuotePage getQuotePage = goToFindInsuranceWithDefaults(getDriver());
        assertEquals(getQuotePage.getRecommendedOptionMessage(), "Recommended option", "FATAL!, Not same");
        assertEquals(getQuotePage.getPreliminaryQuotesButtonMessage(), "Get Pre-Approved", "FATAL!, Not same");
    }

    @Test()
    public void verifyCanChooseYearAndPeriodRange(){
    	GetQuotePage getQuotePage = goToPreApprovedWithDefaults(getDriver());
        assertEquals(getQuotePage.getPreApprovedMessage(), "Get pre-approved for the best rates!", "FATAL!, Not same");
    }

    @Test()
    public void verifyCanAddInfoAboutUser(){
    	GetQuotePage getQuotePage = goToAlmostThereWithDefaults(getDriver());
        assertEquals(getQuotePage.getAlmostThereMessage(), "Almost there!", "FATAL!, Not same");
    }

    @Test()
    public void verifyCanChooseDateTime4Call(){
    	GetQuotePage getQuotePage = goToInsurancePlanWithDefaults(getDriver());
        assertEquals(getQuotePage.getFamilyLifeMessage(), "Family life insurance plan", "FATAL!, Not same");
    }

    @Test()
    public void verifyCanAddFamilyMembers(){
    	GetQuotePage getQuotePage = goToCompleteQuoteWithDefaults(getDriver());
        assertEquals(getQuotePage.getThanksUMessage(), "Thank you!", "FATAL!, Not same");
        assertTrue(getQuotePage.getScheduleCallMessage().contains("Your scheduled call"), "FATAL!, Not same");
    }

}
