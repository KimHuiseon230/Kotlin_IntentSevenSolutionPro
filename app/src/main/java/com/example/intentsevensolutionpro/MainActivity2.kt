package com.example.intentsevensolutionpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.intentsevensolutionpro.databinding.ActivityMain2Binding
import com.example.intentsevensolutionpro.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    val binding: ActivityMain2Binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (intent.hasExtra("no")) {
            when (intent.getIntExtra("no", 0)) {
                0 -> {
                    if (intent.hasExtra("id").equals("") && intent.hasExtra("pwd").equals("")) {
                        Toast.makeText(this, "찾을 수 없습니다.", Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        val id = intent.getStringExtra("id")
                        val pwd = intent.getStringExtra("pwd")
                        Toast.makeText(this, "찾았습니다.", Toast.LENGTH_SHORT).show() }
                    }
                3 -> {
                    val longinData = intent.getSerializableExtra("loginData") as LonginData
                    Toast.makeText(this, "${longinData.id}와 ${longinData.pwd}", Toast.LENGTH_SHORT).show()
                  }
                4 -> {
                    val longinDataParcel = intent.getParcelableExtra<LoginDataParcel>("loginDataParcel")
                    Toast.makeText(this, "${longinDataParcel?.id}와 ${longinDataParcel?.pwd}", Toast.LENGTH_SHORT).show()
                }
                5 -> {
                    val loginDataParcelList = intent.getParcelableArrayListExtra<LoginDataParcel>("loginDataParcelList")
                    Toast.makeText(this, "${loginDataParcelList?.get(2)?.id}와 ${loginDataParcelList?.get(2)?.pwd}", Toast.LENGTH_SHORT).show()
                }

            } // when end
        } // if end

    }// craete end
}