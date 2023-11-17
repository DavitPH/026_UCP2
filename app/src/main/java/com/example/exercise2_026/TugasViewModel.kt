package com.example.exercise2_026

import androidx.lifecycle.ViewModel
import com.example.exercise2_026.Data.TugasUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TugasViewModel : ViewModel() {
    private val _stateUi = MutableStateFlow(TugasUIState())
    val stateUi: StateFlow<TugasUIState> = _stateUi.asStateFlow()

    fun setData(listContact: MutableList<String>){
        _stateUi.update{
                stateSaatIni ->
            stateSaatIni.copy(
                nama = listContact[0],
                nim = listContact[1],
                konsen = listContact[2],
                judul = listContact[3],

            )
        }
    }

    fun setDosen (pilihDosen: String){
        _stateUi.update{
                stateSaatIni -> stateSaatIni.copy(
            dosen = pilihDosen)
        }
    }
}

