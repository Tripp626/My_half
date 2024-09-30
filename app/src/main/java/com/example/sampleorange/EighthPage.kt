package com.example.sampleorange

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sampleorange.ui.theme.SampleOrangeTheme

class EighthPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // This will work now
        setContent {
            SampleOrangeTheme {
                EighthPageDisplay()
            }
        }
    }
}

@Composable
fun EighthPageDisplay(modifier: Modifier = Modifier){
    Column( horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier
        .verticalScroll(rememberScrollState())
        .statusBarsPadding()
        .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        
        SearchBar()

        Spacer(modifier = Modifier.height(20.dp))
        
        OrangeWithoutBackground(imageId = R.drawable.green_box_one)

        Spacer(modifier = Modifier.height(20.dp))

        OrangeWithoutBackground(imageId = R.drawable.purple_block_one)

        Spacer(modifier = Modifier.height(20.dp))

        ToNinthPage()

        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
fun ToNinthPage(){
    val context = LocalContext.current

    Button(onClick = {
        val intent = Intent(context, NinthPage::class.java)
        context.startActivity(intent)
    }) {
        Text(text = "Next Page")
    }
}

@Preview
@Composable
fun EighthPagePreview() {
    SampleOrangeTheme {
        EighthPageDisplay()
    }
}