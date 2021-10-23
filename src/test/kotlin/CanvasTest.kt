import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.expect

class CanvasTest {
    @Test
    fun test4By2Canvas() {
        val ass = Canvas()
        val result =  ass.execute("C", 4, 2 )
        val expectedResult = "------\n" +
                "|    |\n" +
                "|    |\n" +
                "------\n"
        assertEquals(expectedResult, result)
    }


    @Test
    fun test3by3Canvas() {
        val ass = Canvas()
        val result =  ass.execute("C", 3, 3 )
        val expectedResult = "-----\n" +
                "|   |\n" +
                "|   |\n" +
                "|   |\n" +
                "-----\n"
        assertEquals(expectedResult, result)
    }
}