package it.alexm.composelesson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.alexm.composelesson.ui.theme.ComposeLessonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLessonTheme {
                Messages("Alessandro", "Marta", "Roberta")
            }
        }
    }
}

@Composable
fun Messages(vararg msgs: String) {
    Row {
        Box(
            modifier = Modifier.padding(
                start = 16.dp,
                top = 20.dp,
                bottom = 20.dp
            )
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Example image",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
                    .background(MaterialTheme.colors.secondaryVariant, CircleShape)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
            Column(
                modifier = Modifier.padding(all = 4.dp),
            ) {
                msgs.mapIndexed { i, it ->
                    val text = "Hello $it!"
                    if (i == 0)

                        Text(
                            text = text,
                            color = MaterialTheme.colors.secondaryVariant,
                            style = MaterialTheme.typography.subtitle2
                        )
                    else
                        Text(
                            text = text,
                            style = MaterialTheme.typography.body2
                        )
                    if (i != msgs.lastIndex) Spacer(modifier = Modifier.height(4.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeLessonTheme {
        Messages("Preview", "Prova1", "Prova2")
    }
}