package com.example.ramenbm.domain.user.exception

import com.example.ramenbm.global.exception.RamenException
import com.example.ramenbm.global.exception.enumType.ErrorCode

class InvalidTokenException : RamenException(ErrorCode.INVALID_TOKEN)