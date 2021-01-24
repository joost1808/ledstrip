import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.3.0.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
    base
}

group = "nl.joost"
version = "1.2"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenLocal()
	mavenCentral()
}

dependencies {
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7")
	implementation("com.github.mbelling:rpi-ws281x-java:2.0.0-SNAPSHOT")
	implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks {
    register("docker") {
        dependsOn("build", "assemble")
        description = "Builds jar and creates docker image"
        doLast {
            println("Building dockerfile with versionnumber $version")
            exec {
                commandLine("docker", "build", ".", "--build-arg", "VERSION=$version", "-t", "joost1808/ledstrip-backend:latest")
            }
            println("tagging joost1808/ledstrip-backend:$version")
            exec {
                commandLine("docker", "tag", "joost1808/ledstrip-backend:latest", "joost1808/ledstrip-backend:$version")
            }
            println("pushing joost1808/ledstrip-backend:$version")
            exec {
                commandLine("docker", "push", "joost1808/ledstrip-backend:$version")
            }
        }
    }
}
