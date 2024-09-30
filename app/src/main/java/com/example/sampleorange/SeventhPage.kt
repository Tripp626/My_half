package com.example.sampleorange

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sampleorange.ui.theme.SampleOrangeTheme

class SeventhPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // This will work now
        setContent {
            SampleOrangeTheme {
                SeventhPageDisplay()
            }
        }
    }
}

@Composable
fun SeventhPageDisplay(modifier: Modifier = Modifier){
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
        
        Row(){
            Text(text = "14$",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 35.sp,
                modifier = Modifier.width(175.dp))
            Buy(175, 60)
        }

       

        Spacer(modifier = Modifier.height(20.dp))

        ToEighthPage()

        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
fun ToEighthPage(){
    val context = LocalContext.current

    Button(onClick = {
        val intent = Intent(context, EighthPage::class.java)
        context.startActivity(intent)
    }) {
        Text(text = "Next Page")
    }
}

@Preview
@Composable
fun SeventhPagePreview() {
    SampleOrangeTheme {
        SeventhPageDisplay()
    }
}
