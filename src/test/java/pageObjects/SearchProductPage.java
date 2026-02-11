package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SearchProductPage extends BasePage{

	public SearchProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement searchBox;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchIcon;
	
	@FindBy(xpath="//select[@name='category_id']")
	private WebElement categoriesDropdown;
	
	@FindBy(xpath="(//input[@name='sub_category'])[1]")
	private WebElement subCategory;
	
	@FindBy(xpath="//input[@id='description']")
	private WebElement productDescription;
	
	@FindBy(xpath="//input[@id='button-search']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//select[@id='input-sort']")
	private WebElement sortByDropDown;
	
	@FindBy(xpath="//div[@class='product-thumb']")
	private WebElement productThumb;
	
	public void searchProduct(String product)
	{
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		searchBox.sendKeys(product);
		wait.until(ExpectedConditions.elementToBeClickable(searchIcon));
		searchIcon.click();
	}
	
	public void selectCategory()
	{
		wait.until(ExpectedConditions.visibilityOf(categoriesDropdown));
		Select select=new Select(categoriesDropdown);
		select.selectByVisibleText("Phones & PDAs");
	}
	
	public void searchInSubcategory()
	{
		wait.until(ExpectedConditions.elementToBeClickable(subCategory));
		subCategory.click();
	}
	
	public void searchInProductDescription()
	{
		wait.until(ExpectedConditions.elementToBeClickable(productDescription));
		productDescription.click();
	}
	
	public void clickOnSearchBtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
		searchBtn.click();
	}
	
	public void sortByPrice()
	{
		wait.until(ExpectedConditions.visibilityOf(sortByDropDown));
		Select select=new Select(sortByDropDown);
		select.selectByContainsVisibleText("Price (Low > High)");
	}
	
	public boolean isProductListPresent()
	{
		return productThumb.isDisplayed();
	}

}
