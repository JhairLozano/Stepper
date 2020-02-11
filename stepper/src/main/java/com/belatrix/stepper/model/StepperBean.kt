package com.belatrix.stepper.model

import androidx.fragment.app.Fragment

class StepperBean {

    var title: String? = null
    var detail: String? = null
    var fragment: Fragment? = null
    var isActive: Boolean = false
    var status: Int = 0

    init {
        this.isActive = false
        this.status = 0
    }
}