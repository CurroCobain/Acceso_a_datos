import java.io.File
class HeadLineParams(file: File):LineParam(file) {
    var listParams= listOf<String>()
    var index = 0

    fun createListParams(file:File){
        val buff = this.file.bufferedReader()
        val tempLine: List<String> = buff.readLines()
        var cont = 0
        var listTemp = ""
        for (i in tempLine){
            if(cont < 1){
                listTemp+=i
                cont++
                }
            }
        listParams = listTemp.split(",")
        }
    fun getIndex(string:String):Int{
        for(i in listParams.indices){
            if(string == listParams[i]){
                this.index = i
            }
        }
        return index
    }

    override fun show():String {
        var text = ""
        for (i in listParams){
            text+= "$i "
        }
        return text
    }

    override fun toString(): String {
        return "${this.listParams}"
    }
}