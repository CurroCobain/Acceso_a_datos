import java.io.File

class TempLineParam(file:File): LineParam(file) {
    var templistParams = mutableListOf<List<String>>()

    fun createListParams(){
        var templist = mutableListOf<List<String>>()
        val buff = this.file.bufferedReader()
        val tempLine: List<String> = buff.readLines()
        for (i in tempLine) {
            var line = i.split(",")
            templist.add(line)
        }
        templist.removeAt(0)
        templistParams = templist
    }
    fun filtrarListParams(head:HeadLineParams) {
        println("Elija el parámetro por el que desea filtrar:")
        println(head.show())
        val param = readln()
        println("Ingrese la información que desea buscar")
        var content = readln()
        val index = head.getIndex(param)
        val templist = mutableListOf<List<String>>()
        val buff = this.file.bufferedReader()
        val tempLine: List<String> = buff.readLines()
        for (i in tempLine) {
            var line = i.split(",")
            if (line[index].contains(content)){
                templist.add(line)
        }
    }
        templistParams = templist
    }

    override fun show(): String {
        var text = ""
        var tempText=""
        for (i in templistParams) {
            for(x in i){
                if(i.indexOf(x)> i.size-1){
                    break
                }else{
                    tempText += "$x "
                }
            }
            text+=" $tempText \n"
            tempText=""
        }
        return text
    }
}