package com.example.todotest.Paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.amplifyframework.core.Amplify
import com.amplifyframework.core.model.query.Page
import com.amplifyframework.core.model.query.Where
import com.amplifyframework.datastore.generated.model.Todo
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


class Getdata : PagingSource<Int, Todo>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Todo> {
        return try {
            val page = params.key ?: 0
            val limit = params.loadSize
            val todosList = ArrayList<Todo>()

            suspendCoroutine<Unit> { continuation ->
                Amplify.DataStore.query(
                    Todo::class.java,
                    Where.matchesAll().paginated(Page.startingAt(page).withLimit(limit)),

                    { todos ->
                        while (todos.hasNext()) {
                            val todoItem = todos.next()
                            todosList.add(todoItem)
                        }
                        continuation.resume(Unit)
                    },
                    { error ->
                        continuation.resumeWithException(error)
                    }
                )
            }
            LoadResult.Page(
                data = todosList,
                prevKey = if (page > 0) page - 1 else null,
                nextKey = if (todosList.isNotEmpty()) page + 1 else null
            )
        } catch (error: Throwable) {
            LoadResult.Error(error)
        }
    }
    override fun getRefreshKey(state: PagingState<Int, Todo>): Int? {
        return null
    }
}