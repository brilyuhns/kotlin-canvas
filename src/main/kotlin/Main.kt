fun main() {
    printHelp()
    printInputPrompt()
    var input = readLine()
    var canvas: Canvas? = null
    while(input != "Q"){
        println(input)
        if (input != null) {
            canvas = execute(canvas, input)
            println("printing canvas")
            println(canvas?.convertToString())
        }
        printInputPrompt()
        input = readLine()
    }
}

fun execute(canvas: Canvas?, input: String): Canvas?{
    val command = input.split(" ").first()
    when (command) {
        "C" -> {
            return createCanvas(input)
        }
        "L" -> {
            if(canvas != null) {
                addLine(canvas, input)
            } else {
                println("Create a canvas first")
            }
            return canvas
        }
        "R" -> {
            if(canvas != null) {
                addRectangle(canvas, input)
            } else {
                println("Create a canvas first")
            }
            return canvas
        }
        else ->{
            printUnknownInput()
        }
    }
    return canvas
}

fun createCanvas(input: String): Canvas{
    val args = input.split(" ")
    return Canvas(args[1].toInt(), args[2].toInt())
}

fun addLine(canvas: Canvas, input: String){
//    TODO("Check if the method can just accept an array")
//    TODO("Consider validations")
    val args = input.split(" ").takeLast(4).map { it.toInt() }
    canvas.addLine(args[0], args[1], args[2], args[3])
}

fun addRectangle(canvas: Canvas, input: String){
//    TODO("Check if the method can just accept an array")
//    TODO("Consider validations")
    val args = input.split(" ").takeLast(4).map { it.toInt() }
    canvas.addRectangle(args[0], args[1], args[2], args[3])
}

fun printUnknownInput() {
    println("Unknown input\n Press h for a list of commands")
}

fun printInputPrompt(){
    println("\nInput your command")
//    print("$")
}
fun printHelp(){
    println("Command \t\tDescription\n" +
            "C w h           Should create a new canvas of width w and height h.\n" +
            "L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only\n" +
            "                horizontal or vertical lines are supported. Horizontal and vertical lines\n" +
            "                will be drawn using the 'x' character.\n" +
            "R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and\n" +
            "                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn\n" +
            "                using the 'x' character.\n" +
            "B x y c         Should fill the entire area connected to (x,y) with \"colour\" c. The\n" +
            "                behavior of this is the same as that of the \"bucket fill\" tool in paint\n" +
            "                programs.\n" +
            "Q               Should quit the program.")
}