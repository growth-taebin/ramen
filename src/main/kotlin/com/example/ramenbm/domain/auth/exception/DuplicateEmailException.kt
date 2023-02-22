package com.example.ramenbm.domain.auth.exception

import com.example.ramenbm.global.exception.RamenException
import com.example.ramenbm.global.exception.enumType.ErrorCode

class DuplicateEmailException: RamenException(ErrorCode.DUPLICATE_EMAIL)