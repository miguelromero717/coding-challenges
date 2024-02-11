package unit

import com.miguelromero717.wc_tool.WCTool
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WCToolTest {
    
    private lateinit var wcTool: WCTool
    
    @Test
    fun `invalid command`() {
        // given
        val wrongCommand = "ccc"
        
        // when
        val exception = assertThrows<IllegalArgumentException> {
            wcTool = WCTool(args = arrayOf(wrongCommand, "-m", "test.txt"))
        }
        
        // then
        assertEquals("Invalid command: $wrongCommand", exception.message)
    }
    
    @Test
    fun `invalid param command`() {
        // given
        val wrongParamCommand = "-t"
        
        // when
        val exception = assertThrows<IllegalArgumentException> {
            wcTool = WCTool(args = arrayOf("ccwc", wrongParamCommand, "test.txt"))
        }
        
        // then
        assertEquals("Invalid parameter command: $wrongParamCommand", exception.message)
    }

    @Test
    fun `get total count bytes`() {
        // given
        wcTool = WCTool(args = arrayOf("ccwc", "-c", "test.txt"))
        
        // when
        val result = wcTool.getFileReader().getTotalBytes()
        
        // then
        assertEquals(342190, result)
    }
    
    @Test
    fun `get total count lines`() {
        // given
        wcTool = WCTool(args = arrayOf("ccwc", "-l", "test.txt"))
        
        // when
        val result = wcTool.getFileReader().getCountLines()
        
        // then
        assertEquals(7145, result)
    }
    
    @Test
    fun `get total count words`() {
        // given
        wcTool = WCTool(args = arrayOf("ccwc", "-w", "test.txt"))
        
        // when
        val result = wcTool.getFileReader().getCountWords()
        
        // then
        assertEquals(58164, result)
    }
    
    @Test
    fun `get total count characters`() {
        // given
        wcTool = WCTool(args = arrayOf("ccwc", "-m", "test.txt"))
        
        // when
        val result = wcTool.getFileReader().getCountCharacters()
        
        // then
        assertEquals(339292, result)
    }
    
    @Test
    fun `no parameter command - OK`() {
        // given
        wcTool = WCTool(args = arrayOf("ccwc", "test.txt"))
        
        // when
        // then
        wcTool.execute()
    }
}
