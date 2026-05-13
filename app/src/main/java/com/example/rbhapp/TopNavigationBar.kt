package com.example.rbhapp

import android.content.Intent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopNavigationBar() {

    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),

        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        NavigationButton(
            text = "Home",
            onClick = {

                val intent =
                    Intent(
                        context,
                        MainActivity::class.java
                    )

                context.startActivity(intent)
            }
        )

        NavigationButton(
            text = "Input",
            onClick = {

                val intent =
                    Intent(
                        context,
                        InputActivity::class.java
                    )

                context.startActivity(intent)
            }
        )

        NavigationButton(
            text = "Calendar",
            onClick = {

                val intent =
                    Intent(
                        context,
                        KrishiCalendarActivity::class.java
                    )

                context.startActivity(intent)
            }
        )

        NavigationButton(
            text = "History",
            onClick = {

                val intent =
                    Intent(
                        context,
                        HistoryActivity::class.java
                    )

                context.startActivity(intent)
            }
        )
    }
}

@Composable
fun NavigationButton(
    text: String,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,

        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2E7D32)
        ),

        shape = RoundedCornerShape(18.dp),

        modifier = Modifier
            .width(115.dp)
            .height(55.dp)
    ) {

        Text(
            text = text,
            fontSize = 14.sp
        )
    }
}