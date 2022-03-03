package com.data

import com.data.enums.Cur

/**
 * task by data object
 */
data class Account (val acc: String, val cur: Cur){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Account

        if (acc != other.acc) return false
        if (cur!= other.cur) return false

        return true
    }

    override fun hashCode(): Int {
        var result = acc.hashCode()
        result = 31 * result + cur.hashCode()
        return result
    }


}