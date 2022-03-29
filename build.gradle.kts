val junitJupiterVersion: String by project
val kotlinVersion: String by project
val jacksonVersion: String by project
val log4jVersion: String by project
val slf4jVersion: String by project
val webDriverManagerVersion: String by project
val selenideVersion: String by project
val okHttpVersion: String by project
val retrofitVersion: String by project
val converterGsonVersion: String by project

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
  implementation("org.apache.logging.log4j:log4j-api:$log4jVersion")
  implementation("org.apache.logging.log4j:log4j-core:$log4jVersion")
  implementation("org.slf4j:slf4j-log4j12:$slf4jVersion")
  implementation("io.github.bonigarcia:webdrivermanager:$webDriverManagerVersion")
  implementation("com.codeborne:selenide:$selenideVersion")
  implementation("com.squareup.okhttp3:okhttp:$okHttpVersion")
  implementation("com.squareup.okhttp3:logging-interceptor:$okHttpVersion")
  implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
  implementation("com.squareup.retrofit2:converter-gson:$converterGsonVersion")
  testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
  testImplementation("org.junit.jupiter:junit-jupiter-params:$junitJupiterVersion")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
}

tasks.test {
  useJUnitPlatform()
}
