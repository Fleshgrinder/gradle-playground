package com.fleshgrinder.gradle.playground

import kotlin.test.Test
import kotlin.test.assertSame

private class SemVerTest {
    @Test fun `default is all zeros`() {
        val v = SemVer.default()
        assertSame(0, v.major)
        assertSame(0, v.minor)
        assertSame(0, v.patch)
    }
}
