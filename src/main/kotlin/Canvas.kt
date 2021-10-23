class Canvas {
    fun execute(command: String, length: Int, height: Int):String {
        val x = if(command == "C"){
            emptyCanvas(length, height)
        } else { "" }
        return x
    }

    fun emptyCanvas(length: Int, height: Int): String {
        val arr = Array(height) { Array(length){ " " } }
        var x = horizontalBorderLine("-", length)
        for(row in arr){
            x = x.plus("|" ).plus(row.joinToString("")).plus( "|\n")
        }
        x = x.plus(horizontalBorderLine("-", length))
        return x
    }

    fun horizontalBorderLine(char: String, length: Int):String = (char.repeat(length+2) + "\n")
}
