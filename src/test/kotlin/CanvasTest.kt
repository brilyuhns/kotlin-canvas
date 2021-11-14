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

    @Test
    fun testHorizontalLine() {
        val canvas =  Canvas(20, 4 )
        print(canvas.convertToString())
        canvas.addLine(1,2,6,2)
        val expectedResult = ("----------------------\n" +
        "|                    |\n" +
        "|xxxxxx              |\n" +
        "|                    |\n" +
        "|                    |\n" +
        "----------------------\n")
        assertEquals(expectedResult, canvas.convertToString())
    }

    @Test
    fun testVerticalLine() {
        val canvas =  Canvas(20, 4 )
        print(canvas.convertToString())
        canvas.addLine(6, 3, 6, 4)
        val expectedResult = ("----------------------\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|     x              |\n" +
                "|     x              |\n" +
                "----------------------\n")
        assertEquals(expectedResult, canvas.convertToString())
    }

   @Test
    fun test2lines() {
        val canvas =  Canvas(20, 4 )
        print(canvas.convertToString())
        canvas.addLine(1,2,6,2)
        canvas.addLine(6, 3, 6, 4)
        val expectedResult = ("----------------------\n" +
                "|                    |\n" +
                "|xxxxxx              |\n" +
                "|     x              |\n" +
                "|     x              |\n" +
                "----------------------\n")
        assertEquals(expectedResult, canvas.convertToString())
    }

    @Test
    fun testRectangle() {
        val canvas =  Canvas(20, 4 )
        print(canvas.convertToString())
        canvas.addRectangle(14, 1, 18, 3)
        val expectedResult = ("----------------------\n" +
                "|             xxxxx  |\n" +
                "|             x   x  |\n" +
                "|             xxxxx  |\n" +
                "|                    |\n" +
                "----------------------\n")
        assertEquals(expectedResult, canvas.convertToString())
    }

    @Test
    fun testFill() {
        val canvas =  Canvas(20, 4 )
        print(canvas.convertToString())
        canvas.addRectangle(14, 1, 18, 3)
        print(canvas.convertToString())
        canvas.fillBfs(10,3, "o")
        print(canvas.convertToString())
        val expectedResult = ("----------------------\n"+
            "|oooooooooooooxxxxxoo|\n" +
            "|ooooooooooooox   xoo|\n" +
            "|oooooooooooooxxxxxoo|\n" +
            "|oooooooooooooooooooo|\n" +
            "----------------------\n")
        assertEquals(expectedResult, canvas.convertToString())
    }
}

