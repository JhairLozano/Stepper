package com.belatrix.stepper

import android.content.Context
import android.util.AttributeSet
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.belatrix.stepper.adapter.StepperAdapter
import com.belatrix.stepper.model.StepperBean
import java.util.*

class Stepper : RecyclerView, StepperAdapter.StepperAdapterListener {

    lateinit var stepperAdapter: StepperAdapter

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) :
            super(context, attrs, defStyle) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        stepperAdapter = StepperAdapter(context, this, ArrayList())
        layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        adapter = stepperAdapter
    }

    fun setSteppers(stepperHeadList: List<StepperBean>?) {
        if (stepperHeadList != null && !stepperHeadList.isEmpty()) {
            stepperHeadList[0].isActive = true
            stepperHeadList[0].status = 1
        }
        stepperAdapter.lista = stepperHeadList
    }

    override fun next(stepper: StepperBean) {
        Toast.makeText(context, "STEPPER " + stepper.title!!, Toast.LENGTH_SHORT).show()
    }

    override fun finish(stepper: StepperBean) {
        Toast.makeText(context, "FINALIZÓ " + stepper.title!!, Toast.LENGTH_SHORT).show()
    }

}
