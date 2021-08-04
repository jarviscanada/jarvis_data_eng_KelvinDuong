# Introduction
Developed a Java application that mimics the Linux grep command. Given a regex pattern, root directory and output file, the application will recursively check every file in the path for matching lines. The two implementations of the application can be found in the JavaGrepImp and JavaGrepLambdaImp classes. JavaGrepImp uses methods from the Reader class in its implementation to read and write to files. JavaGrepLambdaImp extends and improves on the JavaGrepImp class by making use of Lambda functions wherever possible. The application was Dockerized and uploaded to Docker Hub.
# Quick Start
1. Run using JAR file
```
# build project with maven
mvn clean package

# run program using JAR file
java -cp target/grep-1.0-SNAPSHOT.jar ca.jrvs.apps.grep.JavaGrepImp [regex] [rootDirectory] [outFile]
```
2. Run using Docker
```
# pull image from DockerHub
docker pull kelvin3094/grep

# run docker container
docker run --rm -v `pwd`/data:/data -v `pwd`/out:/out kelvin3094/grep [regex] [rootDirectory] [outFile]
```		
# Implemenation 
## Pseudocode
```
matchedLines = []
for file in listFilesRecursively(rootDir)
  for line in readLines(file)
      if containsPattern(line)
        matchedLines.add(line)
writeToFile(matchedLines)
```

## Performance Issue
The application throws an OutOfMemoryError exception when the size of the files being read is larger than the allocated heap size. A solution would be to use Steam APIs and replace List with Buffer or Stream.

# Test
Testing was done manually through the command line and debugger. Created files with sample data and confirmed that each method gave the correct output. Used the debugger in IntelliJ to run the program line by line and to check if the files were recursively read and retrieved.

# Deployment
The application was dockerized and the image was uploaded to Docker Hub publicly. It can be retrieved and ran by a user.

# Improvement
1.Implement remaining grep option such as case insensitive, number of lines, etc.  
2.Allow different types of outputs. It could show information such as the file name and line number.  
3.An option to display the output in stdout instead of writing to a file.  

