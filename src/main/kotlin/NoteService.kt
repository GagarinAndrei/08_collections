object NoteService : CrudService<Note> {

    private var notesList = mutableListOf<Note>()

    override val elements: MutableList<Note>
        get() = notesList

    fun generateId(): Int {
        return if (notesList.isEmpty()) 1 else notesList.last().id + 1
    }

    override fun add(entity: Note): Boolean {
        notesList.add(entity)
        return true
    }

    override fun delete(id: Int): Boolean {
        for (note in notesList) {
            if (id == note.id) {
                note.isDelete = true
                return true
            }
        }
        return false
    }

    override fun read(): List<Note> {
        return notesList
    }

    override fun getById(id: Int): Note? = notesList.find { it.id == id }

    override fun restore(id: Int): Boolean {
        val deletedNote = getById(id)
        if (deletedNote != null) {
            if (deletedNote.isDelete) deletedNote.isDelete = false
            edit(deletedNote)
            return true
        }
        return false
    }

    override fun edit(entity: Note): Boolean {
        for ((index, note) in notesList.withIndex()) {
            if (note.id == entity.id) {
                notesList[index] = entity
                return true
            }
        }
        return false
    }
}
