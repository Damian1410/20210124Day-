package Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.sql.Driver;
import java.util.List;
import java.util.Random;

public class FormPO extends BasePO {
    @FindBy(id = "inputFirstName3")
    private WebElement inputFirstName;

    @FindBy(id = "inputLastName3")
    private WebElement inputLastName;

    @FindBy(css = "input[type='email']")
    private WebElement inputEmail;

    @FindBy(id = "gridRadiosFemale")
    private WebElement inputSex;

    @FindBy(id = "inputAge3")
    private WebElement inputAge;

    @FindBy(css = "[name='gridRadiosExperience']")
    private List<WebElement> inputYearsOfExperience;

    @FindBy(id = "gridCheckAutomationTester")
    private WebElement inputProfession;

    @FindBy(id = "selectContinents")
    private WebElement inputContinent;

    @FindBy(id = "selectSeleniumCommands")
    private WebElement inputCommands;

    @FindBy(id = "chooseFile")
    private WebElement chooseFile;

    @FindBy(css = "[type='submit']")
    private WebElement clickSaveButton;

    @FindBy(id = "validator-message")
    private WebElement validation;



    public void fillName(String name, String lastName) {
        inputFirstName.sendKeys(name);
        inputLastName.sendKeys(lastName);
    }

    public void fillEmail(String email) {
        inputEmail.sendKeys(email);
    }

    public void chooseSex() {
        inputSex.click();
    }

    public void fillAge(String age) {
        inputAge.sendKeys(age);
    }

    public void fillYearsOfExperience() {

        getRandomElement(inputYearsOfExperience).click();
    }

    public void fillProfession() {
        inputProfession.click();
    }

    public void fillContinent() {
        Select continents = new Select(inputContinent);
        List<WebElement> listcontinent = continents.getOptions();
        listcontinent.remove(0);
        WebElement randomContinent = getRandomElement(listcontinent);
        continents.selectByVisibleText(randomContinent.getText());
    }

    public void fillCommand() {
        Select commands = new Select(inputCommands);
        List<WebElement> listCommant = commands.getOptions();
        int elementNum = getRandomNumber(listCommant.size());

        for (int i = 0; i < elementNum; i++) {
            commands.selectByIndex(i);
        }
    }

    public void chooseFile(String adress){
        File file = new File(adress);
        chooseFile.sendKeys(file.getAbsolutePath());
    }

    public void clickSaveButton(){
        clickSaveButton.click();
    }

    public String validation(){
       return validation.getText();
    }



    private int getRandomNumber(int max) {
        Random rnd = new Random();
        return rnd.nextInt(max) + 1;
    }

    private WebElement getRandomElement(List<WebElement> webElements) {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(webElements.size());
        return webElements.get(randomNumber);
    }


/*    public FormPO(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.get("https://seleniumui.moderntester.pl/form.php");
    }*/

   public FormPO(WebDriver driver){
       super(driver);
       ownUrl = "https://seleniumui.moderntester.pl/form.php";
   }
}
