package com.example.todotest.Composables

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.amplifyframework.core.Amplify
import com.amplifyframework.core.model.query.Page
import com.amplifyframework.core.model.query.QueryOptions
import com.amplifyframework.core.model.query.Where
import com.amplifyframework.datastore.DataStoreException
import com.amplifyframework.datastore.generated.model.Todo
import com.example.todotest.Navigation.NavRoutes
import com.example.todotest.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterPage(naveController: NavController) {

    var valorDat by remember { mutableStateOf("") }
    var valorFec by remember { mutableStateOf("") }
    var valorCom by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),

        ) {

        OutlinedTextField(
            value = valorDat,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Red,
                containerColor = Color.White,
                cursorColor = Color.Red,
                focusedLabelColor = Color.Red,
            ),

            onValueChange = { valorDat = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            label = { Text(text = "Dato") },
            modifier = Modifier.fillMaxWidth(),

            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "Valor Icon"
                )
            }
        )

        OutlinedTextField(
            value = valorFec,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Red,
                containerColor = Color.White,
                cursorColor = Color.Red,
                focusedLabelColor = Color.Red,
            ),

            onValueChange = { valorFec = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            label = { Text(text = "Fecha") },
            modifier = Modifier.fillMaxWidth(),

            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "Valor Icon"
                )
            }
        )

        OutlinedTextField(
            value = valorCom,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Red,
                containerColor = Color.White,
                cursorColor = Color.Red,
                focusedLabelColor = Color.Red,
            ),

            onValueChange = { valorCom = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            label = { Text(text = "Comentario") },
            modifier = Modifier.fillMaxWidth(),

            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "Valor Icon"
                )
            }
        )

        Spacer(modifier = Modifier.height(height = 30.dp))

        Button(
            onClick = {
                val item = Todo.builder()
                    .dato(valorDat)
                    .fecha(valorFec)
                    .comentario(valorCom)
                    .build()

                Amplify.DataStore.save(item,
                    { Log.i("Tutorial", "Saved item") },
                    { Log.e("Tutorial", "Could not save item to DataStore", it) }
                )
            },

            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
            ),
            elevation = ButtonDefaults.buttonElevation(0.dp, 0.dp),
            modifier = Modifier
                .align(Alignment.End)
                .height(50.dp)
                .width(180.dp)
                .background(
                    color = Color.Red,
                    shape = RoundedCornerShape(16.dp)
                )

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "CREAR",
                    fontSize = 15.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
                Icon(
                    modifier = Modifier
                        .padding(start = 10.dp),
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Arrow Icon",
                    tint = Color.White,
                )
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            onClick = { naveController.navigate(NavRoutes.List.route)},
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_exit_to_app_24),
                contentDescription = "Añadir"
            )
        }
    }
}