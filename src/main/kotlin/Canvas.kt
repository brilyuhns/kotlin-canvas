class Canvas(length: Int, height: Int){
    private var contents = Array(height) { Array(length){ " " } }

    fun convertToString(): String {
        val length = contents.first().size
        var x = horizontalBorderLine("-", length)
        for(row in contents){
            x = x.plus("|" ).plus(row.joinToString("")).plus( "|\n")
        }
        x = x.plus(horizontalBorderLine("-", length))
        return x
    }

    fun horizontalBorderLine(char: String, length: Int):String = (char.repeat(length+2) + "\n")

}