package uitests.serenity.bdd.steps;

import net.thucydides.core.annotations.Steps;
import uitests.serenity.bdd.steps.serenity.EndUserSteps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUser;

    @Given("the user is on the Wikionary home page")
    public void givenTheUserIsOnTheWikionaryHomePage() {
        endUser.is_the_home_page();
    }

    @When("the user looks up the definition of the word $word")
    public void whenTheUserLooksUpTheDefinitionOf(final String word) {
        endUser.looks_for(word);
    }

    @Then("they should see the definition $definition")
    public void thenTheyShouldSeeADefinitionContainingTheWords(final String definition) {
        endUser.should_see_definition(definition);
    }

}
