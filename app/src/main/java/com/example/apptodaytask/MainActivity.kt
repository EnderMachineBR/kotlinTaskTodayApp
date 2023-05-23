package com.example.apptodaytask

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apptodaytask.ui.theme.AppTodayTaskTheme
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreenContente()
        }
    }
}


@Composable
fun MainScreenContente() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "TaskAppBar")},
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Drawer Menu"
                    )
                }
            )
        },
        content = {
            paddingValues -> Log.i("PaddingValues","$paddingValues")
            Column(
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxSize()
            ) {
                MySearchField(modificador = Modifier.fillMaxWidth())
                MyTaskWidget(modificador = Modifier.fillMaxWidth(),
                    taskName = "Preparar aula",
                    taskDetails = "É melhor usar um lazilist",
                    deadEndDate = Date()
                )
                MyTaskWidget(modificador = Modifier.fillMaxWidth(),
                    taskName = "Prova Matematica",
                    taskDetails = "Etudar calculo",
                    deadEndDate = Date()
                )
            }
        },
        bottomBar = {
            BottomAppBar(
                content = { Text("aondn")}
            )
        }
    )
}

@Composable
fun MySearchField(modificador: Modifier){
    TextField(value = "",
        onValueChange = {},
        modifier = modificador,
        placeholder = { Text(text = "Pesquisar tarefa")},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon")
        }
    )
}

@Composable
fun MyTaskWidget(
    modificador: Modifier,
    taskName:String,
    taskDetails:String,
    deadEndDate:Date
    ){
    val dateFormatter = SimpleDateFormat("EEE,MMM dd, yyyy", Locale.getDefault())
    Row(modifier = modificador){
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Icons of pendent task"
        )
        Text(text = dateFormatter.format(deadEndDate),
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = 24.sp
        )
    }
    Column(modifier = modificador
        .border(width = 1.dp, color = Color.Black)
        .padding(3.dp)
    ) {
        Text(text = taskName,
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold
        )
        Text(text = taskDetails,
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Preview(showBackground =true)
@Composable
fun DefeultPreview(){
    MainScreenContente()
}