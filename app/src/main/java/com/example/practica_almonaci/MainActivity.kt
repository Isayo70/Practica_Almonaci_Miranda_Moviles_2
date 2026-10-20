package com.example.practica_almonaci

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica_almonaci.ui.theme.Practica_AlmonaciTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica_AlmonaciTheme {
                ContentView()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ContentView() {
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        topBar = {
            TopAppBar(
                title = { Text("Pantalla de inicio") },
                colors = topAppBarColors(
                    containerColor = Color.Gray,
                    titleContentColor = Color.White
                ),
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Atrás"
                        )
                    }
                }
            )
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray)
                    .padding(8.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Bottom App Bar",
                    color = Color.White,
                    fontSize = 10.sp,
                )
            }
        },
        floatingActionButton = {
            val context = LocalContext.current
            FloatingActionButton(onClick = {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(
                        message = "ADIOSSSS !!!!!!!!!",
                        actionLabel = " CLOSE "
                    )
                }
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Añadir"
                )
            }
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = Color.Cyan
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                var counter by rememberSaveable { mutableIntStateOf(0) }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Red)
                ) {
                    item {
                        Image(
                            painter = painterResource(id = R.drawable.image_1),
                            contentDescription = "Ilustracion de android",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(400.dp)
                        )

                        Row(
                            modifier = Modifier.padding(top = 2.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.baseline_24mp_24),
                                contentDescription = "Like",
                                modifier = Modifier
                                    .clickable { counter++ }
                                    .padding(start = 12.dp)
                                    .size(48.dp)
                            )
                            Text(
                                text = counter.toString(),
                                fontSize = 20.sp,
                                color = Color.White,
                                modifier = Modifier.padding(start = 8.dp),
                            )
                        }

                        Text(
                            text = stringResource(R.string.materia),
                            fontSize = 24.sp,
                            color = Color.White,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = stringResource(R.string.nombre),
                            fontSize = 20.sp,
                            color = Color.White,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = stringResource(R.string.apellido),
                            fontSize = 20.sp,
                            color = Color.White,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )

                        LazyRow(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            item {
                                Image(
                                    modifier = Modifier
                                        .size(200.dp)
                                        .height(100.dp),
                                    painter = painterResource(id = R.drawable.arbol),
                                    contentDescription = "Árbol"
                                )
                                Image(
                                    modifier = Modifier
                                        .size(200.dp)
                                        .height(100.dp),
                                    painter = painterResource(id = R.drawable.arcoiris),
                                    contentDescription = "Arcoíris"
                                )
                                Image(
                                    modifier = Modifier
                                        .size(200.dp)
                                        .height(100.dp),
                                    painter = painterResource(id = R.drawable.corazo),
                                    contentDescription = "Corazón"
                                )
                                Image(
                                    modifier = Modifier
                                        .size(200.dp)
                                        .height(100.dp),
                                    painter = painterResource(id = R.drawable.kirbi),
                                    contentDescription = "Kirby 1"
                                )
                                Image(
                                    modifier = Modifier
                                        .size(200.dp)
                                        .height(100.dp),
                                    painter = painterResource(id = R.drawable.kirbyzzz),
                                    contentDescription = "Kirby durmiendo"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}