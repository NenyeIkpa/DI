package com.example.dependencyinjectionclasswork

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**All apps that use Hilt must contain an Application() class annotated with @HiltAndroidApp */

@HiltAndroidApp     //triggers Hilt's code generation that includes a
                    // base class which serves as the application level dependency container

class ExampleDIWithHilt: Application() {
}