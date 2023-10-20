package space.jacksonmonteiro.gymmanager.features.instructorLogin

import android.util.Patterns
import com.google.firebase.auth.FirebaseAuth


/*
Created By Jackson Monteiro on 20/10/2023
*/


class InstructorLoginPresenter : InstructorLoginContract.Presenter {
    lateinit var view: InstructorLoginContract.View
    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun login(email: String, password: String) {
        if (validate(email, password)) {
            auth.signInWithEmailAndPassword(email.trim(), password.trim()).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    view.navigateToHome()
                } else {
                    view.showFailure("Ocorreu um erro ao tentar realizar o login, por favor, tente novamente. Se o erro persistir, entre em contato com o desenvolvedor")
                }
            }
        }
    }

    override fun validate(email: String, password: String): Boolean {
        if (email.trim().isEmpty()) {
            view.showFailure("O campo de e-mail está vazio, por favor, preencha-o e tente novamente")
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches()) {
            view.showFailure("O e-mail inserido não é válido, por favor, insira um e-mail válido e tente novamente")
            return false
        } else if (password.trim().isEmpty()) {
            view.showFailure("O campo de senha está vazio, por favor, preencha-o e tente novamente")
            return false
        } else if (password.contains(" ")) {
            view.showFailure("A sua senha não pode ter espaços em branco. Remova-o e tente novamente")
            return false
        } else if (password.trim().length < 6) {
            view.showFailure("O campo de senha deve ter no mínimo 6 dígitos, e deve ter conter letras minúsculas, maiúsculas e números")
            return false
        } else {
            var hasLowerCaseLetter = false
            var hasUpperCaseLetter = false
            var hasNumber = false

            for (char in password.trim().iterator()) {
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