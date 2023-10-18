package space.jacksonmonteiro.gymmanager.features.instructorRegistering


/*
Created By Jackson Monteiro on 18/10/2023
*/


interface InstructorRegisteringContract {
    interface Presenter {
        fun register(email: String, password: String, name: String)
        fun registerName(name: String)
        fun validate(email: String, password: String, name: String) : Boolean
    }

    interface View {
        fun showFailure(message: String)
    }
}