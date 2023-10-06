package com.loc.newsapp.domain.usecases

import com.loc.newsapp.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    //operate fun makes it possible to call the function using the class name
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}