
import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlElementWrapper
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlType


@XmlRootElement
@XmlType(propOrder = ["nombre", "nombrePropietario","coordenada","cachorro"])
open class Animal() {
    @get:XmlAttribute(name = "id")
    var id: String? = null
    @get:XmlElement(name =  "nombre")
    var nombre = "sin nombre"

    @get:XmlElement(name = "nombrePropietario")
    var nombrePropietario = "sin nombre"

    @get:XmlElementWrapper(name = "coordenadas")
    var coordenada = arrayListOf<Coordenada>()

    @get:XmlElement(name = "cachorro")
    var cachorro:Cachorro? = null
    fun imprimirDatos() {
        println("El nombre del animal es: $nombre")
    }
}