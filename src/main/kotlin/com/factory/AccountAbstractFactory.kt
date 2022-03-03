package com.factory

import com.data.BaseAccount
import com.data.enums.Cur
import com.data.enums.TypeAccount

interface AccountAbstractFactory {
    fun createAccount(cur: Cur, type : TypeAccount) : BaseAccount
}