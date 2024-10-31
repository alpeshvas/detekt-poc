plugins {
    id("io.gitlab.arturbosch.detekt") version "1.23.7"
    kotlin("jvm") version "2.0.0"
}

apply(plugin = "kotlin")

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("io.gitlab.arturbosch.detekt:detekt-api:1.23.7")
    detektPlugins(project(":detekt-common-config"))
    testImplementation("io.gitlab.arturbosch.detekt:detekt-test:1.20.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.8.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(kotlin("stdlib-jdk8"))
}
tasks.test {
    useJUnitPlatform()
}
