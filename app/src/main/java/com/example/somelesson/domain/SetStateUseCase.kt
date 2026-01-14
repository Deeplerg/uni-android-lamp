package com.example.somelesson.domain

import com.example.somelesson.data.LampRepository
import javax.inject.Inject

interface SetStateUseCase {
    suspend operator fun invoke(isOn: Boolean): Boolean
}

class SetStateUseCaseImpl @Inject constructor(
    val repository: LampRepository
): SetStateUseCase {
    override suspend operator fun invoke(isOn: Boolean): Boolean {
        return repository.setState(isOn)
    }
}