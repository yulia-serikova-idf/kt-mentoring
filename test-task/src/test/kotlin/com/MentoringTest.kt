package com

import com.data.Account
import com.data.enums.Cur
import com.data.enums.TypeAccount
import com.factory.AccountFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MentoringTest {

//    task by singleton
    @Test
    fun compare_singleton_by_class() {
        val obj = ClassSingleton.getInst()
        val obj1 = ClassSingleton.getInst()
        Assertions.assertTrue(obj === obj1)

    }
    //    task by dto
    @Test
    fun compare_data_objects() {
        val accByn1 = Account("BYAKBB123456", Cur.BYN)
        val accByn2 = Account("BYAKBB123456", Cur.BYN)
        val accCur2 = Account("BYAKBB123456", Cur.USD)

        Assertions.assertEquals(accByn1, accByn2)
        Assertions.assertTrue(accByn1.equals(accByn2))
        Assertions.assertFalse(accByn1.equals(accCur2))
    }

    //    task by factory
    @Test
    fun compare_accounts() {
        val accCred = AccountFactory().createAccount(Cur.BYN, TypeAccount.CREDIT)
        val accCurr = AccountFactory().createAccount(Cur.BYN, TypeAccount.CURRENT)
        println(accCred.toString())
        println(accCurr.toString())
        Assertions.assertFalse(accCred.equals(accCurr))
    }



}