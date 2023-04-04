package com.example.intentsevensolutionpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.intentsevensolutionpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCallActivity.setOnClickListener(this)
        binding.btnSendData.setOnClickListener(this)
        binding.btnSendDataObject.setOnClickListener(this)
        binding.btnSendPacelObjdect.setOnClickListener(this)
        binding.btnSendPaceArrayList.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnCallActivity -> {
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }
            R.id.btnSendData -> {
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("id", "admin")
                intent.putExtra("pwd", "123456")
                startActivity(intent)
            }
            R.id.btnSendDataObject -> {
                val intent = Intent(this, MainActivity2::class.java)
                //객체를 만들어서 보내야 하기에 두번째 방법을 사용할수 없음.
                val loginData = LonginData("admin","123456")
                //만약 데이터 부분에서 Serializable 부분이 없다면 뜨지 않음.(데이터를 외부로 전송시 사용)
                intent.putExtra("loginData",loginData)
                intent.putExtra("no",3)
                startActivity(intent)
            }
            R.id.btnSendPacelObjdect -> {
                val intent = Intent(this, MainActivity2::class.java)
                val loginDataParcel = LoginDataParcel("admin","123456")
                intent.putExtra("no",4)
                intent.putExtra("loginDataParcel",loginDataParcel)
                startActivity(intent)
            }
            R.id.btnSendPaceArrayList -> {
                val intent = Intent(this, MainActivity2::class.java)
                val loginDataParcelList = arrayListOf<LoginDataParcel>()

                loginDataParcelList.add(LoginDataParcel("admin1", "123456-1"))
                loginDataParcelList.add(LoginDataParcel("admin2", "123456-2"))
                loginDataParcelList.add(LoginDataParcel("admin3", "123456-3"))
                loginDataParcelList.add(LoginDataParcel("admin4", "123456-4"))
                intent.putExtra("no", 5)
                intent.putExtra("loginDataParcelList", loginDataParcelList)
                startActivity(intent)
            }
        }
    } //onClick

}