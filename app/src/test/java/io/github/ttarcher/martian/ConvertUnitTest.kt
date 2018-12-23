package io.github.ttarcher.martian

import org.junit.Assert.assertEquals
import org.junit.Test

class ConvertUnitTest {
    @Test
    fun mconvert_isCorrect() {
        assertEquals("恻鉽", "测试".mconvert())
        assertEquals("123", "123".mconvert())
        assertEquals("abc", "abc".mconvert())
    }
}
