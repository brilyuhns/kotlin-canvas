import org.junit.Test
import kotlin.test.assertEquals

class CanvasTest {
    @Test
    fun test4By2Canvas() {
        val result =  Canvas( 4, 2 ).convertToString()
        val expectedResult = "------\n" +
                "|    |\n" +
                "|    |\n" +
                "------\n"
        assertEquals(expectedResult, result)
    }


    @Test
    fun test3by3Canvas() {
        val result =  Canvas(3, 3 ).convertToString()
        val expectedResult = "-----\n" +
                "|   |\n" +
                "|   |\n" +
                "|   |\n" +
                "-----\n"
        assertEquals(expectedResult, result)
    }
}