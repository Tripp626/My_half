package com.example.sampleorange

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sampleorange.ui.theme.SampleOrangeTheme

class ThirdActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // This will work now
        setContent {
            SampleOrangeTheme {
                ThirdPage()
            }
        }
    }
}

@Composable
fun ThirdPage(){
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(60.dp))

        OrangeBar()

        Spacer(modifier = Modifier.height(20.dp))

        Box(modifier = Modifier
            .width(350.dp)
            .height(306.dp)
            .clip(shape = RoundedCornerShape(50.dp))
        ){
            Image(
                painter = painterResource(id = R.drawable.orange_with_background),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                //contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        ToFourthPage()
    }
}

@Composable
fun ToFourthPage(){
    val context = LocalContext.current

    Button(onClick = {
        val intent = Intent(context, FourthActivity::class.java)
        context.startActivity(intent)
    }) {
        Text(text = "Next Page")
    }
}
