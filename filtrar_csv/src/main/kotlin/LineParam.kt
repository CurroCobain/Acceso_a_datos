import java.io.File
abstract class LineParam(file:File) {
    var file = file
    abstract fun show():String
}