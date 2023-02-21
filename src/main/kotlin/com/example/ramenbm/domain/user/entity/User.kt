package com.example.ramenbm.domain.user.entity

import com.example.ramenbm.domain.auth.presentation.data.enumType.Authority
import javax.persistence.*

@Entity
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        val email: String,
        val password: String,
        val name: String,
        val discord: String,
        @Enumerated(EnumType.STRING)
        @ElementCollection
        @CollectionTable(name = "user_authority")
        val authority: MutableList<Authority>
)