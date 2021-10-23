import org.junit.Test
import kotlin.test.assertEquals

class DrawingTest {
    @Test
    fun test4By2Canvas() {
        val ass = Drawing()
        val result =  ass.execute("C", 4, 2 )
        val expectedResult = "------\n" +
                "|    |\n" +
                "|    |\n" +
                "------\n"
        assertEquals(expectedResult, result)
    }


    @Test
    fun test3by3Canvas() {
        val ass = Drawing()
        val result =  ass.execute("C", 3, 3 )
        val expectedResult = "-----\n" +
                "|   |\n" +
                "|   |\n" +
                "|   |\n" +
                "-----\n"
        assertEquals(expectedResult, result)
    }
}