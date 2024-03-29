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
//        println(convertToString())
    }

    // Example: canvas.addRectangle(14, 1, 18, 3);
    fun addRectangle(x1: Int, y1: Int, x2: Int, y2: Int) {
        // x1 = 14, y1 = 1, x2 = 18, y2 = 3

        println("$x1,$y1,$x2,$y2")
        println("start\n\n")

        //horizontal lines
        addLine(x1,y1,x2,y1) //14, 1, 18, 1
        addLine(x1,y2,x2,y2) //14, 3, 18, 3

        //vertical lines
        addLine(x1,y1,x1,y2) //14, 1, 14, 3
        addLine(x2,y1,x2,y2) //18, 1, 18, 3
    }

    // Todo("How to make C the default value for fill")
    fun fill(x: Int, y: Int, char: String, indent: String = ""){
        val inner_indent = indent.plus(">>")
        contents[y][x] = char
        println("------------------------------")
        println("$indent Fill with x: $x, y: $y")
        println("------------------------------")
        println(convertToString())

        println("checking x-1: ${x-1}")
        if(x-1 >= 0 && contents[y][x - 1] == " ") {
            fill(x-1, y, char, inner_indent)
        }

        println("checking y-1: ${y-1}")
        if(y-1 >= 0 && contents[y-1][x] == " ") {
            fill(x, y-1, char, inner_indent)
        }

        println("checking x+1: ${x+1}")
        if(x+1 < contents.first().size && contents[y][x + 1] == " ") {
            fill(x+1, y, char, inner_indent)
        }

        println("checking y+1: ${y+1}")
        if(y+1 < contents.size && contents[y+1][x] == " ") {
            fill(x, y+1, char, inner_indent)
        }
    }

    fun fillBfs(x: Int, y: Int, char: String){
        val queue = mutableListOf(Pair(x, y))
        val x_limit = contents.first().size
        val y_limit = contents.size
        while (queue.isNotEmpty()) {
            val it = queue.removeAt(0)
            val x1 = it.first
            val y1 = it.second
            contents[y1][x1] = char
            if((y1 + 1 < y_limit) && (contents[y1 + 1][x1] == " ")) { queue.add(Pair(x1, y1 + 1)) }
            if((y1 - 1  >= 0) && (contents[y1 - 1][x1] == " ")) { queue.add(Pair(x1, y1 - 1)) }
            if((x1 + 1 < x_limit) && (contents[y1][x1 + 1] == " ")) { queue.add(Pair(x1 + 1, y1)) }
            if((x1 - 1  >= 0) && (contents[y1][x1 - 1] == " ")) { queue.add(Pair(x1 - 1, y1)) }
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