import java.io.File
import java.io.FileNotFoundException
import java.lang.IndexOutOfBoundsException

fun main(args: Array<String>) {
    try {
        val file = File(args[0]) //out\artifacts\filtrar_csv_jar\${args[0]} sustituir para probar en ide
        println("Bienvenido, ha elegido gestionar el archivo ${file.absolutePath}")
        println("""
            Elija qué desea hacer con el archivo:
            1-> Realizar una búsqueda
            2-> Convertir a xml
        """.trimIndent())
        var headParams = HeadLineParams(file)
        var lines = TempLineParam (file)
        var option = readln().toInt()
        when(option){
            1->{headParams.createListParams()
                lines.createListParams()
                headParams.show()
                lines.filtrarListParams(headParams)
                println(lines.show())}
            2->{headParams.createListParams()
                lines.createListParams()
                var newXml = ArchivoXml(file,headParams,lines)
                newXml.convertToXml(file)
            }
        }
    }catch (e:FileNotFoundException){
    println("Nombre de archivo no válido o incompleto")
    }
    catch (e:IndexOutOfBoundsException){
        println("Faltan parámetros o el comando está incompleto")
    }
}

//Línea para añadir al run "itinerarios.csv RECURSO_NOMBRE=Barrio de pescadores de Monte Gordo"
//java -jar filtrar_csv.jar itinerarios.csv RECURSO_NOMBRE=Barrio de pescadores
//java -jar filtrar_csv.jar itinerarios.csv DENOMINACION_RUTA=Ayamonte