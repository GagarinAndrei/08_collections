object CommentService : CrudService<Comment> {

    private var commentList = mutableListOf<Comment>()

    override val elements: MutableList<Comment>
        get() = commentList

    override fun add(entity: Comment): Boolean {
        commentList.add(entity)
        return true
    }

    override fun delete(id: Int): Boolean {
        for (comment in commentList) {
            if (id == comment.id) {
                comment.isDelete = true
                return true
            }
        }
        return false
    }

    override fun edit(entity: Comment): Boolean {
        for ((index, note) in commentList.withIndex()) {
            if (note.id == entity.id) {
                commentList[index] = entity
                return true
            }
        }
        return false
    }

    override fun read(): List<Comment> {
        return commentList
    }

    override fun getById(id: Int): Comment? = commentList.find { it.id == id }

    override fun restore(id: Int): Boolean {
        val deletedComment = getById(id)
        if (deletedComment != null) {
            if (deletedComment.isDelete) deletedComment.isDelete = false
            edit(deletedComment)
            return true
        }
        return false
    }
}
