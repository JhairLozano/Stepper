package com.belatrix.stepper.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.belatrix.stepper.R
import com.belatrix.stepper.model.StepperBean

class StepperAdapter(
    internal var context: Context,
    private val listener: StepperAdapterListener,
    private var stepperBeanList: List<StepperBean>?
) : RecyclerView.Adapter<StepperAdapter.ViewHolder>() {

    val layoutInflater: LayoutInflater

    var lista: List<StepperBean>?
        get() = stepperBeanList
        set(stepperBeanList) {
            this.stepperBeanList = stepperBeanList
            notifyDataSetChanged()
        }

    init {
        this.layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = this.layoutInflater.inflate(R.layout.row_stepper, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(stepperBeanList!![position], position)
    }

    override fun getItemCount(): Int {
        return stepperBeanList!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var lineTop: View
        internal var viewId: View
        internal var lineBottom: View
        internal var txvTitle: TextView
        internal var txvNumber: TextView
        internal var txvDetail: TextView
        internal var btnNext: Button

        init {
            lineTop = itemView.findViewById(R.id.line_top)
            viewId = itemView.findViewById(R.id.view_id)
            lineBottom = itemView.findViewById(R.id.line_bottom)
            txvTitle = itemView.findViewById(R.id.txv_title)
            txvNumber = itemView.findViewById(R.id.txv_number)
            txvDetail = itemView.findViewById(R.id.txv_detail)
            btnNext = itemView.findViewById(R.id.btn_next)
        }

        fun bind(stepperBean: StepperBean, position: Int) {
            if (position == 0) {
                lineTop.visibility = View.GONE
            }
            if (position == itemCount - 1) {
                lineBottom.visibility = View.GONE
                btnNext.text = "FINALIZAR"
            }
            txvNumber.text = Integer.toString(position + 1)
            txvTitle.text = stepperBean.title
            txvDetail.text = stepperBean.detail

            if (stepperBean.isActive) {
                txvDetail.visibility = View.VISIBLE
                btnNext.visibility = View.VISIBLE
            } else {
                txvDetail.visibility = View.GONE
                btnNext.visibility = View.GONE
            }

            if (stepperBean.status == 1) {
                viewId.background = context.getDrawable(R.drawable.bg_circle)
            } else {
                viewId.background = context.getDrawable(R.drawable.bg_circle_off)
            }

            btnNext.setOnClickListener {
                if (position == itemCount - 1) {
                    listener.finish(stepperBean)
                } else {
                    listener.next(stepperBean)
                    stepperBeanList!![position].isActive = false
                    stepperBeanList!![position + 1].isActive = true
                    stepperBeanList!![position + 1].status = 1
                    notifyDataSetChanged()
                }
            }

        }
    }

    interface StepperAdapterListener {
        fun next(stepperBeanList: StepperBean)

        fun finish(stepperBeanList: StepperBean)
    }

}
