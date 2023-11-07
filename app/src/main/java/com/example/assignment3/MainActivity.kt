package com.example.assignment3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment3.ui.theme.Assignment3Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        val tableLayout = findViewById<TableLayout>(R.id.tblAndroid)
        tableLayout.addView(addRow("Android 1", "Beso"))

        val versionEditText : EditText = findViewById(R.id.editTxtVersionNumber)
        val versionCodeName : EditText = findViewById(R.id.editTxtVersionName)
        val btnAdd : Button = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener{
            tableLayout.addView(addRow(versionEditText.text.toString(),versionCodeName.text.toString()))
            versionCodeName.text.clear()
            versionEditText.text.clear()
            Toast.makeText(applicationContext,"Version Added",Toast.LENGTH_SHORT).show()
        }

    }

    private fun addRow (version : String, codeName: String): TableRow{
        val tableRow = TableRow(this)
        val layoutParams = TableLayout.LayoutParams(
            TableLayout.LayoutParams.MATCH_PARENT,
            TableLayout.LayoutParams.WRAP_CONTENT,
        )
        tableRow.layoutParams = layoutParams

        val versionTextView = TextView(this)
        val codeNameTextView = TextView(this)

        val cellParams = TableRow.LayoutParams(
            TableRow.LayoutParams.WRAP_CONTENT,
            TableRow.LayoutParams.WRAP_CONTENT
        )

        versionTextView.text = version
        versionTextView.layoutParams = cellParams
        versionTextView.setPadding(10, 10, 10, 10)

        codeNameTextView.text = codeName
        codeNameTextView.layoutParams = cellParams
        codeNameTextView.setPadding(10, 10, 10, 10)

        tableRow.addView(versionTextView)
        tableRow.addView(codeNameTextView)

        return tableRow
    }
}

