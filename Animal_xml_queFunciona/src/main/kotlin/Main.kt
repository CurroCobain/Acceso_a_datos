import java.io.File
import javax.xml.bind.JAXBContext
import javax.xml.bind.JAXBException
import javax.xml.bind.Marshaller
import javax.xml.bind.PropertyException

fun main(args: Array<String>) {
    // try {

    val coo = Coordenada(1,2)
    val coo1 = Coordenada(3,4)
    val coo3 = Coordenada(5,7)
    val miPerro2 = Cachorro()
    miPerro2.id = "auuu"
    miPerro2.nombre = "Aisha"
    miPerro2.nombrePropietario = "Manolo"
    miPerro2.coordenada += coo
    miPerro2.coordenada += coo1
    miPerro2.edad= 1
    miPerro2.nombreCachorro = "Leo"
    miPerro2.vacuna+="Rabia"
    miPerro2.vacuna+="Mosquito"

    val miPerro = Animal()
    miPerro.id = "guau"
    miPerro.nombre = "Leo"
    miPerro.nombrePropietario = "Curro"
    miPerro.coordenada += coo
    miPerro.coordenada += coo3
    miPerro.cachorro = miPerro2

    val contexto: JAXBContext = JAXBContext.newInstance(miPerro.javaClass)
    val marshaller = contexto.createMarshaller()
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)
    val file: File = File("./animales.xml")
    // guardar perro
    marshaller.marshal(miPerro, file)
    //recuperar
    val unmarshaller = contexto.createUnmarshaller()
    val animal_xml = unmarshaller.unmarshal(File("./animales.xml")) as Animal
    animal_xml.imprimirDatos()


    /*
        } catch (e: PropertyException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        } catch (e: JAXBException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }

     */
}