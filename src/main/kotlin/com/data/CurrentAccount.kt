package com.data

import com.data.enums.Cur
import com.data.enums.StatusAccount
import com.data.enums.TypeAccount

class CurrentAccount(
    acc: String,
    cur: Cur,
    bal: Int,
    status: StatusAccount
) :
    BaseAccount(
        acc, cur, bal, status,
        type = TypeAccount.CURRENT
    ) {

    data class Builder(var cur: Cur? = null) {
        fun cur(cur: Cur) = apply { this.cur = cur }
        fun build() = BaseAccount.Builder().cur(cur).type(TypeAccount.CURRENT).build()
    }

}