package com.example.customchar

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.customchar.ui.theme.Purple500

@Composable
fun Chart(
    data: Map<Float, Int>,
    max_value: Int
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(50.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start
        ) {

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(50.dp),
                contentAlignment = Alignment.BottomCenter
            ) {

                // scale
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(text = max_value.toString())
                    Spacer(modifier = Modifier.fillMaxHeight())
                }

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(text = (max_value / 2).toString())
                    Spacer(modifier = Modifier.fillMaxHeight(0.5f))
                }

            }

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(2.dp)
                    .background(Color.Black)
            )

            // graph
            data.forEach {
                Box(
                    modifier = Modifier
                        .padding(start = 20.dp, bottom = 5.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .width(20.dp)
                        .fillMaxHeight(it.key)
                        .background(Purple500)
                        .clickable {
                            Toast
                                .makeText(context, it.key.toString(), Toast.LENGTH_SHORT)
                                .show()
                        }
                )
            }

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(Color.Black)
        )

        Row(
            modifier = Modifier
                .padding(start = 72.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            data.values.forEach {
                Text(
                    modifier = Modifier.width(20.dp),
                    text = it.toString(),
                    textAlign = TextAlign.Center
                )
            }

        }

    }

}








