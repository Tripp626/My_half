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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sampleorange.ui.theme.SampleOrangeTheme

class TenthPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // This will work now
        setContent {
            SampleOrangeTheme {
                TenthPageDisplay()
            }
        }
    }
}

@Composable
fun TenthPageDisplay(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier
            .verticalScroll(rememberScrollState())
            .statusBarsPadding()
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        SearchBar()

        Spacer(modifier = Modifier.height(20.dp))

        ThumbnailsAndImagesRight()

        Spacer(modifier = Modifier.height(20.dp))

        ThumbnailBody()

        Spacer(modifier = Modifier.height(20.dp))

        ToHomePage()

        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
fun ThumbnailBody(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Thumbnail(
            imageId = R.drawable.green_block_three,
            header = "Risus tristique",
            body = "Velit euismod nam amet lectus nunc rhoncus quam iaculis posuere. Cras viverra viverra fusce diam amet. "
        )

        Spacer(modifier = Modifier.height(20.dp))

        Thumbnail(
            imageId = R.drawable.orange_block_three,
            header = "Cras viverra",
            body = "Cras viverra viverra fusce diam amet. Velit euismod nam amet lectus nunc rhoncus quam iaculis posuere. "
        )

        Spacer(modifier = Modifier.height(20.dp))

        Thumbnail(
            imageId = R.drawable.purple_block_three,
            header = "Risus tristique",
            body = "Velit euismod nam amet lectus nunc rhoncus quam iaculis posuere. Cras viverra viverra fusce diam amet. "
        )

        Spacer(modifier = Modifier.height(20.dp))

        Thumbnail(
            imageId = R.drawable.blue_block_three,
            header = "Risus tristique",
            body = "Velit euismod nam amet lectus nunc rhoncus quam iaculis posuere. Cras viverra viverra fusce diam amet. "
        )
    }

}

@Composable
fun ThumbnailsAndImagesRight(){
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
                    .background(color = colorResource(id = R.color.teal_200)),
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
}

@Composable
fun Thumbnail(imageId: Int, header: String, body: String){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp)
    ) {
        OrangeWithoutBackground(imageId = imageId, width = 170, height = 170)
        
        FourthFinalText(header = header, headerSize = 23, body = body, bodySize = 16, lineHeight = 20)
    }
}

@Composable
fun ToHomePage(){
    val context = LocalContext.current

    Button(onClick = {
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }) {
        Text(text = "Next Page")
    }
}

@Preview
@Composable
fun TenthPagePreview() {
    SampleOrangeTheme {
        TenthPageDisplay()
    }
}