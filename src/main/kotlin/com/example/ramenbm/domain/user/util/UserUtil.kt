package com.example.ramenbm.domain.user.util

import com.example.ramenbm.domain.user.entity.User

interface UserUtil {

    fun currentUser(): User

}