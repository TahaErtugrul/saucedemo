package com.saucedemo.pages;


import com.saucedemo.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {

    @FindBy(xpath= "//a[@id='item_4_img_link']//img")
    protected WebElement pageSubTitle;

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String getPictureTitleText() {
        return pageSubTitle.getAttribute("src")
        ;
    }


}