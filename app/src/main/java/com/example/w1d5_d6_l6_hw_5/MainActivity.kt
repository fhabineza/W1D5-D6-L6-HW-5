package com.example.w1d5_d6_l6_hw_5

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun submit(view: View) {
        //STEP 1 CREATE OBJECT OF ALERT DIALOG
        val alert = AlertDialog.Builder(this)

        var maxPoint = 0
        if (checkBox1.isChecked && checkBox2.isChecked && checkBox3.isChecked) {
            maxPoint += 50
        }
        try {
            var radionBtnClicked =
                radioGroup.findViewById(radioGroup.checkedRadioButtonId) as RadioButton

            if (radionBtnClicked.text.equals("Both of the above")) {
                maxPoint += 50
            }
        }catch (e : Exception){

        }



        val year: Int = Calendar.getInstance().get(Calendar.YEAR)
        val month: Int = Calendar.getInstance().get(Calendar.MONTH)
        val day: Int = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        val hour: Int = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        val min: Int = Calendar.getInstance().get(Calendar.MINUTE)
        val sec: Int = Calendar.getInstance().get(Calendar.SECOND)
        val msec: Int = Calendar.getInstance().get(Calendar.MILLISECOND)

        var currentDate: String = "${month + 1}/$day/$year $hour:$min:$sec"

        alert.setTitle("Quiz App Result")
        alert.setMessage("Congratulations! You submitted on $currentDate, Your achieved $maxPoint%")
        alert.setIcon(R.drawable.alerticon)


        alert.setPositiveButton("yes") { dialogInterface, which ->
            dialogInterface.dismiss()
            finish()
        }

        alert.setNegativeButton("Cancel") { dialogInterface, which ->
            dialogInterface.dismiss()
        }

        var dialog: AlertDialog = alert.create()

        dialog.show()
    }


    fun resetBtn(view: View) {
        radioGroup.clearCheck()
        checkBox1.isChecked = false
        checkBox2.isChecked = false
        checkBox3.isChecked = false
        Toast.makeText(this, "Fields are cleared, You can start your quiz", Toast.LENGTH_LONG)
            .show()
    }


}
