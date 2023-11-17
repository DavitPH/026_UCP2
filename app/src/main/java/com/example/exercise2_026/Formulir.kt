package com.example.exercise2_026

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exercise2_026.ui.theme.Exercise2_026Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Formulir(
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    pilihDosen: List<String>,
    onSelectionChanged: (String) -> Unit,
    modifier: Modifier = Modifier)
{
    var nama by rememberSaveable { mutableStateOf("") }
    var nim by rememberSaveable { mutableStateOf("") }
    var konsen by rememberSaveable { mutableStateOf("") }
    var judul by rememberSaveable { mutableStateOf("") }
    var ListData: MutableList<String> = mutableListOf(nama, nim, konsen, judul)

    var dosenYgDipilih by rememberSaveable { mutableStateOf("") }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Formulir Pengerjaan Skripsi", fontWeight = FontWeight.Bold)
        OutlinedTextField(value = nama, onValueChange = {nama = it}, label = { Text(text = "Nama Mahasiswa") })
        OutlinedTextField(value = nim, onValueChange = {nim = it}, label = { Text(text = "NIM") })
        OutlinedTextField(value = konsen, onValueChange = {konsen = it}, label = { Text(text = "Konsentrasi") })
        OutlinedTextField(value = judul, onValueChange = {judul = it}, label = { Text(text = "Judul Skripsi") })

        Spacer(modifier = Modifier.padding(20.dp))
        Text(text = "Dosen Pembimbing")
        pilihDosen.forEach { item ->
            Row(modifier = Modifier.selectable(
                selected = dosenYgDipilih== item,
                onClick = {
                    dosenYgDipilih = item
                    onSelectionChanged(item)
                }
            ),

                verticalAlignment = Alignment.CenterVertically){

                RadioButton(selected = dosenYgDipilih == item, onClick = {dosenYgDipilih = item
                    onSelectionChanged(item)}
                )
                Text(item)
            }
        }


        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = { onSubmitButtonClicked(ListData) }) {
            Text(text = stringResource(id = R.string.submit))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHalamanFormulir() {
    Exercise2_026Theme {
        Formulir(pilihDosen = listOf("Djoko", "Haris", "Aprilia"),
            onSelectionChanged = { /* handle selection change */ },
            onSubmitButtonClicked = { /* handle cancel button */ })
    }
}