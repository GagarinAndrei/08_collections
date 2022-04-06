import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {

    @Test
    fun createComment() {
        //arrange
        val note = Note(
            title = "Some Title",
            text = "Some text"
        )
        val comment = Comment(
            1,
            "Some comment"
        )
        val (noteId) = note
        //act
        NoteService.addNote(note)
        val result = NoteService.createComment(noteId, comment)
        //assert
        assertTrue(result)
    }

    @Test
    fun deleteComment() {
        //arrange
        val note = Note(
            title = "Some Title",
            text = "Some text"
        )
        val comment = Comment(
            1,
            "Some comment"
        )
        val (noteId) = note
        val (commentId) = comment
        //act
        NoteService.addNote(note)
        NoteService.createComment(noteId, comment)
        val result = NoteService.deleteComment(noteId, commentId)
        //assert
        assertTrue(result)
    }

    @Test
    fun editComment() {
        //arrange
        val note = Note(
            title = "Some Title",
            text = "Some text"
        )
        val comment = Comment(
            1,
            "Some comment"
        )
        val newText = "New text"
        val (noteId) = note
        val (commentId) = comment
        //act
        NoteService.addNote(note)
        NoteService.createComment(noteId, comment)
        val result = NoteService.editComment(noteId, commentId, newText)
        //assert
        assertTrue(result)
    }

    @Test
    fun restoreComment() {
        //arrange
        val note = Note(
            title = "Some Title",
            text = "Some text"
        )
        val comment = Comment(
            1,
            "Some comment"
        )
        val (noteId) = note
        val (commentId) = comment
        //act
        NoteService.addNote(note)
        NoteService.createComment(noteId, comment)
        NoteService.deleteComment(noteId, commentId)
        val result = NoteService.restoreComment(noteId, commentId)
        //assert
        assertTrue(result)
    }

    @Test
    fun addNote() {
        //arrange
        val note = Note(
            title = "Some Title",
            text = "Some text"
        )
        //act
        NoteService.addNote(note)
        val result = NoteService.notesList.isNotEmpty()
        //assert
        assertTrue(result)
    }

    @Test
    fun deleteNote() {
        //arrange
        val note = Note(
            title = "Some Title",
            text = "Some text"
        )
        val (originalNoteId) = note
        //act
        NoteService.addNote(note)
        val result = NoteService.deleteNote(originalNoteId)
        //assert
        assertTrue(result)
    }

    @Test
    fun editNote() {
        //arrange
        val note = Note(
            title = "Some Title",
            text = "Some text"
        )
        val (originalNoteId) = note
        val newNote = Note(
            title = "New title",
            text = "new text"
        )
        //act
        NoteService.addNote(note)
        val result = NoteService.editNote(originalNoteId, newNote)
        //assert
        assertTrue(result)
    }
}