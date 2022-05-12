package com.nieelz.danielstoryapp.custom


import android.content.Context
import android.graphics.Canvas
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.AppCompatEditText
import com.google.android.material.textfield.TextInputLayout

class PasswordEditText : TextInputLayout{

    private lateinit var textPassword: EditText
    var valid = false

    constructor(context: Context) : super(context) {
        init()
    }


    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }


    private fun init() {
        addOnEditTextAttachedListener{
            textPassword = it.editText!!

            textPassword.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    if (p0!!.length == 0){
                        it.error = "insert password"
                    }
                    else if(p0!!.length < 6){
                        it.error = "below 6"
                    }
                    else{
                        it.error = null
                        valid = true
                    }
                }

                override fun afterTextChanged(p0: Editable?) {

                }

            })
        }

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        hint = "Password"
        textAlignment = View.TEXT_ALIGNMENT_VIEW_START
    }




}