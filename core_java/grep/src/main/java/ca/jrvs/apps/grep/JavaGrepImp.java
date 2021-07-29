package ca.jrvs.apps.grep;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.log4j.BasicConfigurator;

public class JavaGrepImp implements JavaGrep {

  final Logger logger = LoggerFactory.getLogger(JavaGrep.class);

  private String regex;
  private String rootPath;
  private String outFile;

  @Override
  public String getRegex() {
    return regex;
  }

  @Override
  public void setRegex(String regex) {
    this.regex = regex;
  }

  @Override
  public String getRootPath() {
    return rootPath;
  }

  @Override
  public void setRootPath(String rootPath) {
    this.rootPath = rootPath;
  }

  @Override
  public String getOutFile() {
    return outFile;
  }

  @Override
  public void setOutFile(String outFile) {
    this.outFile = outFile;
  }

  @Override
  public void process() throws IOException {
  }

  /**
   * Return a list of all the files in the directory recursively
   * @param rootDir input directory
   * @return
   */
  @Override
  public List<File> listFiles(String rootDir) {
    List<File> files = new ArrayList<>();
    File root = new File(rootDir);

    // Get a list of all the files in the directory and check if they are valid
    File[] fileList = root.listFiles();
    if (fileList != null) {
      for (File file: fileList) {
        // If it is a directory, recursive call on the directory
        if (file.isDirectory()) {
          files.addAll(listFiles(file.getAbsolutePath()));
        } else {
          files.add(file);
        }
      }
    }
    return files;
  }

  @Override
  public List<String> readLines(File inputFile) throws IllegalArgumentException {
    List<String> lines = new ArrayList<>();

    // Read lines from the file and add to the list. Catch exception and throw new
    // IllegalArgumentException when necessary
    try {
      BufferedReader reader = new BufferedReader(new FileReader(inputFile));
      String nextLine = reader.readLine();
      while(nextLine != null) {
        lines.add(nextLine);
        nextLine = reader.readLine();
      }

      reader.close();
    } catch (IOException e){
      logger.error(e.getMessage(), new IllegalArgumentException());
    }
    return lines;
  }

  @Override
  public boolean containsPattern(String line) {
    return Pattern.matches(getRegex(), line);
  }

  @Override
  public boolean writeToFile(List<String> lines) throws IOException {
    return false;
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

    // Testing part
    List<File> files = javaGrepImp.listFiles(args[1]);
    System.out.println(javaGrepImp.readLines(files.get(0)));
    List<String> lines = javaGrepImp.readLines(files.get(0));
    for (String line:lines) {
      if(javaGrepImp.containsPattern(line)) {
        System.out.println(line);
      }
    }
  }
}
