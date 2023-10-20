package space.jacksonmonteiro.gymmanager.features.home

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


/*
Created By Jackson Monteiro on 20/10/2023
*/


class HomePresenter : HomeContract.Presenter {
    lateinit var view: HomeContract.View

    override fun logout() {
        Firebase.auth.signOut()
        view.exit()
    }
}