package com.example.sampleorange

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sampleorange.ui.theme.SampleOrangeTheme
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleOrangeTheme {
                TopBar()

            }
        }
    }
}

@Composable
fun TopBar(modifier: Modifier = Modifier){
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(40.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.go_back),
                contentDescription = null,
                modifier = Modifier.size(45.dp)
            )
            
            Spacer(modifier = Modifier.width(20.dp))

            Text(
                text = "Nisl velit eget rhoncus lacus purus turpis. In at eu nunc facilisis eu et.",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 35.sp,
                modifier = Modifier.width(300.dp),
                maxLines = 1,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
                lineHeight = 40.sp
                )

        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            DropDownBar()
        }

        Spacer(modifier = Modifier.height(30.dp))

        Box {
            DescriptionAndIcons()
            MainImage()
        }

        Spacer(modifier = Modifier.height(30.dp))

        FinalText()

        ToSecondPage()
    }

}

@Composable
fun DropDownBar() {
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
                text = "Dropdown",
                modifier = Modifier
                    .padding(15.dp)
                    .padding(start = 10.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp)

            Spacer(modifier = Modifier.width(90.dp))

            Image(
                painter = painterResource(id = R.drawable.arrow_down),
                contentDescription = null,
                modifier = Modifier.size(45.dp)
            )
        }


    }
}

@Composable
fun MainImage(){
    Box(modifier = Modifier
        .width(350.dp)
        .height(306.dp)
        .clip(shape = RoundedCornerShape(50.dp))
    ){
        Image(
            painter = painterResource(id = R.drawable.orange_in_jar),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            //contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun DescriptionAndIcons(){
    Box(modifier = Modifier
        .height(400.dp)
        .width(350.dp)
        .border(3.dp, color = Color.Gray, shape = RoundedCornerShape(50.dp))
    ) {
        Column {
            Spacer(modifier = Modifier.height(306.dp))

            Row(modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Lorem ipsum",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    modifier =  Modifier.padding(20.dp)
                )
                
                Spacer(modifier = Modifier.width(10.dp))

                Image(
                    painter = painterResource(R.drawable.shopping_cart_empty_2),
                    contentDescription = null,
                    modifier = Modifier.size(45.dp)
                )
                
                Spacer(modifier = Modifier.width(15.dp))

                Image(
                    painter = painterResource(R.drawable.arrow_down),
                    contentDescription = null,
                    modifier = Modifier.size(45.dp)
                )

            }
        }

    }

}

@Composable
fun FinalText(){
    Text(text = "Risus tristique commodo sed sit nulla quisque interdum mi varius. Velit euismod nam amet lectus nunc rhoncus quam iaculis posuere. Cras viverra viverra fusce diam amet. ",
        lineHeight = 30.sp,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp,
        modifier =  Modifier.padding(horizontal = 30.dp)

    )
}

@Composable
fun ToSecondPage(){
    val context = LocalContext.current

    Button(onClick = {
        val intent = Intent(context, SecondActivity::class.java)
        context.startActivity(intent)
    }) {
        Text(text = "Next Page")
    }
}