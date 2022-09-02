package demoqa.com.pages.component;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultModal {
    SelenideElement element = $(".modal-body");

    public ResultModal checkVisiable() {
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public ResultModal checkData(String data, String acceptData) {
        element.find(new ByText(data)).parent().lastChild().shouldHave(text(acceptData));
        return this;
    }
}