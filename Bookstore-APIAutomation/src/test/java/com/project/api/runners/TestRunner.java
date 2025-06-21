package com.project.api.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

import com.project.api.listeners.*;

@Listeners({TestListener.class})
@CucumberOptions(
    features = "src/test/java/resources/features",
    glue = {"com.project.api.stepdefinitions"},
    plugin = {"pretty", "html:target/cucumber-html-report.html"},
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

