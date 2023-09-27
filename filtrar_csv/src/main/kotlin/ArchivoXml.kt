import java.io.File

class ArchivoXml(val file: File, var head:HeadLineParams, var params:TempLineParam) {
    fun convertToXml(file:File) {
        println(
            """Indique qué desea hacer:
            1-> Convertir todo el archivo a xml 
            2-> filtrar el archivo y luego convertirlo
        """.trimIndent()
        )
        val answer = readln().toInt()
        var newXml = File("csv_to_xml.xml")
        newXml.createNewFile()
        when (answer) {
            1 -> {
                head.createListParams()
                params.createListParams()
            }

            2 -> {
                head.createListParams()
                params.filtrarListParams(head)
            }
        }
                var con = 0 // Esta variable nos ayudará en la escritura del archivo xml
            // Esta variable es una lista formada por los distintos elementos y atributos que la obtendremos más adelante
                var textoXml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n <rutas> \n " //creamos una variable String con el encabezamiento del archivo xml
                var cont = 0
            while(cont < head.listParams.size-1){
                var textAdd=""
                for(i in params.templistParams.indices){
                    for(x in params.templistParams[i].indices){
                        for(z in head.listParams.indices){
                            if(z < 1 && x == z){
                                textoXml+="     <registro>\n"
                                textoXml+="          <${head.listParams[z]}>${params.templistParams[i][x]}</${head.listParams[z]}>\n"
                                break
                            }
                            else if(z >= 1 && x == z && x != head.listParams.size-1){
                                textoXml+="          <${head.listParams[z]}>${params.templistParams[i][x]}</${head.listParams[z]}>\n"
                            }else if(z == head.listParams.size-1 && x == z){
                                textoXml+="          <${head.listParams[z]}>${params.templistParams[i][x]}</${head.listParams[z]}>\n"
                                textoXml+="     </registro>\n"
                                break
                            }
                        }
                    }
                }
                textoXml += "</rutas>" // Cerramos el texto con la etiqueta correspondiente
                newXml.writeText(textoXml) // sobreescribimos el archivo con el texto obtenido del archivo csv
                cont++
                break
            }
                    println("archivo xml creado con éxito")
        }
    }
