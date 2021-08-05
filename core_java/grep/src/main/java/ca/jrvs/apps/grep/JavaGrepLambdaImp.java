package ca.jrvs.apps.grep;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JavaGrepLambdaImp extends JavaGrepImp {

  @Override
  public List<String> readLines(File inputFile) throws IllegalArgumentException {
    Path path = inputFile.toPath();
    List<String> lines = new ArrayList<>();
    try {
      Files.lines(path).forEach(line -> lines.add(line));
    } catch (Exception e) {
      logger.error(e.getMessage() + ": Unable to read lines from file");
      throw new IllegalArgumentException();
    }
    return lines;
  }

  @Override
  public List<File> listFiles(String rootDir) throws IOException {
    Path path = Paths.get(rootDir);
    List<File> files = new ArrayList<>();
    try {
      Files.walk(path)
          .filter(Files::isRegularFile)
          .forEach(file -> files.add(file.toFile()));
    } catch (Exception e) {
      logger.error(e.getMessage() + ": Unable to read files in directory");
      throw new RuntimeException();
    }
    return files;
  }

  public static void main(String[] args) {
    if (args.length != 3) {
      throw new IllegalArgumentException("USAGE: JavaGrep regex rootPath outFile");
    }
    JavaGrepLambdaImp javaGrepLambdaImp = new JavaGrepLambdaImp();
    javaGrepLambdaImp.setRegex(args[0]);
    javaGrepLambdaImp.setRootPath(args[1]);
    javaGrepLambdaImp.setOutFile(args[2]);

    try {
      javaGrepLambdaImp.process();
    } catch (Exception e) {
      javaGrepLambdaImp.logger.error(e.getMessage() + ": Unable to perform grep command");
    }
  }
}
