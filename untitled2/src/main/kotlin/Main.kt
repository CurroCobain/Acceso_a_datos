import org.w3c.dom.Document
import org.w3c.dom.Element
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

fun main(args: Array<String>) {

    // Crear un nuevo documento XML
    val doc = crearDocumentoXML()
    val leer = File("fuentesmascotas202309.csv")
    var buff = leer.bufferedReader()
    var cont = 0
    val listaCampos = mutableListOf<String>()
    val listaInfo = mutableListOf<MutableList<String>>()
    for (i in buff.readLines()) {
        var listaProv = mutableListOf<String>()
        if (cont == 0) {
            for (x in i.split(";"))
                listaCampos.add(x.replace("\uFEFF",""))
            cont++
        } else {
            for (z in i.split(";")) {
                listaProv.add(z)
            }
            listaInfo.add(listaProv)
        }
    }

    val rootElement = doc.createElement("root")
    doc.appendChild(rootElement)
    for (x in listaInfo) {
        val entrada = doc.createElement("fuente")
        rootElement.appendChild(entrada)
        for (z in x.indices) {
            val elemento1 = doc.createElement(listaCampos[z])
            elemento1.textContent = x[z].replace("\"", "")
            entrada.appendChild(elemento1)

        }
    }
    // Guardar el documento XML en un archivo
    guardarDocumentoXML(doc, "archivo.xml")
    // xml creado

    // Crear elementos y agregarlos al documento
    /*val rootElement = doc.createElement("root")
    doc.appendChild(rootElement)

    val elemento1 = doc.createElement("elemento1")
    elemento1.textContent = "Contenido del elemento 1"  Métodos útiles, no borrar
    rootElement.appendChild(elemento1)

    val elemento2 = doc.createElement("elemento2")
    elemento2.textContent = "Contenido del elemento 2"
    rootElement.appendChild(elemento2)
*/

// Leer xml y construir objetos
    val listaObjetos = mutableListOf<Fuente>()
    var elements = doc.documentElement
    for (node in 0 until elements.childNodes.length){
        var elem = elements.childNodes.item(node)
        var newFuente = Fuente()
        for (element in 0 until elem.childNodes.length ){
            newFuente.listaValores[elem.childNodes.item(element).toString()] = elem.childNodes.item(element).textContent
        }
        listaObjetos.add(newFuente)
    }
// mostramos lista de objetos     
    for (i in listaObjetos){
        println("------------------------------------------------------------------")
        println(i.toString())
        i.muestraObjeto()
}
}

    fun crearDocumentoXML(): Document {
        val factory = DocumentBuilderFactory.newInstance()
        val builder = factory.newDocumentBuilder()
        return builder.newDocument()
    }

    fun guardarDocumentoXML(doc: Document, nombreArchivo: String) {
        val transformerFactory = TransformerFactory.newInstance()
        val transformer: Transformer = transformerFactory.newTransformer()
        transformer.setOutputProperty("indent", "yes") // Habilitar la indentación
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2") // Espacios de indentación
        val source = DOMSource(doc)
        val result = StreamResult(File(nombreArchivo))
        transformer.transform(source, result)
        println("Archivo XML guardado como $nombreArchivo")
    }

