import java.io.File
fun main() {
    val file = File("D:\\Programacion\\Programacion\\Segundo\\quijote.txt")
    fun palabraEncontrar(file: File, palabra: String) {
        val buff = file.bufferedReader()
        val lineas = buff.readLines()
        var numeroLínea = 1
        var repeticiones = 0
        for (x in lineas) {
            if (x.toLowerCase().contains(palabra.toLowerCase())) {
                println("$palabra numero de línea $numeroLínea")
                numeroLínea++
                repeticiones++
            } else {
                numeroLínea++
            }
        }
        println(repeticiones)
    }
    palabraEncontrar(file, "mancha")
}