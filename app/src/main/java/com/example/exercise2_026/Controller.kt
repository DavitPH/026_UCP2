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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.exercise2_026.Data.DataDosen.dosen

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

            composable(route = Controller.Formulir.name){
                val context = LocalContext.current

                Formulir(onNextButtonClicked =  { contactData ->
                    viewModel.setData(contactData)
                    navController.navigate(Controller.Konfirmasi.name)
                },

                    onSelectionChanged = {viewModel.setDosen(it)})
            }

            composable(route = Controller.Formulir.name){
                Konfirmasi(TugasUIState = uiState,
                    onBackButtonClicked = {cencelOrderAndNavigateToRasa(navController)},
                )
            }


        }

    }
}


private fun cencelOrderAndNavigateToRasa(
    navController: NavHostController
){
    navController.popBackStack(Controller.Formulir.name, inclusive = false)
}