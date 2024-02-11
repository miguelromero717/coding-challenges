package com.miguelromero717.wc_tool

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream

class FileHandler(fileName: String) {
    
    private var outputStream: ByteArrayOutputStream = ByteArrayOutputStream()
    private var fileInputStream: InputStream
    private lateinit var content: ByteArray
    
    init {
        fileInputStream = buildInputStream(fileName = fileName)
        buildOutputContent()
    }
    
    private fun buildOutputContent() {
        val buf = ByteArray(1024)
        var n: Int
        while ((fileInputStream.read(buf).also { n = it }) >= 0) outputStream.write(buf, 0, n)
        content = outputStream.toByteArray()
    }
    
    private fun buildInputStream(fileName: String): InputStream {
        return this::class.java.classLoader.getResourceAsStream(fileName)
            ?: throw IllegalArgumentException("File not found: $fileName")
    }
    
    private fun getInputStream(): InputStream {
        return ByteArrayInputStream(content)
    }
    
    fun getTotalBytes() = getInputStream().available()
    
    fun getCountLines() = getInputStream().bufferedReader().readLines().count()
    
    fun getCountCharacters() = getInputStream().bufferedReader().readText().length
    
    fun getCountWords(): Int {
        var countWords = 0
        getInputStream().bufferedReader().forEachLine { line ->
            if (line.isNotBlank()) {
                val words = line.trim().split("\\s+".toRegex())
                countWords += words.count()
            }
        }
        return countWords
    }
}