class Fuente {
    var listaValores: MutableMap<String,String> = mutableMapOf()
    fun muestraObjeto(){
        for ((k,v )in listaValores){
            println("""
                $k ----- $v
            """.trimIndent())
        }
    }


}

