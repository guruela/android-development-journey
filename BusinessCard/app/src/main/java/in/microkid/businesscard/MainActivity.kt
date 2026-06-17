package `in`.microkid.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `in`.microkid.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        color = Color(0xFFcfe3cf),
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        BusinessCard(
                            name = "Gurucharan Shivakumar",
                            designation = "ME VLSI DESIGN",
                            number = "+91 9585613325",
                            social = "@itsguru13",
                            email = "gurushivkrish@gmail.com"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, designation: String, number: String, social: String, email: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(18.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = modifier
                    .size(100.dp)
                    .background(Color(0xFF073042))
            )

            Text(
                text = name,
                fontSize = 32.sp,
                fontWeight = FontWeight.W300
            )

            Text(
                text = designation,
                fontSize = 20.sp,
                fontWeight = FontWeight.W300
            )
        }
    }

    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(18.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.padding(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.Call,
                    contentDescription = null,
                )

                Spacer(modifier.width(16.dp))
                Text(
                    text = number
                )
            }

            Row(
//                horizontalArrangement = Arrangement.Center
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = null,
                )

                Spacer(modifier.width(16.dp))
                Text(
                    text = social
                )
            }

            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = null,
                )

                Spacer(modifier.width(16.dp))
                Text(
                    text = email
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        Surface(
            color = Color(0xFFcfe3cf),
            modifier = Modifier.fillMaxSize(),
        ) {
            BusinessCard(
                name = "Gurucharan Shivakumar",
                designation = "ME VLSI DESIGN",
                number = "+91 9585613325",
                social = "@itsguru13",
                email = "gurushivkrish@gmail.com"
            )
        }
    }
}