package com.example.todotest.Composables

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import com.amplifyframework.core.Amplify
import com.amplifyframework.core.model.query.Page
import com.amplifyframework.core.model.query.Where
import com.amplifyframework.datastore.generated.model.Todo
import com.example.todotest.Navigation.NavRoutes
import com.example.todotest.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListPage(naveController: NavController) {
    var todoslist = remember { (mutableListOf<Todo>())}

    Amplify.DataStore.query(Todo::class.java,
        Where.matchesAll().paginated(Page.startingAt(0).withLimit(10)),
        { todos  ->
            while (todos.hasNext()) {
                val todoItem = todos.next()
                todoslist.add(todoItem)
            }
        },
        { Log.e("MyAmplifyApp", "Query failed", it) }
    )


    val listItems = todoslist.toList()

    LazyColumn {
        items(listItems) { todo ->
            TodoCard(todo = todo)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            onClick = { naveController.navigate(NavRoutes.Register.route)},
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_add_24),
                contentDescription = "Añadir"
            )
        }
    }

}

@Composable
fun TodoCard(todo: Todo) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Title: ${todo.dato}",
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Description: ${todo.fecha}",
                style = TextStyle(fontSize = 14.sp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Priority: ${todo.comentario}",
                style = TextStyle(fontSize = 14.sp)
            )
        }
    }
}

