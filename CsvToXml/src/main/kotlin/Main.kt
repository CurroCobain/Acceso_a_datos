import java.io.File
fun main() {
    /*
    Primero vamos a crear las distintas variables y objetos que vamos a necesitar para la transformación a XML
     */
    val file = File("D:\\Programacion\\Segundo\\AccesoAdatos\\CsvToXml\\fuentesmascotas202309.csv")
    //creamos el objeto file
    val buff = file.bufferedReader()
    //creamos buff mediante el método de la clase File-> bufferedReader()
    var newXml = File("D:\\Programacion\\Segundo\\AccesoAdatos\\CsvToXml\\fuentesmascotasXML.xml")
    newXml.createNewFile()
    // creamos el objeto newXml y con el método createNewFile() creamos el archivo xml
    var con = 0 // Esta variable nos ayudará en la escritura del archivo xml
    var listaCampos = mutableListOf<String>()
    // Esta variable es una lista formada por los distintos elementos y atributos que la obtendremos más adelante
    var textoXml="<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n <FUENTES> \n " //creamos una variable String con el encabezamiento del archivo xml
    for (linea in buff.readLines()) {
        var listaValores = mutableListOf<String>()// Lista que usaremos para ir añadiendo el contenido de las distintas etiquetas del xml
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
            for(j in listaValores.indices){
                if(x == 0){
                    textoXml+="          "+"<FUENTE> \n" +"                    "+"<${listaCampos[0]}> ${listaValores[0]} </${listaCampos[0]}> \n"
                    break
                }
                else if(x == j){
                    textoXml+="                    "+"<${listaCampos[x]}> ${listaValores[j]} </${listaCampos[x]}> \n"
                }
                else if(x == listaCampos.size-1){
                    textoXml+="           </FUENTE>\n "
                    break
                }
            }
        }//Con este bucle obtenemos y añadimos al texto los distintos campos y valores del archivo csv y los añadimos al texto que escribiremos en el xml
    }
    textoXml+="</FUENTES> " // Cerramos el texto con la etiqueta correspondiente
    newXml.writeText(textoXml) // sobreescribimos el archivo con el texto obtenido del archivo csv
}


