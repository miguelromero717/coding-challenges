# WC Tool

This challenge is based on the [Build your own WC Tool Coding Challenge](https://codingchallenges.fyi/challenges/challenge-wc/)

## Stack

* JDK 21
* Kotlin 1.9.22

## Commands Supported

### Get Total Bytes
```
ccwc -c test.txt
```

### Get Total Lines
```
ccwc -l test.txt
```

### Get Total Words
```
ccwc -w test.txt
```

### Get Total Characters
```
ccwc -m test.txt
```

## Running

1. Execute Gradle run
   ```
   ./gradlew run
   ```
2. Add the command for the WC Tool
   ```
   ## Get total bytes
   ccwc -c test.txt
   ```

## TODO

```
The Final Step
In this step your goal is to support being able to read from standard input if no filename is specified.
Your output should match this:
cat test.txt | ccwc -l
     7145
```
