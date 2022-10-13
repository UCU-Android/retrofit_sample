package com.bfrachia.myfirstinternetapp.data.api.model

import com.bfrachia.myfirstinternetapp.data.domain.model.MarvelCharacter
import com.bfrachia.myfirstinternetapp.data.domain.util.EntityMapper

object CharacterNetworkMapper: EntityMapper<Result, MarvelCharacter> {

    override fun mapFromEntity(entity: Result): MarvelCharacter {
        return MarvelCharacter(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            thumbnailUrl = "${entity.thumbnail.path}${entity.thumbnail.extension}"
        )
    }

    //Not needed for this sample
    override fun mapToEntity(domainModel: MarvelCharacter): Result {
        TODO("Not yet implemented")
    }

    fun fromGetCharactersResponse(networkResponse: CharactersResponse): List<MarvelCharacter> {
        return networkResponse.data.results.map { mapFromEntity(it) }
    }
}