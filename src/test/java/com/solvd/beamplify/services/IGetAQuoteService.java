package com.solvd.beamplify.services;

import org.openqa.selenium.WebDriver;

import com.solvd.beamplify.GetQuotePage;
import com.solvd.beamplify.HomePage;

public interface IGetAQuoteService {

	default GetQuotePage goToInsuranceReasonWithDefaults(WebDriver driver) {
		HomePage homePage = new HomePage(driver);
        GetQuotePage getQuote = homePage.clickGetQuoteButton();
        getQuote.switchToQuoteWindow("Amplify");
        getQuote.clickNextButton();
        return new GetQuotePage(driver);
	}
	
	default GetQuotePage goToGetDOBWithDefaults(WebDriver driver) {
		GetQuotePage getQuote = goToInsuranceReasonWithDefaults(driver);
		getQuote.selectCheckBoxes();
	    getQuote.clickNextButton();
		return getQuote;
	}
	
	default GetQuotePage goToGenderWithDefaults(WebDriver driver) {
		GetQuotePage getQuote = goToGetDOBWithDefaults(driver);
		getQuote.setDateOfBirth("07031997");
        getQuote.clickNextButton();
		return getQuote;
	}
	
	default GetQuotePage goToZipCodeWithDefaults(WebDriver driver) {
		GetQuotePage getQuote = goToGenderWithDefaults(driver);
		getQuote.clickFemaleButton();
        getQuote.clickNextButton();
		return getQuote;
	}
	
	default GetQuotePage goToIncomeWithDefaults(WebDriver driver) {
		GetQuotePage getQuote = goToZipCodeWithDefaults(driver);
		getQuote.setZipCode();                           
        getQuote.clickNextButton();
		return getQuote;
	}
	
	default GetQuotePage goToMonthlyContributionWithDefaults(WebDriver driver) {
		GetQuotePage getQuote = goToIncomeWithDefaults(driver);
		getQuote.selectAnnualHouseholdDropdown();
        getQuote.setOccupationField("Software developer");
        getQuote.clickNextButton();
		return getQuote;
	}
	
	default GetQuotePage goToBodyParametersWithDefaults(WebDriver driver) {
		GetQuotePage getQuote = goToMonthlyContributionWithDefaults(driver);
		getQuote.moveAmountRange(30);
	    getQuote.clickNextButton();
		return getQuote;
	}
	
	default GetQuotePage goToTobaccoWithDefaults(WebDriver driver) {
		GetQuotePage getQuote = goToBodyParametersWithDefaults(driver);
		getQuote.selectHeightDropdown();
        getQuote.setWeightField("40");
        getQuote.clickNextButton();
		return getQuote;
	}
	
	default GetQuotePage goToConditionsWithDefaults(WebDriver driver) {
		GetQuotePage getQuote = goToTobaccoWithDefaults(driver);
		getQuote.clickNoButton();
	    getQuote.clickNextButton();
		return getQuote;
	}
	
	default GetQuotePage goToDUIWithDefaults(WebDriver driver) {
		GetQuotePage getQuote = goToConditionsWithDefaults(driver);
		getQuote.clickNoneOfTheAboveButton();
	    getQuote.clickNextButton();
		return getQuote;
	}
	
	default GetQuotePage goToFindInsuranceWithDefaults(WebDriver driver) {
		GetQuotePage getQuote = goToDUIWithDefaults(driver);
		getQuote.clickNoButton();
	    getQuote.clickNextButton();
	    getQuote.setFirstNameField("Andrew");
	    getQuote.setEmailField("andrew@gmail.com");
	    getQuote.setPhoneField();
	    getQuote.clickSaveButton();
		return getQuote;
	}
	
	default GetQuotePage goToPreApprovedWithDefaults(WebDriver driver) {
		GetQuotePage getQuote = goToFindInsuranceWithDefaults(driver);
		getQuote.moveYearCoverageRange(15);
	    getQuote.moveCoveragePeriodRange(-1);
	    getQuote.clickPreliminaryQuotesButton();
		return getQuote;
	}
	
	default GetQuotePage goToAlmostThereWithDefaults(WebDriver driver) {
		GetQuotePage getQuote = goToFindInsuranceWithDefaults(driver);
		getQuote.setFirstNameFormField("Andrew");
        getQuote.setLastNameFormField("Nazarenko");
        getQuote.clickAuthorizationCheckBox();
        getQuote.clickNextFormButton();
		return getQuote;
	}
	
	default GetQuotePage goToInsurancePlanWithDefaults(WebDriver driver) {
		GetQuotePage getQuote = goToAlmostThereWithDefaults(driver);
		getQuote.selectDateCall();
        getQuote.selectHourCall();
        getQuote.clickSubmitButton();
		return getQuote;
	}
	
	default GetQuotePage goToCompleteQuoteWithDefaults(WebDriver driver) {
		GetQuotePage getQuote = goToInsurancePlanWithDefaults(driver);
		getQuote.selectRelationshipDropdown1();
        getQuote.setDateOfBirth("07031997");
        getQuote.selectRelationshipDropdown2();    
        getQuote.setDateOfBirth2("07031997");
        getQuote.clickLastSubmitButton();
		return getQuote;
	}
	
}
