package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.apache.commons.io.FileUtils;

public class Screenshotutils {

 public static String captureScreenshot(WebDriver driver, String testName) {

  TakesScreenshot ts = (TakesScreenshot) driver;

  File src = ts.getScreenshotAs(OutputType.FILE);

  String path = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";

  File dest = new File(path);

  try {
   FileUtils.copyFile(src, dest);
  } catch (IOException e) {
   e.printStackTrace();
  }

  return path;
 }
}
