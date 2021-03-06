package com.kakudi.user.di.usecase

import com.kakudi.user.data.model.User
import com.kakudi.user.data.repository.UserRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 03/04/2019
 */
class CreateLocalAccount @Inject constructor(private val userRepository: UserRepository) {

    fun execute(user: User): Observable<User> {
        return Observable.create {
            userRepository.insert(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it.onNext(user)
                }, { err ->
                    err.printStackTrace()
                    it.onError(err)
                })
        }
    }
}