import java.io.File
class HeadLineParams(file: File):LineParam(file) {
    var listParams= listOf<String>()
    var index = 0

    override fun createListParams(file:File){
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
        var index = 0
        for(i in listParams.indices){
            if(string == listParams[i]){
                index = i
            }
        }
        return index
    }

    override fun toString(): String {
        return "${this.listParams}"
    }
}