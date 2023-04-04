package com.example.intentsevensolutionpro

// 해당 부분을 추가해야함
import java.io.Serializable
// 시리얼.. 로 톡톡톡.. 떨어진다 => 객체를 하나씩 나열시켜주는 것 (반드시 꼭 해야줘야함)
data class LonginData(val id: String, val pwd: String) : Serializable
