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
//        val (noteId) = note
        //act
        NoteService.add(note)
        val result = CommentService.add(comment)
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
//        val (noteId) = note
        val (commentId) = comment
        //act
        NoteService.add(note)
        CommentService.add(comment)
        val result = CommentService.delete(commentId)
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
        val newComment = Comment(1,
            "New text"
        )
        //act
        NoteService.add(note)
        CommentService.add(comment)
        val result = CommentService.edit(newComment)
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
        val (commentId) = comment
        //act
        NoteService.add(note)
        CommentService.add(comment)
        CommentService.delete(commentId)
        val result = CommentService.restore(commentId)
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
        NoteService.add(note)
        val result = NoteService.elements.isNotEmpty()
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
        NoteService.add(note)
        val result = NoteService.delete(originalNoteId)
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
            id = originalNoteId,
            title = "New title",
            text = "new text"
        )
        //act
        NoteService.add(note)
        val result = NoteService.edit(newNote)
        //assert
        assertTrue(result)
    }
}