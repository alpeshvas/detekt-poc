import org.gradle.kotlin.dsl.test
import org.gradle.kotlin.dsl.testImplementation

plugins {
    id("java")
    kotlin("jvm") version "2.0.0"
}

group = "com.detekt.poc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}