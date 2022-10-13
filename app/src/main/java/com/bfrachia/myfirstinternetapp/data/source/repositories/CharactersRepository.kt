package com.bfrachia.myfirstinternetapp.data.source.repositories

import com.bfrachia.myfirstinternetapp.BuildConfig
import com.bfrachia.myfirstinternetapp.data.domain.model.MarvelCharacter
import com.bfrachia.myfirstinternetapp.data.api.MarvelClient
import com.bfrachia.myfirstinternetapp.data.api.model.CharacterNetworkMapper
import com.bfrachia.myfirstinternetapp.extensions.md5
import com.bfrachia.myfirstinternetapp.extensions.toHex
import java.util.*

object CharactersRepository {

    suspend fun fetchCharacters(): List<MarvelCharacter> {
        val timeStamp = Date().time.toString()
        val characters = MarvelClient.service
            .listCharacters(
                apiKey = BuildConfig.PUBLIC_KEY,
                orderBy = "-modified",
                ts = timeStamp,
                hash = "$timeStamp${BuildConfig.PRIVATE_KEY}${BuildConfig.PUBLIC_KEY}".md5().toHex()
            )

        return CharacterNetworkMapper.fromGetCharactersResponse(characters)
    }
}