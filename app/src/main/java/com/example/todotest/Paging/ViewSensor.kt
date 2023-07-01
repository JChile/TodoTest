package com.example.todotest.Paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.amplifyframework.datastore.generated.model.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ViewSensor @Inject constructor(
    private val pager: Pager<Int, Todo>
) : ViewModel() {
    val sensorPagingFlow: Flow<PagingData<Todo>> = pager.flow
        .cachedIn(viewModelScope)
}