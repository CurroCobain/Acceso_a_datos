import java.io.File

class TempLineParam(file:File,index:Int, param:String): LineParam(file) {
    var templistParams = mutableListOf<List<String>>()

    init {
        var templist = mutableListOf<List<String>>()
        val buff = this.file.bufferedReader()
        val tempLine: List<String> = buff.readLines()
        for (i in tempLine) {
            var line = i.split(",")
            if (line[index].contains(param)){
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