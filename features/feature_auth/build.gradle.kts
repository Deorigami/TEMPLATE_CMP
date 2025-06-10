plugins {
    id("plugin.service")
}

kotlin.sourceSets.commonMain {
    dependencies {
        implementation(project(":cores:core_feature"))
    }
}

android.namespace = "app.tktn.feature_auth"