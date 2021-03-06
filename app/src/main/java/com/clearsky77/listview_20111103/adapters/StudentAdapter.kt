package com.clearsky77.listview_20111103.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.clearsky77.listview_20111103.R
import com.clearsky77.listview_20111103.datas.StudentData

class StudentAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<StudentData>) : ArrayAdapter<StudentData>(mContext, resId, mList){
                                                         // 생성할 때 받는 것을 부모 클래스에 보내준다.
    val mInflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if(tempRow == null){ // 재사용할 뷰가 없으면 (아직 화면 만큼의 뷰가 없으므로 = 뷰가 모자라므로)
            tempRow = mInflater.inflate(resId,null) // xml을 끌어서 준비할 수 있게 해주세요.
        }
        val row = tempRow!!
        val data = mList[position]

        val txtName = row.findViewById<TextView>(R.id.txtName) // 위치를 찾음
        val txtAge = row.findViewById<TextView>(R.id.txtAge)
        val txtAddress = row.findViewById<TextView>(R.id.txtAddress)

        txtName.text = data.name
        txtAddress.text = data.address

//        val age = 2021 - data.birthYear + 1
//        txtAge.text = "(${age}세)"
        txtAge.text = "(${data.getAge(2021).toString()})"

        return row
    }
}