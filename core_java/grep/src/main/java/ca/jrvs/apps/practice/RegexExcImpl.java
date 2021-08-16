package ca.jrvs.apps.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExcImpl implements RegexExc {

  @Override
  public boolean matchJpeg(String filename) {
    Pattern pattern = Pattern.compile(".*.jpe?g", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(filename);
    return matcher.matches();
  }

  @Override
  public boolean matchIp(String ip) {
    Pattern pattern = Pattern.compile("[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}");
    Matcher matcher = pattern.matcher(ip);
    return matcher.matches();
  }

  @Override
  public boolean isEmptyLine(String Line) {
    Pattern pattern = Pattern.compile("^\\s*$");
    Matcher matcher = pattern.matcher(Line);
    return matcher.matches();
  }

  public static void main(String[] args) {
    RegexExcImpl regex = new RegexExcImpl();

    // Testing matchJpeg
    String fileName1 = "matches.jPEg";
    String fileName2 = "matches.JPg";
    String fileName3 = "DoesNotMatch.png";

    System.out.println(regex.matchJpeg(fileName1)); // true
    System.out.println(regex.matchJpeg(fileName2)); // true
    System.out.println(regex.matchJpeg(fileName3)); // false

    // Testing matchIp
    String ip1 = "192.7.0.2";
    String ip2 = "1000.50.3.4";
    String ip3 = "0.0.0.0";
    System.out.println(regex.matchIp(ip1)); // true
    System.out.println(regex.matchIp(ip2)); // false
    System.out.println(regex.matchIp(ip3)); // true

    // Testing isEmptyLine
    String empty = "";
    String notEmpty = "1000.50.3.4";
    String notEmpty2 = " ";
    System.out.println(regex.isEmptyLine(empty)); // true
    System.out.println(regex.isEmptyLine(notEmpty)); // false
    System.out.println(regex.isEmptyLine(notEmpty2)); // true
  }
}
