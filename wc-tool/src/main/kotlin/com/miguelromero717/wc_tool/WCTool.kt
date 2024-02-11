package com.miguelromero717.wc_tool

import java.util.logging.Logger

class WCTool(private val args: Array<String>) {
    
    companion object {
        private const val COMMAND = "ccwc"
    }
    
    private val logger: Logger = Logger.getLogger(WCTool::class.java.name)
    
    private lateinit var parameterCommand: String
    private lateinit var fileName: String
    private lateinit var fileHandler: FileHandler
    
    init {
        if (args.isEmpty()) {
            throw IllegalArgumentException("No arguments")
        }
        validateArgs(args = args)
    }
    
    fun getFileReader(): FileHandler {
        return fileHandler
    }
    
    private fun validateArgs(args: Array<String>) {
        val toolCommand = args[0]
        
        if (COMMAND != toolCommand) {
            throw IllegalArgumentException("Invalid command: $toolCommand")
        }
        
        if (args.size == 2) {
            parameterCommand = ""
            fileName = args[1]
            initFileReader(fileName = fileName)
        }
        
        if (args.size == 3) {
            parameterCommand = args[1]
            
            if (Commands.entries.toTypedArray().none { it.value == parameterCommand }) {
                throw IllegalArgumentException("Invalid parameter command: $parameterCommand")
            }
            
            fileName = args[2]
            initFileReader(fileName = fileName)
        }
    }
    
    private fun initFileReader(fileName: String) {
        fileHandler = FileHandler(fileName = fileName)
    }
    
    fun execute() {
        val response = when (parameterCommand) {
            Commands.C.value -> buildResponse(total = fileHandler.getTotalBytes().toString())
            Commands.L.value -> buildResponse(total = fileHandler.getCountLines().toString())
            Commands.M.value -> buildResponse(total = fileHandler.getCountCharacters().toString())
            Commands.W.value -> buildResponse(total = fileHandler.getCountWords().toString())
            else -> {
                val countLines = fileHandler.getCountLines()
                val countWords = fileHandler.getCountWords()
                val totalBytes = fileHandler.getTotalBytes()
                buildResponse(total = "$countLines $countWords $totalBytes")
            }
        }
        
        printResponse(response = response)
    }
    
    private fun buildResponse(total: String): String {
        return "$total $fileName"
    }
    
    private fun printResponse(response: String) {
        logger.info(response)
    }
}