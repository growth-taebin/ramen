package com.example.ramenbm.domain.ramen.exception

import com.example.ramenbm.global.exception.RamenException
import com.example.ramenbm.global.exception.enumType.ErrorCode

class RamenTradeNotFoundException : RamenException(ErrorCode.RAMEN_TRADE_NOT_FOUND)