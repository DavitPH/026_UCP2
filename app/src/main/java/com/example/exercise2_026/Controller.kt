package com.example.exercise2_026

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

enum class Controller {
    Home,
    Formulir,
    Konfirmasi,
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TugasSkripsi(
    navController: NavHostController = rememberNavController(),
    viewModel: TugasViewModel = viewModel()
){
    Scaffold () {innerPadding ->
        val uiState by viewModel.stateUi.collectAsState()
        NavHost(
            navController = navController,
            startDestination = Controller.Home.name,
            modifier = Modifier.padding(innerPadding)
        )
        {
            composable(route = Controller.Home.name){
                Home (
                    onNextButtonClicked = {
                        navController.navigate(Controller.Formulir.name) })
            }
        }

    }
}