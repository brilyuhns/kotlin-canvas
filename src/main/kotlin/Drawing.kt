class Drawing {
    fun execute(command: String, length: Int, height: Int):String {
        val canvas = if(command == "C"){
            Canvas(length, height)
        } else { Canvas(1, 1)  }
        return canvas.convertToString()
    }
}

