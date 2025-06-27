pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        maven {
            url = uri("https://jitpack.io") // Sử dụng uri() cho URL trong Kotlin DSL
            var allowInsecureProtocol = true // Chỉ thêm nếu cần thiết
        }
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        maven {
            url = uri("https://jitpack.io") // Sử dụng uri() cho URL trong Kotlin DSL
            var allowInsecureProtocol = true // Chỉ thêm nếu cần thiết
        }
        mavenCentral()
    }
}

rootProject.name = "BTL"
include(":app")