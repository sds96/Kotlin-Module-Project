import java.lang.Exception
import java.util.Scanner

class MenuGenerator {
    private var header : String = ""
    private var name_element : String = ""
    private var ending : String = ""
    fun <T : Titled> generateMenu(
        type : String,
        list : List<T>,
        onCreate: () -> Unit,
        onOpen: (index : Int) -> Unit)
    {
        while(true){
            println(BORDER)
            when (type){
                GRAND_ARCHIVE_MENU_TYPE -> {
                    header = "Меню архивов:\n0. Создать архив"
                    name_element = "архив"
                    ending = "Закончить работу"
                }
                ARCHIVE_MENU_TYPE ->{
                    header = "Меню управления архивом.\n0. Создать заметку"
                    name_element = "заметку"
                    ending = "Вернуться к выбору архивов"
                }
                NOTE_MENU_TYPE -> {
                    header = "Меню управления заметкой. \n0. Посмотреть заметку"
                    ending = "Вернуться к выбору заметок"
                }
            }

            println(header)
            if(list.isEmpty()){
                println("1. $ending")
            } else{
                list.forEachIndexed{index, element -> println("${index+1}. Выбрать $name_element '${element.showTitle()}'")}
                println("${list.size+1}. $ending")
            }

            println(BORDER)
            println("Выберите действие путём ввода цифры:")
            try{
                val input = Scanner(System.`in`).nextInt()
                when(input){
                    0 -> onCreate()
                    in 1..list.size -> onOpen(input-1)
                    list.size+1 -> break
                    else -> println("Ошибка номера! Введите правильное число.")
                }
            }
            catch (e: Exception){
                println("Ошибка ввода! Введите число.")
                continue
            }
        }
    }
    companion object MenuType {
        const val GRAND_ARCHIVE_MENU_TYPE = "GRAND_ARCHIVE"
        const val ARCHIVE_MENU_TYPE = "ARCHIVE"
        const val NOTE_MENU_TYPE = "NOTE"
        const val BORDER = "========================================"
    }
}