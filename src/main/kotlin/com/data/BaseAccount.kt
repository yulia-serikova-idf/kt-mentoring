package com.data

import com.data.enums.Cur
import com.data.enums.StatusAccount
import com.data.enums.TypeAccount

open class BaseAccount(
    protected val acc: String,
    protected val cur: Cur?,
    protected val bal: Int,
    protected val status: StatusAccount,
    protected val type: TypeAccount?
) {

    data class Builder(var cur: Cur? = null, var type: TypeAccount? = null) {
        fun cur(cur: Cur?) = apply { this.cur = cur }
        fun type(type: TypeAccount) = apply { this.type = type }
        //RandomStringUtils.randomNumeric(14)
        fun build() = BaseAccount("1234", cur, 0, StatusAccount.BLOCKED, type)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BaseAccount

        if (acc != other.acc) return false
        if (cur != other.cur) return false
        if (status != other.status) return false
        if (type != other.type) return false
        return true
    }

    override fun hashCode(): Int {
        var result = acc.hashCode()
        result = 31 * result + cur.hashCode() + status.hashCode() + type.hashCode()
        return result
    }

    override fun toString(): String {
        return "Account(acc='$acc', cur=$cur, bal=$bal, status=$status, type=$type)"
    }

}