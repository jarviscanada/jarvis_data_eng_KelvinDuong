package ca.jrvs.apps.grep;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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

  /**
   * Top level search workflow
   *
   * @throws IOException
   */
  @Override
  public void process() throws IOException {
    List<String> matchedLines = new ArrayList<>();
    List<File> fileList = this.listFiles(getRootPath());

    for (File file : fileList) {
      List<String> lines = this.readLines(file);
      for (String line : lines) {
        if (this.containsPattern(line)) {
          matchedLines.add(line);
        }
      }
    }
    writeToFile(matchedLines);
  }

  /**
   * Recursively search a directory for files
   *
   * @param rootDir input directory
   * @return a list of all files in the directory and its subdirectories
   */
  @Override
  public List<File> listFiles(String rootDir) {
    List<File> files = new ArrayList<>();
    File root = new File(rootDir);

    // Get a list of all the files in the directory and check if they are valid
    File[] fileList = root.listFiles();
    if (fileList != null) {
      for (File file : fileList) {
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

  /**
   * Read the lines in a file
   *
   * @param inputFile files to be read
   * @return a list of the lines in the file
   * @throws IllegalArgumentException
   */
  @Override
  public List<String> readLines(File inputFile) throws IllegalArgumentException {
    List<String> lines = new ArrayList<>();

    // Read lines from the file and add to the list. Catch exception and throw new
    // IllegalArgumentException when necessary
    try {
      BufferedReader reader = new BufferedReader(new FileReader(inputFile));
      String nextLine = reader.readLine();
      while (nextLine != null) {
        lines.add(nextLine);
        nextLine = reader.readLine();
      }

      reader.close();
    } catch (IOException e) {
      logger.error(e.getMessage(), new IllegalArgumentException());
    }
    return lines;
  }

  /**
   * Check if a line matches a regex pattern
   *
   * @param line input string
   * @return boolean whether the line matches
   */
  @Override
  public boolean containsPattern(String line) {
    return Pattern.matches(getRegex(), line);
  }

  /**
   * Write to a file given a list of strings
   *
   * @param lines matched line
   * @throws IOException
   */
  @Override
  public void writeToFile(List<String> lines) throws IOException {
    // Create new BufferWriter and write to the outFile
    BufferedWriter writer = new BufferedWriter(new FileWriter(getOutFile()));

    for (String line : lines) {
      writer.write(line + "\n");
    }
    writer.close();
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
