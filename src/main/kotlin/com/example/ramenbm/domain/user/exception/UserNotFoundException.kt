package com.example.ramenbm.domain.user.exception

import com.example.ramenbm.global.exception.RamenException
import com.example.ramenbm.global.exception.enumType.ErrorCode

class UserNotFoundException: RamenException(ErrorCode.USER_NOT_FOUND) {
}