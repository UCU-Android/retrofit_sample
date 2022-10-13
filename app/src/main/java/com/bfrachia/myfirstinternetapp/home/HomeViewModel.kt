package com.bfrachia.myfirstinternetapp.home

import androidx.lifecycle.*
import com.bfrachia.myfirstinternetapp.data.domain.model.MarvelCharacter
import com.bfrachia.myfirstinternetapp.data.source.repositories.CharactersRepository
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private val charactersRepository = CharactersRepository

    private val _characters = MutableLiveData<List<MarvelCharacter>>()
    val characters: LiveData<List<MarvelCharacter>>
        get() = _characters


    fun refreshCharacters() {
        viewModelScope.launch {
            charactersRepository.fetchCharacters().run {
                _characters.postValue(this)
            }
        }
    }

    class Factory() : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return HomeViewModel() as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}