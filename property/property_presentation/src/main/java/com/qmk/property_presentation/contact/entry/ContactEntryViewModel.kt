package com.qmk.property_presentation.contact.entry

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qmk.property_domain.model.Neighborhood
import com.qmk.property_domain.model.contact.Agency
import com.qmk.property_domain.use_case.GetAgencies
import com.qmk.property_domain.use_case.GetNeighborhoods
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactEntryViewModel @Inject constructor(
    getNeighborhoodsUseCase: GetNeighborhoods,
    getAgenciesUseCase: GetAgencies
) : ViewModel() {
    var neighborhoods by mutableStateOf(mutableListOf<Neighborhood>())
        private set
    var agencies by mutableStateOf(mutableListOf<Agency>())
        private set

    init {
        viewModelScope.launch {
            getNeighborhoodsUseCase().collect {
                neighborhoods = it.toMutableList()
            }
            getAgenciesUseCase().collect {
                agencies = it.toMutableList()
            }
        }
    }
}