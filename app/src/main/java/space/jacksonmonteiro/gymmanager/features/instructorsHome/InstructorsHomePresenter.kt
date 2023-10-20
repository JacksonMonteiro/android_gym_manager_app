package space.jacksonmonteiro.gymmanager.features.instructorsHome

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


/*
Created By Jackson Monteiro on 20/10/2023
*/


class InstructorsHomePresenter : InstructorsHomeContract.Presenter {
    lateinit var view: InstructorsHomeContract.View

    override fun logout() {
        Firebase.auth.signOut()
        view.exit()
    }
}