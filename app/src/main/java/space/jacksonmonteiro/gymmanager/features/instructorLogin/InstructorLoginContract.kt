package space.jacksonmonteiro.gymmanager.features.instructorLogin


/*
Created By Jackson Monteiro on 20/10/2023
*/


interface InstructorLoginContract {
    interface Presenter {
        fun login(email: String, password: String)
        fun validate(email: String, password: String) : Boolean
    }

    interface View {
        fun showFailure(message: String)
        fun navigateToHome()
    }
}