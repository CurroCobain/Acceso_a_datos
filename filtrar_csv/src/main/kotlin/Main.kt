import java.io.File
import java.io.FileNotFoundException
import java.lang.IndexOutOfBoundsException

fun main(args: Array<String>) {
    try {
        val file = File(args[0]) //out\artifacts\filtrar_csv_jar\${args[0]} sustituir para probar en ide
        println(file.absolutePath)// obtenemos el nombre del archivo de los argumentos recibidos
        val obtenerDatos= args[1].split("=") // separamos el campo por el que vamos a buscar en el archivo
        val campoBuscar = obtenerDatos[0] // sacamos el campo por el que vamos a buscar
        var datoBuscar = obtenerDatos[1] // este sería una parte del dato que vamos a buscar ya que al venir con espacios el programa entiende que son argumentos diferentes
        for(i in args.indices){ // con esta función completamos el dato que vamos a buscar
            if(i > 1){
                datoBuscar+=" ${args[i]}"
            }
        }
       var headParams = HeadLineParams(file)
        headParams.createListParams(file)
        println(headParams.toString())
        val indexSearch= headParams.getIndex(campoBuscar)
        var lines = TempLineParam (file,indexSearch,datoBuscar)
        println(lines.show())

    }catch (e:FileNotFoundException){
    println("Nombre de archivo no válido o incompleto")
    }
    catch (e:IndexOutOfBoundsException){
        println("Faltan parámetros o el comando está incompleto")
    }
}

//Línea para añadir al run "itinerarios.csv RECURSO_NOMBRE=Barrio de pescadores de Monte Gordo"