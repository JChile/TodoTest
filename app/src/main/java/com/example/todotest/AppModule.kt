package com.example.todotest

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.amplifyframework.datastore.generated.model.Todo
import com.example.todotest.Paging.Getdata
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideSensorDataPager(): Pager<Int, Todo> {

        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = { Getdata() }
        )
    }
}