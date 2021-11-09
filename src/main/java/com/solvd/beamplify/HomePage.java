package com.solvd.beamplify;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
        open();
    }

    @FindBy(xpath = "//a[@class='btn_btn__21aoH btn_btn_primary__1tfRY header_btn__1ij_V ']")
    private ExtendedWebElement getQuoteButton;

    public GetQuotePage clickGetQuoteButton() {
        getQuoteButton.click();
        return new GetQuotePage(driver);
    }


}
