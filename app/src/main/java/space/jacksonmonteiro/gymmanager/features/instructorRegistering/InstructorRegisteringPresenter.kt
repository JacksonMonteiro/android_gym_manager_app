package space.jacksonmonteiro.gymmanager.features.instructorRegistering

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.userProfileChangeRequest


/*
Created By Jackson Monteiro on 18/10/2023
*/


class InstructorRegisteringPresenter : InstructorRegisteringContract.Presenter {
    lateinit var view: InstructorRegisteringContract.View

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val TAG = "InstructorRegistering"

    override fun register(email: String, password: String, name: String) {
        if (validate(email, password, name)) {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Show Success pop-up
                    Log.d(TAG, "Instructor Created With Success")
                } else {
                    // Show Error pop-up
                    Log.e(TAG, "Instructor Registering Failed")
                }
            }
        } else {
            view.showFailure("Alguns campos não foram preenchidos corretamente")
        }
    }

    override fun registerName(name: String) {
        val user = auth.currentUser

        val profileUpdates = userProfileChangeRequest {
            displayName = name
        }

        user!!.updateProfile(profileUpdates).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Show Success Message
            }
        }
    }

    override fun validate(email: String, password: String, name: String): Boolean {
        if (email.isEmpty()) {
            return false
        }
        return true
    }
}