import java.awt.Menu
import java.util.Scanner
import java.util.concurrent.TimeoutException

class Archive(val title : String) : Titled{
    var notes : MutableList<Note> = mutableListOf()
    override fun showTitle(): String {
        return title
    }

    fun go(){
        val onCreate : () -> Unit = {
            var name :String
            var text : String
            while(true){
                println("Введите название заметки:")
                name = Scanner(System.`in`).nextLine()
                if (name.isEmpty()){
                    println("Пустое имя нелья!")
                } else  {
                    break
                }
            }

            while(true){
                println("Введите содержание заметки:")
                text = Scanner(System.`in`).nextLine()
                if (text.isEmpty()){
                    println("Пустое содержание нелья!")
                } else  {
                    break
                }
            }
            notes.add(Note(name, text))
        }

        val onOpen : (index : Int) -> Unit = { index ->
            notes[index].go()
        }

        MenuGenerator().generateMenu(MenuGenerator.ARCHIVE_MENU_TYPE, notes, onCreate, onOpen)
    }
}
