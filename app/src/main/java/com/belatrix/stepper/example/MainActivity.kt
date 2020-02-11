package com.belatrix.stepper.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.belatrix.stepper.Stepper
import com.belatrix.stepper.example.fragment.TestFragment
import com.belatrix.stepper.model.StepperBean
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var stp_content: Stepper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stp_content = findViewById(R.id.stp_content)

        val stepperBeans = ArrayList<StepperBean>()

        val stepper1 = StepperBean()
        stepper1.title = "Hola Mundo"
        stepper1.detail = "Test 01"
        stepper1.fragment = TestFragment.newInstance(1)
        stepperBeans.add(stepper1)

        val stepper2 = StepperBean()
        stepper2.title = "Qué tal tu día ?"
        stepper2.detail = "Test 02"
        stepper2.fragment = TestFragment.newInstance(2)
        stepperBeans.add(stepper2)

        val stepper3 = StepperBean()
        stepper3.title = "Gracias por visitarnos"
        stepper3.detail = "Test 03"
        stepper3.fragment = TestFragment.newInstance(3)
        stepperBeans.add(stepper3)

        stp_content.setSteppers(stepperBeans)
    }

}
