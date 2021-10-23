import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.expect

class CanvasTest {
    @Test
    fun test4By2Canvas() {
        val ass = Canvas()
        val result =  ass.execute("create_canvas", 4, 2 )
        print(result)
        val expectedResult = "------\n" +
                "|    |\n" +
                "|    |\n" +
                "------\n"
        print(expectedResult)
        assertEquals(expectedResult, result)
    }


    @Test
    fun test3by3Canvas() {
        val ass = Canvas()
        val result =  ass.execute("create_canvas", 3, 3 )
        print(result)
        val expectedResult = "-----\n" +
                "|   |\n" +
                "|   |\n" +
                "|   |\n" +
                "-----\n"
        print(expectedResult)
        assertEquals(expectedResult, result)
    }
}