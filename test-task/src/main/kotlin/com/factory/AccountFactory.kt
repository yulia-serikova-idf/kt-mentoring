package com.factory

import com.data.BaseAccount
import com.data.CreditAccount
import com.data.CurrentAccount
import com.data.enums.Cur
import com.data.enums.TypeAccount

class AccountFactory: AccountAbstractFactory {
    override fun createAccount(cur: Cur, type: TypeAccount): BaseAccount {
        return when (type) {
            TypeAccount.CURRENT -> CurrentAccount.Builder().cur(cur).build()
            TypeAccount.CREDIT -> CreditAccount.Builder().cur(cur).build()
            else -> BaseAccount.Builder().cur(cur).type(TypeAccount.BASE).build()
        }
    }
}