package space.jacksonmonteiro.gymmanager.features.instructorRegistering

import android.util.Patterns
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.userProfileChangeRequest


/*
Created By Jackson Monteiro on 18/10/2023
*/


class InstructorRegisteringPresenter : InstructorRegisteringContract.Presenter {
    lateinit var view: InstructorRegisteringContract.View

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun register(
        name: String,
        email: String,
        password: String,
        confirmedPassword: String
    ) {
        if (validate(name, email, password, confirmedPassword)) {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    registerName(name)
                } else {
                    view.showFailure("Ocorreu um erro ao tentar criar o seu usuário, por favor, tente novamente. Se o erro persistir, entre em contato com o desenvolvedor")
                }
            }
        }
    }

    override fun registerName(name: String) {
        val user = auth.currentUser

        val profileUpdates = userProfileChangeRequest {
            displayName = name
        }

        user!!.updateProfile(profileUpdates).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                view.showSuccess("O seu usuário foi criado com sucesso!")
            }
        }
    }

    override fun validate(
        name: String,
        email: String,
        password: String,
        confirmedPassword: String
    ): Boolean {
        if (name.isEmpty()) {
            view.showFailure("O campo de nome está vazio por favor, preencha-o e tente novamente")
            return false
        } else if (email.isEmpty()) {
            view.showFailure("O campo de e-mail está vazio, por favor, preencha-o e tente novamente")
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            view.showFailure("O e-mail inserido não é válido, por favor, insira um e-mail válido e tente novamente")
            return false
        } else if (password.isEmpty()) {
            view.showFailure("O campo de senha está vazio, por favor, preencha-o e tente novamente")
            return false
        } else if (password.length < 6) {
            view.showFailure("O campo de senha deve ter no mínimo 6 dígitos, e deve ter conter letras minúsculas, maiúsculas e números")
            return false
        } else if (password != confirmedPassword) {
            view.showFailure("As senhas não são iguais, por favor, verifique isso e tente novamente")
            return false
        } else {
            var hasLowerCaseLetter = false
            var hasUpperCaseLetter = false
            var hasNumber = false

            for (char in password.iterator()) {
                if (char.isLowerCase()) {
                    hasLowerCaseLetter = true
                } else if (char.isUpperCase()) {
                    hasUpperCaseLetter = true
                } else if (char.isDigit()) {
                    hasNumber = true
                }
            }

            if (!hasLowerCaseLetter) {
                view.showFailure("A sua senha deve ter pelo menos uma letra minúscula. Corrija isso e tente novamente")
                return false
            } else if (!hasUpperCaseLetter) {
                view.showFailure("A sua senha deve ter pelo menos uma letra maiúscula. Corrija isso e tente novamente")
                return false
            } else if (!hasNumber) {
                view.showFailure("A sua senha deve ter pelo menos um número. Corrija isso e tente novamente")
                return false
            }
        }


        return true
    }
}