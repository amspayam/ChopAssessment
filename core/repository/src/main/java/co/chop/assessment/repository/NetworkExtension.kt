package co.chop.assessment.repository


sealed class ResultModel<out V> {

    data class Success<V>(val value: V) : ResultModel<V>()

    data class Error(val error: String) : ResultModel<Nothing>()
}

inline fun <R, T> ResultModel<T>.executeUseCase(
    ifSuccess: (value: T) -> R,
    ifError: (error: String) -> R
): R {
    return when (this) {
        is ResultModel.Success<T> -> ifSuccess(value)
        is ResultModel.Error -> ifError(error)
    }
}

fun <T, R> ResultModel<T>.map(isSuccess: (T) -> R): ResultModel<R> {
    return when (this) {
        is ResultModel.Success -> ResultModel.Success(isSuccess.invoke(value))
        is ResultModel.Error -> ResultModel.Error(error)
    }
}