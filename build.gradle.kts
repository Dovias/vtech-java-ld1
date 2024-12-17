plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version "0.1.0"
    id("org.hibernate.orm") version "6.6.3.Final"
}

group = "me.dovias.vtech"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

javafx {
    version = "23.0.1"
    modules("javafx.controls", "javafx.fxml")
}

application {
    mainClass = "me.dovias.vtech.java.ld1.EntryPoint"
}

repositories {
    mavenCentral()
}
