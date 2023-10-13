class Archive(val title : String) : Titled{
    var notes : MutableList<Note> = mutableListOf()
    override fun showTitle(): String {
        return title
    }

    fun go(){
        val onCreate : () -> Unit = {
            val name = readNotEmptyLine("Введите название заметки:", "Пустое имя нелья!")
            val text = readNotEmptyLine("Введите содержание заметки:", "Пустое содержание нелья!")
            notes.add(Note(name, text))
        }

        val onOpen : (index : Int) -> Unit = { index ->
            notes[index].go()
        }

        MenuGenerator().generateMenu(MenuGenerator.ARCHIVE_MENU_TYPE, notes, onCreate, onOpen)
    }
}
