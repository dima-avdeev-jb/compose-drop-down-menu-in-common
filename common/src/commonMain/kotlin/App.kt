import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@Composable
fun App() {
    MaterialTheme {
        var showMaterialDropDownMenu by remember { mutableStateOf(false) }
        var showMaterial3DropDownMenu by remember { mutableStateOf(false) }
        Box(contentAlignment = Alignment.Center) {
            Column {
                Button(onClick = {
                    showMaterialDropDownMenu = !showMaterialDropDownMenu
                }) {
                    Text("Material DropDownDenu")
                }
                Button(onClick = {
                    showMaterial3DropDownMenu = !showMaterial3DropDownMenu
                }) {
                    Text("Material 3 WrapMaterial3DropDownMenu")
                }
            }
            DropdownMenu(
                expanded = showMaterialDropDownMenu,
                onDismissRequest = {}
            ) {
                val text = "I am DropdownMenu from material"
                Text(text)
                Text(text)
                Text(text)
                Button(onClick = { showMaterialDropDownMenu = false }) {
                    Text("Close")
                }
            }
            WrapMaterial3DropDownMenu(
                expanded = showMaterial3DropDownMenu,
                onDismissRequest = {}
            ) {
                val text = "I am DropdownMenu from material 3"
                Text(text)
                Text(text)
                Text(text)
                Button(onClick = { showMaterial3DropDownMenu = false }) {
                    Text("Close")
                }
            }
        }
    }
}

@Composable
expect fun WrapMaterial3DropDownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    focusable: Boolean = true,
    modifier: Modifier = Modifier,
    offset: DpOffset = DpOffset(0.dp, 0.dp),
    content: @Composable ColumnScope.() -> Unit
)

