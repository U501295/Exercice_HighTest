package org.exercice.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporter {

    public static ExtentReports extent = new ExtentReports();
    public static ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("src/test/resources/output/rapport_execution.html");
    public static ExtentTest testCase;
}
