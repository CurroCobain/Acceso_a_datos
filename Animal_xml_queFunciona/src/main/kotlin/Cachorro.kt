
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlElementWrapper
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlType
@XmlRootElement
@XmlType(propOrder = ["nombreCachorro","edad","vacuna"])
class Cachorro(): Animal() {
    @get:XmlElement(name =  "nombreCachorro")
    var nombreCachorro = "un nombre"
    @get:XmlElement(name = "edad")
    var edad = 0
    @get:XmlElementWrapper(name = "vacunas")
    var vacuna = arrayListOf<String>()
}