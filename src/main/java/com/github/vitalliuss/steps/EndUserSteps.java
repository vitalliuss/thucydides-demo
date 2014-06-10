package com.github.vitalliuss.steps;

import static org.fest.assertions.Assertions.assertThat;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.github.vitalliuss.pages.DictionaryPage;

public class EndUserSteps extends ScenarioSteps
{

	DictionaryPage dictionaryPage;

	@Step
	public void enters(String keyword)
	{
		dictionaryPage.enter_keywords(keyword);
	}

	@Step
	public void starts_search()
	{
		dictionaryPage.lookup_terms();
	}

	@Step
	public void should_see_definition(String definition)
	{
		boolean isFound = false;
		for (String onscreenDefinition : dictionaryPage.getDefinitions())
		{
			isFound = definition.contains(onscreenDefinition);
		}
		assertThat(isFound);
	}

	@Step
	public void is_the_home_page()
	{
		dictionaryPage.open();
	}

	@Step
	public void looks_for(String term)
	{
		enters(term);
		starts_search();
	}
}
