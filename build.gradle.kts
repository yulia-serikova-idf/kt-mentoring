val junitJupiterVersion: String by project
val kotlinVersion: String by project
val jacksonVersion: String by project

plugins {
  kotlin("jvm") version "1.5.10"
}

group = "kotlin.com"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib"))
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
  implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:$jacksonVersion")
  implementation("junit:junit:4.13.1")
  testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
  testImplementation("org.junit.jupiter:junit-jupiter-params:$junitJupiterVersion")
  testImplementation("io.mockk:mockk:1.9.3")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
}

tasks.test {
  useJUnitPlatform()
}
