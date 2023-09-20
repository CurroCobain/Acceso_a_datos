import java.io.File
import java.util.*
fun main() {
    val file = File("D:\\Programacion\\Programacion\\Segundo\\quijote.txt")
    fun contarpalabras(file: File) { //Creamos una función que nos permitirá contar las palbras de cualquier archivo .txt
        var total = 0 //iniciamos los valores que vamos a necesitar e la hora de calcular el número de palabras
        var repeticiones = 0
        println("Resultado BufferedReader")
        while (repeticiones < 100) { // creamos un bucle se 100 repeticiones para alcanzar la velocidad máxima
            val buff = file.bufferedReader()
            val lineas = buff.readLines()
            var begin = System.currentTimeMillis() //creamos una variable para marcar el inicio del proceso
            for (i in lineas) {
                val listaLinea = i.split(" ")
                total += listaLinea.size
            } // dividimos el archivo en líneas y las transformamos en listas para poder calcular el total de palabras por línea
            var end = System.currentTimeMillis() //creamos la variable end para marcar el fin del proceso
            repeticiones++
            if (repeticiones == 100) {
                println(total / 100) // imprimimos el total de palabras dividido por el número de repeticiones del bucle
                println(end - begin) // imprimimos el tiempo de duración del proceso
            }
        }
    }
    contarpalabras(file)
    fun contarpalabrasScanner(file: File) {
        println("Resultado Scanner")
        val sc = Scanner(file)
        var total = 0
        var repeticiones = 0
        while (repeticiones < 100) {
            var begin = System.currentTimeMillis()
            while (sc.hasNextLine()) {
                val line = sc.nextLine().split(" ")
                var totalPalabrasPorLinea = line.size
                total += totalPalabrasPorLinea
            }
            var end = System.currentTimeMillis()
            repeticiones++
            if (repeticiones == 100) {
                println(total) // imprimimos el total de palabras dividido por el número de repeticiones del bucle
                println(end - begin) // imprimimos el tiempo de duración del proceso
            }

        }
    }
    contarpalabrasScanner(file)
}


/*
Tras comprobar que nuestro programa funciona, usamos las funcionalidades del IDE para crear el archivo tipo .jar y lo ejecutamos
en la línea de comandos con resultado satisfactorio.
 */


