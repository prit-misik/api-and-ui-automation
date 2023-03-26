package util;

import base.BasePage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JavaUtils extends BasePage {

  public static String readTextFromFile(String pathToFile) {

    try {
      return new String(Files.readAllBytes(Paths.get(pathToFile)));

    } catch (IOException e) {
      APP_LOGS.error("Error found ::" + e);
    }
    return null;
  }
}

