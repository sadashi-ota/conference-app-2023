package io.github.droidkaigi.confsched2023.sessions.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.droidkaigi.confsched2023.designsystem.preview.MultiThemePreviews
import io.github.droidkaigi.confsched2023.designsystem.theme.KaigiTheme
import io.github.droidkaigi.confsched2023.model.DroidKaigi2023Day
import io.github.droidkaigi.confsched2023.sessions.SessionsStrings

@Composable
fun BookmarkFilters(
    isAll: Boolean,
    isDayFirst: Boolean,
    isDaySecond: Boolean,
    isDayThird: Boolean,
    onAllFilterChipClick: () -> Unit,
    onDayFirstChipClick: () -> Unit,
    onDaySecondChipClick: () -> Unit,
    onDayThirdChipClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(modifier) {
        BookmarkFilterChip(
            labelText = SessionsStrings.BookmarkFilterAllChip.asString(),
            isSelected = isAll,
            onClick = onAllFilterChipClick,
        )
        Spacer(modifier = Modifier.size(8.dp))
        BookmarkFilterChip(
            labelText = DroidKaigi2023Day.Day1.name,
            isSelected = isDayFirst,
            onClick = onDayFirstChipClick,
        )
        Spacer(modifier = Modifier.size(8.dp))
        BookmarkFilterChip(
            labelText = DroidKaigi2023Day.Day2.name,
            isSelected = isDaySecond,
            onClick = onDaySecondChipClick,
        )
        Spacer(modifier = Modifier.size(8.dp))
        BookmarkFilterChip(
            labelText = DroidKaigi2023Day.Day3.name,
            isSelected = isDayThird,
            onClick = onDayThirdChipClick,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BookmarkFilterChip(
    labelText: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    val selectedChipColor = FilterChipDefaults.filterChipColors(
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        labelColor = MaterialTheme.colorScheme.onSecondaryContainer,
    )
    val selectedChipBoarderColor = FilterChipDefaults.filterChipBorder(
        borderColor = MaterialTheme.colorScheme.outline,
        borderWidth = 0.dp,
    )
    FilterChip(
        onClick = onClick,
        label = {
            ChipInnerText(labelText)
        },
        leadingIcon = {
            if (isSelected) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp),
                )
            }
        },
        colors = if (isSelected) {
            selectedChipColor
        } else {
            FilterChipDefaults.filterChipColors()
        },
        border = if (isSelected) {
            selectedChipBoarderColor
        } else {
            FilterChipDefaults.filterChipBorder()
        },
        selected = isSelected,
    )
}

@Composable
private fun ChipInnerText(name: String) {
    Text(
        text = name,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
    )
}

@MultiThemePreviews
@Composable
fun BookmarkFiltersPreview() {
    KaigiTheme {
        Surface {
            BookmarkFilters(
                isAll = false,
                isDayFirst = true,
                isDaySecond = false,
                isDayThird = false,
                onAllFilterChipClick = {},
                onDayFirstChipClick = {},
                onDaySecondChipClick = {},
                onDayThirdChipClick = {},
            )
        }
    }
}
