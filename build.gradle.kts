import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    `java-test-fixtures`
    kotlin("jvm") version "1.4.30"
}

dependencies {
    implementation(kotlin("bom"))
    implementation(kotlin("stdlib-jdk8"))

    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit5"))
    testImplementation(platform("org.junit:junit-bom:5.7.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

repositories {
    mavenCentral()
}

kotlin {
    explicitApi()
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        allWarningsAsErrors = true
        jvmTarget = file(".java-version").readText().trim()
        useIR = true
    }
}

tasks.test {
    useJUnitPlatform()
    systemProperty("java.io.tmpdir", temporaryDir.absolutePath)
}
