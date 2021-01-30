package Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormFluentPO extends BasePO {
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

    //wybierz losowy kontynent
    //wybierz losowy years of expirience
    //wybierz losową ilość Commands

    public FormFluentPO fillName(String name, String lastName) {
        inputFirstName.sendKeys(name);
        inputLastName.sendKeys(lastName);
        return this;
    }

    public FormFluentPO fillEmail(String email) {
        inputEmail.sendKeys(email);
        return this;
    }

    public FormFluentPO chooseSex() {
        inputSex.click();
        return this;
    }

    public FormFluentPO fillAge(String age) {
        inputAge.sendKeys(age);
        return this;
    }

    public FormFluentPO fillYearsOfExperience() {

        getRandomElement(inputYearsOfExperience).click();
        return this;
    }

    public FormFluentPO fillProfession() {
        inputProfession.click();
        return this;
    }

    public FormFluentPO fillContinent() {
        Select continents = new Select(inputContinent);
        List<WebElement> listcontinent = continents.getOptions();
        listcontinent.remove(0);
        WebElement randomContinent = getRandomElement(listcontinent);
        continents.selectByVisibleText(randomContinent.getText());
        return this;
    }

    public FormFluentPO fillCommand() {
        Select commands = new Select(inputCommands);
        List<WebElement> listCommant = commands.getOptions();
        int elementNum = getRandomNumber(listCommant.size());

        for (int i = 0; i < elementNum; i++) {
            commands.selectByIndex(i);
        }
        return this;
    }

    public FormFluentPO chooseFile(String adress){
        File file = new File(adress);
        chooseFile.sendKeys(file.getAbsolutePath());
        return this;
    }

    public FormFluentPO clickSaveButton(){
        clickSaveButton.click();
        return this;
    }

    public String validation(){
       return validation.getText();
    }






/*    public FormPO(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.get("https://seleniumui.moderntester.pl/form.php");
    }*/

   public FormFluentPO(WebDriver driver){
       super(driver);
       ownUrl = "https://seleniumui.moderntester.pl/form.php";
   }
}
