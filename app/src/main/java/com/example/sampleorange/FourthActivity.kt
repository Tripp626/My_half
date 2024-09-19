package com.example.sampleorange

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

class FourthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleOrangeTheme {
                FourthPage()
            }
        }
    }
}

@Composable
fun FourthPage(){
    val scrollState = rememberScrollState()

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth().verticalScroll(scrollState)) {
        Spacer(modifier = Modifier.height(60.dp))

        SearchBar()

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

        FourthFinalText()

        BulletPointsList()

        Next()

        ToFifthPage()

        Spacer(modifier = Modifier.height(60.dp))
    }
}

@Composable
fun SearchBar(){
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
                text = "Search",
                modifier = Modifier
                    .padding(15.dp)
                    .padding(start = 10.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp)

            Spacer(modifier = Modifier.width(120.dp))

            Image(
                painter = painterResource(id = R.drawable.search_168),
                contentDescription = null,
                modifier = Modifier.size(45.dp)
            )
        }


    }
}

@Composable
fun FourthFinalText() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Cras viverra",
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
            modifier = Modifier.padding(horizontal = 30.dp)
        )


        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Cras viverra viverra fusce diam amet. Velit euismod nam amet lectus nunc rhoncus quam iaculis posuere. ",
            lineHeight = 30.sp,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier.padding(horizontal = 30.dp)

        )
    }
}

@Composable
fun BulletPointsList() {
    var selectedBulletIndex by remember {
        mutableIntStateOf(-1)
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        BulletPoint(
            text = "Lorem",
            isSelected = selectedBulletIndex == 0,
            onClick = { selectedBulletIndex = 0 }
        )
        BulletPoint(
            text = "Ipsum",
            isSelected = selectedBulletIndex == 1,
            onClick = { selectedBulletIndex = 1 }
        )
    }
}

@Composable
fun BulletPoint(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 10.dp)
            .clickable(onClick = onClick)
    ) {
        Spacer(modifier = Modifier.width(if (isSelected) 0.dp else 6.dp))
        
        Image(
            painter = painterResource(id = if (isSelected) R.drawable.ticked_bullet_point else R.drawable.empty_bullet_point),
            contentDescription = null,
            modifier = Modifier
                .size(if (isSelected) 50.dp else 37.dp),
            
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = text,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun Next(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = "Next",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
        )

        Image(
            painter = painterResource(id = R.drawable.forward),
            contentDescription = null,
            modifier = Modifier.size(60.dp)
        )

        Spacer(modifier = Modifier.width(30.dp) )
    }
}

@Composable
fun ToFifthPage(){
    val context = LocalContext.current

    Button(onClick = {
        val intent = Intent(context, FifthActivity::class.java)
        context.startActivity(intent)
    }) {
        Text(text = "Next Page")
    }
}


