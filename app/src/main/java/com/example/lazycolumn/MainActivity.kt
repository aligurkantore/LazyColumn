package com.example.lazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lazycolumn.model.Item
import androidx.compose.foundation.lazy.items
import com.example.lazycolumn.ui.theme.LazyColumnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyColumnTheme {
                MyList()
            }
        }
    }
}

@Composable
fun MyList() {
    val items = listOf(
        Item("Item 1"),
        Item("Item 2"),
        Item("Item 3"),
        Item("Item 4"),
        Item("Item 5"),
        Item("Item 6"),
        Item("Item 7"),
        Item("Item 8"),
        Item("Item 9")
    )
    ItemList(items)
}

@Composable
fun ItemList(items: List<Item>) {
    LazyColumn(
        modifier = Modifier.padding(vertical = 32.dp)
    ) {
        items(items) {
            ItemRow(it)
        }
    }
}

@Composable
fun ItemRow(item: Item) {
    item.name?.let { Text(text = it, modifier = Modifier.padding(16.dp)) }
}