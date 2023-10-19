package space.jacksonmonteiro.gymmanager.features.instructorRegistering


/*
Created By Jackson Monteiro on 18/10/2023
*/


interface InstructorRegisteringContract {
    interface Presenter {
        fun register(name: String, email: String, password: String, confirmedPassword: String)
        fun registerName(name: String)
        fun validate(
            name: String,
            email: String,
            password: String,
            confirmedPassword: String
        ): Boolean
    }

    interface View {

        fun showFailure(message: String)
        fun showSuccess(message: String)
    }
}