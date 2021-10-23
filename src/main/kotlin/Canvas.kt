class Canvas {
    fun execute(s: String, length: Int, height: Int): String {
        var x = verticalBorderLine("-", length)
        x = x.plus(emptyCanvasLine("|", length).repeat(height))
        x = x.plus(verticalBorderLine("-", length))
//
        return x

    }

    fun verticalBorderLine(char: String, length: Int):String = (char.repeat(length+2) + "\n")
    fun emptyCanvasLine(char: String, length: Int):String = (char.plus(" ".repeat(length)).plus(char.plus("\n")))
}
