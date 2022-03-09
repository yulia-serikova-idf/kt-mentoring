package com

class ClassSingleton private constructor() {
    companion object {
        @Volatile
        private var inst: ClassSingleton? = null

        fun getInst(): ClassSingleton? {
            if (inst == null) {
                synchronized(this) {
                    if (inst == null) {
                        inst = ClassSingleton()
                    }
                }
            }
            return inst
        }

//        @Synchronized
//        fun getInst(): ClassSingleton? {
//            if (inst == null) {
//                inst = ClassSingleton()
//            }
//            return inst
//        }

    }
}