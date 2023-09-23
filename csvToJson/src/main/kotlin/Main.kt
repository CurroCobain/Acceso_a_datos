import java.io.File
    fun main() {
        val tiempoInicio = System.currentTimeMillis()
        val csv = File("D:\\Programacion\\Segundo\\AccesoAdatos\\csvToJson\\fuentesmascotas202309.csv")
        val bufferedReader = csv.bufferedReader()
        var json_csv = File("D:\\Programacion\\Segundo\\AccesoAdatos\\csvToJson\\json_csv.json")
        var json_csv_text = ""
        var listaCampos = mutableListOf<String>()
        var con = 0
        json_csv_text += "{ \n "
        json_csv_text += "   \"Customers_Index\":[\n"
        for (linea in bufferedReader.readLines()){
            var listaValores = mutableListOf<String>()
            if (con < 1) {
                for (i in linea.split(";")) {
                    listaCampos.add(i) //obtenemos los campos y atributos de la primera fila del archivo csv
                    con++
                }
            } else if(con >= 1) {
                for (i in linea.split(";")) { // de cada linea obtenemos el contenido de las etiquetas
                    listaValores.add(i)
                }
            }
            for (x in listaCampos.indices){
                for (j in listaValores.indices){
                    if (x == j && x == 1){
                        json_csv_text +="            {\"${listaCampos[x]}\""+":"+ listaValores[j] +",\n"
                    }
                    else if(x == j && x < 23 && x > 1){
                        json_csv_text +="            \"${listaCampos[x]}\""+":"+ listaValores[j] +",\n"
                    }else if (x == listaCampos.size-1 && j == listaValores.size-1){
                        json_csv_text +="            \"${listaCampos[x]}\""+":"+ listaValores[j] +",\n"
                        json_csv_text += "            },\n"
                    }
                }
            }
        }
        json_csv_text=json_csv_text.substring(0,json_csv_text.length-2)
        json_csv_text += "\n     ]\n"
        json_csv_text += "}"
        println(json_csv_text)
        json_csv.writeText(json_csv_text)

        val tiempoFin = System.currentTimeMillis()
        val tiempoTotal = tiempoFin-tiempoInicio
        println("El tiempo es de "+ tiempoTotal + " milisegundos")
    }

