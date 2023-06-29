package com.example.todotest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todotest.ui.theme.TodoTestTheme
import android.util.Log
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amplifyframework.AmplifyException
import com.amplifyframework.core.Amplify
import com.amplifyframework.core.model.temporal.Temporal
import com.amplifyframework.datastore.AWSDataStorePlugin
import com.amplifyframework.datastore.generated.model.Todo
import com.example.todotest.Composables.ListPage
import com.example.todotest.Composables.RegisterPage
import com.example.todotest.Navigation.NavRoutes
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Amplify.DataStore.observe(Todo::class.java,
            { Log.i("Tutorial", "Observation began") },
            {
                val todo = it.item()
                Log.i("Tutorial", "Todo: $todo")
            },
            { Log.e("Tutorial", "Observation failed", it) },
            { Log.i("Tutorial", "Observation complete") }
        )

        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavGraph(navController = navController)
        }

    }
}

@Composable
fun NavGraph (navController: NavHostController){

    NavHost(
        navController = navController,
        startDestination = NavRoutes.List.route

    ) {
        composable(route = NavRoutes.List.route){
            ListPage(navController)
        }
        composable(route = NavRoutes.Register.route){
            RegisterPage(navController)
        }
    }
}

