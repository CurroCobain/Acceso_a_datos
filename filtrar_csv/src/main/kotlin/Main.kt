import java.io.File
fun main(args: Array<String>) {
    val file = File(args[0]) // obtenemos el nombre del archivo de los argumentos recibidos
    val obtenerDatos= args[1].split("=") // separamos el campo por el que vamos a buscar en el archivo
    val campoBuscar = obtenerDatos[0] // sacamos el campo por el que vamos a buscar
    var datoBuscar = obtenerDatos[1] // este sería una parte del dato que vamos a buscar ya que al venir con espacios el programa entiende que son argumentos diferentes
    for(i in args.indices){ // con esta función completamos el dato que vamos a buscar
        if(i > 1){
            datoBuscar+=" ${args[i]}"
        }
    }
    var buff = file.bufferedReader()
    val text : List<String> = buff.readLines()
    val listaBuscar = text[0].split(",")
    val indiceBuscar = listaBuscar.indexOf(campoBuscar)
    var listTemp = listOf<String>() // realizamos la búsqueda en el archivo y filtramos por el campo indicado
    for (linea in text){
        listTemp=linea.split(",")
        if (listTemp[indiceBuscar] contentEquals datoBuscar){ // con este bucle obtenemos las filas que coinciden con los campos de búsqueda
            println(linea)
        }
    }
}