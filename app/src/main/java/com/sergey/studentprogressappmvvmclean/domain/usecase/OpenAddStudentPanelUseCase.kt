package com.sergey.studentprogressappmvvmclean.domain.usecase

import android.view.View

class OpenAddStudentPanelUseCase {
    fun exectute(view: View)
    {
        view.visibility = View.VISIBLE
    }
}