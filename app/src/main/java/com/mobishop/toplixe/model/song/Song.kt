import java.io.Serializable

data class Song(
    val active: Boolean,
    val authorid: Int,
    val createdate: Long,
    val id: Int,
    val img: String,
    val modifieddate: Long,
    val modifieduser: String,
    val range: Int,
    val songname: String,
    val uploadsource: String
): Serializable