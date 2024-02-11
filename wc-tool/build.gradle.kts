plugins {
    application
    kotlin("jvm") version "1.9.22"
}

group = "com.miguelromero717.wc_tool"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("com.miguelromero717.wc_tool.WCToolMainKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}