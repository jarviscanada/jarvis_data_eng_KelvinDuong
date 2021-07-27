package ca.jrvs.apps.grep;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.log4j.BasicConfigurator;

public class JavaGrepImp implements JavaGrep {

  final Logger logger = LoggerFactory.getLogger(JavaGrep.class);

  private String regex;
  private String rootPath;
  private String outFile;

  @Override
  public void process() throws IOException {
  }

  @Override
  public List<File> listFiles(String rootDir) {
    return null;
  }

  @Override
  public List<String> readLines(File inputFile) throws IllegalArgumentException {
    return null;
  }

  @Override
  public boolean containsPattern(String line) {
    return false;
  }

  @Override
  public boolean writeToFile(List<String> lines) throws IOException {
    return false;
  }

  @Override
  public String getRootPath() {
    return null;
  }

  @Override
  public void setRootPath(String rootPath) {

  }

  @Override
  public String getRegex() {
    return null;
  }

  @Override
  public void setRegex(String regex) {

  }

  @Override
  public String getOutFile() {
    return null;
  }

  @Override
  public void setOutFile(String outFile) {
  }

  public static void main(String[] args) {
    if (args.length != 3) {
      throw new IllegalArgumentException("USAGE: JavaGrep regex rootPath outFile");
    }

    BasicConfigurator.configure();

    JavaGrepImp javaGrepImp = new JavaGrepImp();
    javaGrepImp.setRegex(args[0]);
    javaGrepImp.setRootPath(args[1]);
    javaGrepImp.setOutFile(args[2]);

    try {
      javaGrepImp.process();
    } catch (Exception ex) {
      javaGrepImp.logger.error(ex.getMessage(), ex);
    }
  }
}
