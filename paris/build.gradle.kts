plugins {
    java
    application
}

group = "me.noynto.avting"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.amqp.client)
    implementation(libs.slf4j.simple)

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    // Define the main class for the application.
    mainClass = "me.noynto.avting.Paris"
}

tasks.test {
    useJUnitPlatform()
}