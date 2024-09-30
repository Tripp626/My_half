package com.example.sampleorange

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sampleorange.ui.theme.SampleOrangeTheme

class NinthPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // This will work now
        setContent {
            SampleOrangeTheme {
                NinthPageDisplay()
            }
        }
    }
}

@Composable
fun NinthPageDisplay(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier
            .verticalScroll(rememberScrollState())
            .statusBarsPadding()
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        SearchBar()

        Spacer(modifier = Modifier.height(20.dp))

        ThumbnailAndImage()

        Spacer(modifier = Modifier.height(20.dp))

        ToHomePage()

        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
fun ThumbnailAndImage(){
    var thumbNailHighlighted by remember { mutableStateOf(false) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .width(350.dp)
                .height(70.dp)
                .border(3.dp, colorResource(id = R.color.teal_200), RoundedCornerShape(12.dp))
                .clip(shape = RoundedCornerShape(12.dp))
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .width(175.dp)
                        .fillMaxHeight()
                        .clickable { thumbNailHighlighted = true }
                        .background(
                            if (thumbNailHighlighted) colorResource(id = R.color.teal_200) else colorResource(
                                id = R.color.white
                            )
                        ),

                    ){
                    Text(
                        text = "Thumbnails",
                        modifier = Modifier.align(Alignment.Center),
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                }

                Box(
                    modifier = Modifier
                        .width(175.dp)
                        .fillMaxHeight()
                        .clickable { thumbNailHighlighted = false }
                        .background(
                            if (thumbNailHighlighted) colorResource(id = R.color.white) else colorResource(
                                id = R.color.teal_200
                            )
                        ),
                ){
                    Text(
                        text = "Images",
                        modifier = Modifier.align(Alignment.Center),
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (thumbNailHighlighted){
            ThumbnailBody()
        }else{
            ImageBody()
        }
    }


}

@Composable
fun PageFourContent(){

}

@Composable
fun ImageBody(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        OrangeWithoutBackground(imageId = R.drawable.green_block_two, height = 140)

        Spacer(modifier = Modifier.height(20.dp))

        FourthFinalText(
            header = "Risus tristique",
            headerSize = 28,
            body = "Velit euismod nam amet lectus nunc rhoncus quam iaculis posuere. Cras viverra viverra fusce diam amet. ",
            bodySize = 20
        )

        Spacer(modifier = Modifier.height(20.dp))

        OrangeWithoutBackground(imageId = R.drawable.orange_block_two, height = 140)

        Spacer(modifier = Modifier.height(20.dp))

        FourthFinalText(
            header = "Cras viverra",
            headerSize = 28,
            body = "Cras viverra viverra fusce diam amet. Velit euismod nam amet lectus nunc rhoncus quam iaculis posuere. ",
            bodySize = 20
        )
    }

}

@Composable
fun ToTenthPage(){
    val context = LocalContext.current

    Button(onClick = {
        val intent = Intent(context, TenthPage::class.java)
        context.startActivity(intent)
    }) {
        Text(text = "Next Page")
    }
}

@Preview
@Composable
fun NinthPagePreview() {
    SampleOrangeTheme {
        NinthPageDisplay()
    }
}
