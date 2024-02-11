package com.miguelromero717.wc_tool

fun main() {
    val line = readln()
    val wcTool = WCTool(args = line.split(" ").toTypedArray())
    wcTool.execute()
    
    /**
     * //TODO The Final Step
     * In this step your goal is to support being able to read from standard input if no filename is specified.
     * Your output should match this:
     *
     * >cat test.txt | ccwc -l
     *     7145
     *
     * val proc = ProcessBuilder(*line.split(" ").toTypedArray()).start()
     *
     */
}
