class Canvas(length: Int, height: Int){
    private var contents = Array(height) { Array(length){ " " } }.toList()


    fun sortedCoordinates(a: Int, b: Int ): List<Int>{
       val x = arrayListOf(a, b)
        x.sort()
        return  x
    }

    fun addLine(x1: Int, y1: Int, x2: Int, y2: Int) {
        println("$x1,$y1,$x2,$y2")

        if (y1 == y2) {
            println("same y co-ordinates")
            val (startX: Int, endX: Int) = sortedCoordinates(x1, x2)
//            println("sorted X: $startX, $endX")
            val y = y1 - 1
            var x = startX - 1
//            println("checking $x against ${endX-1}")
            while (x <= endX - 1) {
//                println("Plotting $y, $x")
                contents[y][x] = "x"
                x += 1
//                println("checking $x against ${endX-1}")
            }
        }
        if (x1 == x2) {
            val (startY: Int, endY: Int) = sortedCoordinates(y1, y2)
            val x = x1 - 1
            var y = startY - 1
            while (y <= endY - 1) {
//                println("Plotting $y, $x")
                contents[y][x] = "x"
                y += 1
//                println("checking $y against ${endY-1}")
            }
        }
        println(convertToString())
    }

    fun convertToString(): String {
        val length = contents.first().size
        var x = horizontalBorderLine("-", length)
        for(row in contents ){
            x = x.plus("|" ).plus(row.joinToString("")).plus( "|\n")
        }
        x = x.plus(horizontalBorderLine("-", length))
        return x
    }
    fun horizontalBorderLine(char: String, length: Int):String = (char.repeat(length+2) + "\n")

}