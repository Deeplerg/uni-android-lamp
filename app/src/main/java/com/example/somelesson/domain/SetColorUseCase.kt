package com.example.somelesson.domain

import com.example.somelesson.data.LampRepository
import javax.inject.Inject

interface SetColorUseCase {
    suspend operator fun invoke(color: String): Boolean
}

class SetColorUseCaseImpl @Inject constructor(
    val repository: LampRepository
): SetColorUseCase {
    override suspend operator fun invoke(color: String): Boolean {
        return repository.setColor(color)
    }
}