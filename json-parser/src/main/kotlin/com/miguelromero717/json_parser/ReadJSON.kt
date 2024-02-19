package com.miguelromero717.json_parser

import java.io.InputStream

class ReadJSON(path: String) {
    
    private fun buildInputStream(fileName: String): InputStream {
        return this::class.java.classLoader.getResourceAsStream(fileName)
            ?: throw IllegalArgumentException("File not found: $fileName")
    }
}
