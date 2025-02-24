class NoteApp(){
    val GrandArchive : MutableList<Archive> = mutableListOf()

    fun runApp(){
        val onCreate : () -> Unit = {
            val name = readNotEmptyLine("Введите название архива:", "Пустое название недопустимо!")
            GrandArchive.add(Archive(name))
            println("Архив с именем $name создан.")
        }

        val onOpen : (index : Int) -> Unit = { index ->
            GrandArchive[index].go()
        }
        MenuGenerator().generateMenu(MenuGenerator.GRAND_ARCHIVE_MENU_TYPE, GrandArchive, onCreate, onOpen)
    }
}