package co.chop.assessment.config.blocks

import co.chop.assessment.extenstion.addConfigField
import co.chop.assessment.extenstion.addDoubleQuotation
import co.chop.assessment.extenstion.android
import org.gradle.api.Project


object FlavorName {
    const val googlePlay = "googlePlay"
    const val UAT = "UAT"
}

object FlavorBuildConfigField {

    object AppStoreName {

        object Key {
            const val appStoreName = "APP_STORE_NAME"
        }

        object Value {
            const val googlePlay = "GooglePlay"
            const val UAT = "UAT"
        }
    }

    object AppStoreUrl {

        object Key {
            const val appStoreUrl = "APP_STORE_URL"
        }

        object Value {
            const val googlePlay = "https://play.google.com/store/apps/details?id=co.chop.assessment"
            const val UAT = "https://combyne.com"
        }
    }

}

fun Project.setupFlavorBlock(isApplication: Boolean) {
    android.run {
        productFlavors {

            create(FlavorName.googlePlay) {
                addConfigField(
                    key = FlavorBuildConfigField.AppStoreName.Key.appStoreName,
                    value = FlavorBuildConfigField.AppStoreName.Value.googlePlay.addDoubleQuotation()
                )
                addConfigField(
                    key = FlavorBuildConfigField.AppStoreUrl.Key.appStoreUrl,
                    value = FlavorBuildConfigField.AppStoreUrl.Value.googlePlay.addDoubleQuotation()
                )
            }

            create(FlavorName.UAT) {
                addConfigField(
                    key = FlavorBuildConfigField.AppStoreName.Key.appStoreName,
                    value = FlavorBuildConfigField.AppStoreName.Value.UAT.addDoubleQuotation()
                )
                addConfigField(
                    key = FlavorBuildConfigField.AppStoreUrl.Key.appStoreUrl,
                    value = FlavorBuildConfigField.AppStoreUrl.Value.UAT.addDoubleQuotation()
                )
            }
        }
    }
}