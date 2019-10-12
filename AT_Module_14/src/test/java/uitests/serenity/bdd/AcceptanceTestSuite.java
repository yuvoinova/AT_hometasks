package uitests.serenity.bdd;

import org.jbehave.core.annotations.BeforeStories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.jbehave.SerenityStories;
import ui_tests.properties.EnvironmentPropertyLoader;

public class AcceptanceTestSuite extends SerenityStories {
	@BeforeStories
	public void setup() {
		Logger log = LoggerFactory.getLogger(AcceptanceTestSuite.class);
		String environment = EnvironmentPropertyLoader.getInstance().getProperty("environment");
		log.info("environment=" + environment);
	}
}
