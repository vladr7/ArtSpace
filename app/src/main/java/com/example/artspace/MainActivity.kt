package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtScreen()
                }
            }
        }
    }
}

@Composable
fun ArtScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxHeight(),
    ) {
        var painterResourceID by remember {
            mutableStateOf(R.drawable.image1)
        }
        var artTitle by remember {
            mutableStateOf("Title")
        }
        var artist by remember {
            mutableStateOf("Artist")
        }

        Image(
            painter = painterResource(id = painterResourceID), contentDescription = null,
            modifier = Modifier
                .border(width = 3.dp, color = Color.DarkGray, shape = RectangleShape)
                .shadow(elevation = 4.dp, shape = RectangleShape, clip = false)
                .padding(30.dp)
        )
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .weight(1f)
        )

        ArtTitle(
            title = artTitle, artist = artist,
        )
        Spacer(modifier = Modifier.height(10.dp))

        PreviousNextButtons(
            modifier = Modifier
                .width(200.dp)
                .padding(5.dp)
        )
    }
}

@Composable
fun ArtTitle(
    title: String,
    artist: String,
) {
    Column(
        modifier = Modifier
            .shadow(elevation = 4.dp, shape = RectangleShape, clip = false)
            .padding(30.dp)
    ) {
        Text(text = title, fontSize = 22.sp)
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = artist, fontWeight = FontWeight.Bold, fontSize = 14.sp)
    }
}

@Composable
fun PreviousNextButtons(
    modifier: Modifier = Modifier
) {
    Row {
        Button(
            onClick = { /*TODO*/ },
            modifier = modifier
        ) {
            Text(text = "Previous")
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = modifier
        ) {
            Text(text = "Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtScreen()
    }
}