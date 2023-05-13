package com.example.core.util

class NetworkErrorMapper {

    fun mapThrowable(throwable: Throwable): AppException {
        return UnexpectedException(
            code = UNEXPECTED,
            message = "$throwable",
            throwable = throwable
        )
    }

    fun mapServerError(
        errorCode: Int?,
        errorMessage: String? = null,
        errorBody: String? = null,
        throwable: Throwable
    ): AppException {

        // TODO Handle more errors and timeout - no connection ...etc
        return AppException(
                errorCode = errorCode ?: UNEXPECTED,
                errorMessage = errorMessage
                    ?: "The application has encountered an unknown error",
                errorBody = errorBody,
                throwable = throwable
            )
        }

    companion object {
        private const val TIME_OUT = -100
        private const val NO_CONNECTION = -101
        private const val UNEXPECTED = -102
        private const val UNAUTHORIZED = 30001
    }
}
open class AppException(
    val errorCode: Int= 0 ,
    val errorMessage: String? = null,
    val errorBody: String? = null,
    val throwable: Throwable? = null
) : Throwable(errorMessage)


class NoConnectionException(code: Int = 0 , message: String? = null) :
    AppException(errorCode = code, errorMessage = message)

class TimeOutException(code: Int= 0 , message: String? = null) :
    AppException(errorCode = code, errorMessage = message)

class UnexpectedException(code: Int, message: String, throwable: Throwable) :
    AppException(errorCode = code, errorMessage = message, throwable = throwable)

class UnAuthorizedException(code: Int, message: String, throwable: Throwable) :
    AppException(errorCode = code, errorMessage = message, throwable = throwable)