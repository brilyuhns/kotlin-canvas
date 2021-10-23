class Drawing {
    fun execute(command: String, length: Int, height: Int):String {
        val canvas = if(command == "C"){
            emptyCanvas(length, height)
        } else { arrayOf(arrayOf(" ")) }
        return canvasToString(canvas, length)
    }

    fun emptyCanvas(length: Int, height: Int): Array<Array<String>> {
        return Array(height) { Array(length){ " " } }
    }

    fun canvasToString(canvas: Array<Array<String>>, length: Int): String {
        var x = horizontalBorderLine("-", length)
        for(row in canvas){
            x = x.plus("|" ).plus(row.joinToString("")).plus( "|\n")
        }
        x = x.plus(horizontalBorderLine("-", length))
        return x
    }

    fun horizontalBorderLine(char: String, length: Int):String = (char.repeat(length+2) + "\n")
}
