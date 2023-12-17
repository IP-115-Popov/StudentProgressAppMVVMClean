package com.sergey.studentprogressappmvvmclean.domain.usecase

import android.view.View

class CloseStudentEditPanelUseCase {
    fun exectute(view: View)
    {
        view.visibility = View.GONE
    }
}