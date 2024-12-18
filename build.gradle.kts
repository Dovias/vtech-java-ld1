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

tasks {
    processResources {
        val currentSourceSet = sourceSets.find { sourceSet ->
            sourceSet.resources.any {
                source.contains(it)
            }
        }

        val properties = "classDirectory" to currentSourceSet!!.output.classesDirs.singleFile.relativeTo(projectDir)
        filesMatching("META-INF/persistence.xml") {
            expand(properties)
        }
    }
}


dependencies {
    implementation("org.xerial:sqlite-jdbc:3.47.1.0")
    implementation("org.hibernate.orm:hibernate-community-dialects:6.6.3.Final")
    implementation("org.jspecify:jspecify:1.0.0")
    implementation("at.favre.lib:bcrypt:0.10.2")

}
