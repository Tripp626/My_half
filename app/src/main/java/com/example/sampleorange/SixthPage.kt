package com.example.sampleorange

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sampleorange.ui.theme.SampleOrangeTheme

class SixthPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // This will work now
        setContent {
            SampleOrangeTheme {
                SixthPageDisplay()
            }
        }
    }
}

@Composable
fun SixthPageDisplay(modifier: Modifier = Modifier) {
    Column( horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier
        .verticalScroll(rememberScrollState())
        .statusBarsPadding()
        .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        OrangeWithoutBackground(imageId = R.drawable.orange_with_purple_background)
        
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Nisl velit eget rhoncus lacus purus turpis. In at eu nunc facilisis eu et.",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 35.sp,
            modifier = Modifier.width(300.dp),
            maxLines = 1,
            overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis,
            lineHeight = 40.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        FinalText(text = "Nisl velit eget rhoncus elementum sed tincidunt risus viverra. Risus tristique commodo sed sit nulla quisque interdum mi varius. Velit euismod nam amet lectus nunc rhoncus quam iaculis posuere. Cras viverra viverra fusce diam amet. ")

        Spacer(modifier = Modifier.height(20.dp))

        Buy(350, 60)

        Spacer(modifier = Modifier.height(20.dp))

        ToSeventhPage()

        Spacer(modifier = Modifier.height(50.dp))
    }
}


@Composable
fun Buy(width: Int, height: Int){
    Box(
        modifier = Modifier
            .width(width.dp)
            .height(height.dp)
            .clickable { }
            .background(
                color = colorResource(id = R.color.purple_500),
                shape = RoundedCornerShape(10.dp)
            ),
        contentAlignment = Alignment.Center

    ){
        Text(
            text = "Buy",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
            modifier = Modifier.padding(horizontal = 30.dp)
        )
    }
}

@Composable
fun ToSeventhPage(){
    val context = LocalContext.current

    Button(onClick = {
        val intent = Intent(context, SeventhPage::class.java)
        context.startActivity(intent)
    }) {
        Text(text = "Next Page")
    }
}

@Preview
@Composable
fun SixthPagePreview() {
    SampleOrangeTheme {
        SixthPageDisplay()
    }
}