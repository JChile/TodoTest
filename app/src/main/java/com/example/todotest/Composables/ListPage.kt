package com.example.todotest.Composables


import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.amplifyframework.datastore.generated.model.Todo
import com.example.todotest.Navigation.NavRoutes
import com.example.todotest.R
import androidx.paging.compose.items
import com.example.todotest.Paging.TodoCard
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListPage(naveController: NavController,  sensors: LazyPagingItems<Todo>) {
    val context = LocalContext.current
    LaunchedEffect(key1 = sensors.loadState) {
        if(sensors.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error: " + (sensors.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Box(modifier = Modifier.fillMaxWidth()){
        if(sensors.loadState.refresh is LoadState.Loading) {


            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)

            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                items(sensors) { sensor ->

                    if(sensor != null) {

                        TodoCard(
                            todo = sensor

                        )
                    }
                }
                item {
                    if(sensors.loadState.append is LoadState.Loading){
                        CircularProgressIndicator()
                    }
                }
            }

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



}


