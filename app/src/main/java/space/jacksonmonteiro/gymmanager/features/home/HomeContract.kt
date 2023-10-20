package space.jacksonmonteiro.gymmanager.features.home


/*
Created By Jackson Monteiro on 20/10/2023
*/


interface HomeContract {
    interface Presenter {
        fun logout()
    }

    interface View {
        fun exit()
    }
}