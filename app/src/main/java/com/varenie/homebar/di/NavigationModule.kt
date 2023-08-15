package com.varenie.homebar.di

import com.varenie.homebar.view.navigation.AppNavigator
import com.varenie.homebar.view.navigation.AppNavigatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object NavigationModule {

    @Provides
    @ViewModelScoped
    fun bindAppNavigator(): AppNavigator {
        return AppNavigatorImpl()
    }
}