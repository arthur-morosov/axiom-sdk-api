import org.gradle.api.publish.maven.MavenPublication

plugins {
//    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.library)
//    alias(libs.plugins.maven.publish)
    `maven-publish`
}

android {
    compileSdk = 36 // Укажите актуальную версию
    defaultConfig {
        minSdk = 24
        targetSdk = 36
    }
}

//// Публикация артефакта
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                // Если вы публикуете AAR напрямую
                artifact("library/core-release.aar")

                groupId = "com.github.arthur-morosov"
                artifactId = "axiom-sdk-api"
                version = "0.0.2"
            }
        }
    }
}