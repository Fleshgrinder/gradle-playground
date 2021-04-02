package com.fleshgrinder.gradle.playground

import java.util.Objects

public class SemVer(public val major: Int, public val minor: Int, public val patch: Int) : Comparable<SemVer> {
    init {
        require(major >= 0) { "major must be >= 0, got: $major" }
        require(minor >= 0) { "minor must be >= 0, got: $minor" }
        require(patch >= 0) { "patch must be >= 0, got: $patch" }
    }

    override fun compareTo(other: SemVer): Int =
        when {
            this === other -> 0
            major < other.major -> -1
            major > other.major -> 1
            minor < other.minor -> -1
            minor > other.minor -> 1
            patch < other.patch -> -1
            patch > other.patch -> 1
            else -> 0
        }

    override fun equals(other: Any?): Boolean =
        other === this || (other is SemVer && major == other.major && minor == other.minor && patch == other.patch)

    override fun hashCode(): Int =
        Objects.hash(major, minor, patch)

    override fun toString(): String =
        "$major.$minor.$patch"

    public companion object
}
