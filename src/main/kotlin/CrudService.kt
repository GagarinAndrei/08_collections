interface CrudService<T> {
    val elements: MutableList<T>

    fun add(entity: T): Boolean
    fun delete(id: Int): Boolean
    fun edit(entity: T): Boolean
    fun read(): List<T>
    fun getById(id: Int): T?
    fun restore(id: Int): Boolean
}