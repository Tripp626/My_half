package com.example.sampleorange

import android.content.Intent
import androidx.activity.ComponentActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sampleorange.ui.theme.SampleOrangeTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // This will work now
        setContent {
            SampleOrangeTheme {
                SecondPage()
            }
        }
    }
}

@Composable
fun SecondPage(modifier: Modifier = Modifier){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(50.dp))

        Top()

        Spacer(modifier = Modifier.height(20.dp))

        OrangeBar()

        Spacer(modifier = Modifier.height(20.dp))

        OrangeWithoutBackground()
        
        Spacer(modifier = Modifier.height(20.dp))

        SecondFinalText()

        ToThirdPage()

    }
}

@Composable
fun Top(){
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.list_28),
            contentDescription = null,
            modifier = Modifier.size(45.dp)
        )

        Spacer(modifier = Modifier.width(130.dp))

        Text(
            text = "tristique",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 35.sp,
        )

        Spacer(modifier = Modifier.width(20.dp))

        Image(
            painter = painterResource(id = R.drawable.loop_32),
            contentDescription = null,
            modifier = Modifier.size(35.dp)
        )

    }
}

@Composable
fun OrangeBar(){
    Box(
        modifier = Modifier
            .width(350.dp)
            .height(70.dp)
            .border(3.dp, Color.Gray, RoundedCornerShape(30.dp))
    ) {
        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Orange",
                modifier = Modifier
                    .padding(15.dp)
                    .padding(start = 10.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp)

            Spacer(modifier = Modifier.width(140.dp))

            Image(
                painter = painterResource(id = R.drawable.cancel_27),
                contentDescription = null,
                modifier = Modifier.size(45.dp)
            )
        }


    }
}

@Composable
fun OrangeWithoutBackground(){
    Box(modifier = Modifier
        .width(350.dp)
        .height(306.dp)
        .clip(shape = RoundedCornerShape(50.dp))
    ){
        Image(
            painter = painterResource(id = R.drawable.orange_without_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            //contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun SecondFinalText(){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Lacus purus turpis",
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
            modifier = Modifier.padding(horizontal = 30.dp)
        )


        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Risus tristique commodo sed sit nulla quisque interdum mi varius. Velit euismod nam amet lectus nunc rhoncus quam iaculis posuere. Cras viverra viverra fusce diam amet. ",
            lineHeight = 30.sp,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier =  Modifier.padding(horizontal = 30.dp)

        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.width(30.dp))

            Image(painter = painterResource(
                id = R.drawable.shopping_cart_empty_2),
                contentDescription = null,
                modifier = Modifier
                    .size(45.dp)
            )

            Text(
                text = "commodo",
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp,
                modifier = Modifier.padding(horizontal = 30.dp)
            )
        }

    }

}

@Composable
fun ToThirdPage(){
    val context = LocalContext.current

    Button(onClick = {
        val intent = Intent(context, ThirdActivity::class.java)
        context.startActivity(intent)
    }) {
        Text(text = "Next Page")
    }
}


