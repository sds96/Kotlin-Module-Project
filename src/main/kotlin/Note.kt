class Note(val title: String, val text: String = "") : Titled{
    override fun showTitle(): String {
        return title
    }

    fun go(){
        val onCreate : () -> Unit = {
            println(MenuGenerator.BORDER)
            println("Открыта заметка '${title}', её содержание:\n$text")
            println(MenuGenerator.BORDER)
            readNotEmptyLine("Введите любой символ, чтобы закрыть заметку", "")
        }
        val onOpen: (index :Int) -> Unit = {}

        MenuGenerator().generateMenu(MenuGenerator.NOTE_MENU_TYPE, emptyList(), onCreate, onOpen)
    }
}
