package com.example.ramenbm.global.exception

import com.example.ramenbm.global.exception.enumType.ErrorCode

open class RamenException(val errorCode: ErrorCode) : RuntimeException(errorCode.message)