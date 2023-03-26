import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    application
    id("org.springframework.boot") version "2.7.10"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "fr.isima"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(group = "io.vavr", name = "vavr", version = "0.9.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.9.8")
    implementation("org.apache.commons:commons-lang3:3.8.1")
    implementation("javax.inject:javax.inject:1")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-tomcat")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-devtools")
    implementation("com.h2database:h2")
    implementation("javax.servlet:jstl")
    implementation("org.apache.tomcat.embed:tomcat-embed-jasper")

    testImplementation(platform("org.junit:junit-bom:5.9.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:3.24.2")
    testImplementation("org.mockito:mockito-core:5.2.0")
}

//reload resources dinamycally
tasks.getByName<BootRun>("bootRun") {

    sourceResources(sourceSets["main"])
}

val javaVersion = JavaVersion.VERSION_1_8.toString()
tasks.getByName<JavaCompile>("compileJava") {
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
}
tasks.getByName<JavaCompile>("compileTestJava") {
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

