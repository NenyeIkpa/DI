package com.example.dependencyinjectionclasswork


import com.example.dependencyinjectionclasswork.RetrofitRx.provideRetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/** Some types cannot be injected. Interfaces cannot be constructor-injected .
So also types that you do not own such as a class from an external library.
In these cases, you can provide Hilt with binding information by using Hilt modules.
A Hilt module is a class that is annotated with @Module. It informs Hilt how to provide instances of certain types.
Hilt modules must be annotated with @InstallIn to tell Hilt which Android class each module will be used or installed in. */


private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

@Module
@InstallIn(SingletonComponent::class)
   object NetworkModule {
//
    @Singleton
    @Provides
    fun provideUserApi(): Api = provideRetrofitService()


    @Singleton  //ensures only one instance is created
    @Provides   //used to tell Hilt how to provide instances of an external library. @Binds used for interfaces.
    fun provideUserRepository(api: Api): UserRepository = UserRepository(api)
}
