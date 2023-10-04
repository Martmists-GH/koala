plugins {
    kotlin("jvm") version "1.9.10"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("reflect"))

    testImplementation(kotlin("test"))
}
