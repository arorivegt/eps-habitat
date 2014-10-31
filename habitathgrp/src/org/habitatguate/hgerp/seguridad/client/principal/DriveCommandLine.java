package org.habitatguate.hgerp.seguridad.client.principal;

import com.google.gwt.core.client.GWT;
import com.sun.org.apache.xpath.internal.operations.Plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class DriveCommandLine {

  private static final Plus plus = GWT.create(Plus.class);
  private static final String API_KEY = "AIzaSyA5bNyuRQFaTQle_YC5BUH7tQzRmAPiqsM";
  private static final String APPLICATION_NAME = "PlusSample/1.0";
  private static String CLIENT_ID = "172867628904-er4c7pqhstoobolssid30jtlsahgsl6r.apps.googleusercontent.com";
  private static String CLIENT_SECRET = "-CXkk7dKtCDKxY_w2m1yylvG";

  private static String REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob";
  
  public DriveCommandLine() throws IOException {
  
  }
}