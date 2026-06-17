package `in`.microkid.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import `in`.microkid.counterapp.ui.theme.CounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CounterScreen(
    modifier: Modifier = Modifier ,
    counterViewModel: CounterViewModel = viewModel()
)   {
    val currentCount by counterViewModel.count.collectAsStateWithLifecycle()

    CounterContent(
        count = currentCount,
        onIncrement = { counterViewModel.incrementCount() },
        onDecrement = { counterViewModel.decrementCount() }
    )
}

@Composable
fun CounterContent(
    count: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit
)   {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Count: $count",
            fontSize = 36.sp
        )

        Row {
            Button(
                onClick = onIncrement
            ) {
                Text("Increment Counter")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = onDecrement
            ) {
                Text("Decrement Counter")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CounterAppTheme {
        CounterScreen()
    }
}