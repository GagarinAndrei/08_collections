data class Note(
    val id: Int = NoteService.generateId(),
    var title: String,
    var text: String,
    var isDelete: Boolean = false,
    var comments: MutableList<Comment> = mutableListOf()
)



