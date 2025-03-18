package edu.dixietech.alanmcgraw.thirtydays.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.dixietech.alanmcgraw.thirtydays.R
import edu.dixietech.alanmcgraw.thirtydays.Days
import edu.dixietech.alanmcgraw.thirtydays.days
import edu.dixietech.alanmcgraw.thirtydays.ui.theme._30DaysTheme

// MAIN APP
@Composable
fun ThirtyDaysApp(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            ThirtyDayTopAppBar()
        },
        modifier = modifier
    ) { padding ->
        LazyColumn(
            contentPadding = padding
        ) {
            items(days) {
                DailyItem(
                    days = it,
                    modifier = Modifier
                        .padding(8.dp),

                )
            }
        }
    }
}

// TOP NAV BAR
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ThirtyDayTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.golf_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .padding(8.dp)
                        .clip(MaterialTheme.shapes.small)
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.headlineLarge
                )
            }
        },
        modifier = modifier
    )
}

// DAILY ITEM
@Composable
fun DailyItem(
    modifier: Modifier = Modifier,
    days: Days
) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (isExpanded) MaterialTheme.colorScheme.secondaryContainer
        else MaterialTheme.colorScheme.secondary,
        animationSpec = tween(
            durationMillis = 500,
            easing = EaseInOut)
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(4.dp, MaterialTheme.colorScheme.secondary, MaterialTheme.shapes.small)

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .background(color)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {

                if (!isExpanded) {
                    DailyPic(
                        days.imageResources,
                        isExpanded = false,
                    )
                }

                Text(
                    text = stringResource(days.dayName),
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.inverseOnSurface,
                    modifier = Modifier
                        .padding(10.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                ExpandMoreButton(
                    isExpanded = isExpanded,
                    onExpandedChanged = { isExpanded = it }
                )
            }

            if (isExpanded) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    DailyPic(
                        dayIcon = days.imageResources,
                        isExpanded = true
                    )

                    DailyQuote(
                        dayQuote = days.quote,
                        dayAuthor = days.author,
                        modifier = Modifier.padding( 16.dp)
                    )
                }
            }
        }
    }
}

// DAILY PIC
@Composable
fun DailyPic(
    @DrawableRes dayIcon: Int,
    isExpanded: Boolean,
    modifier: Modifier = Modifier
) {
    
    val imageSize = if (isExpanded) 300.dp else 96.dp
    
    Image(
        painter = painterResource(dayIcon),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .border(4.dp, MaterialTheme.colorScheme.secondary, shape = MaterialTheme.shapes.small)
            .size(imageSize)
//            .padding(8.dp)
            .clip(MaterialTheme.shapes.small)
    )
}

// DAILY QUOTE
@Composable
fun DailyQuote(
    @StringRes dayAuthor: Int,
    @StringRes dayQuote: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(dayQuote),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.surface,
        )

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = stringResource(dayAuthor),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.surface,
            )
        }
    }
}

// EXPAND MORE BUTTON
@Composable
fun ExpandMoreButton(
    isExpanded: Boolean,
    onExpandedChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = { onExpandedChanged(!isExpanded) },
        modifier = modifier
    ) {
        Icon(
            imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_to_see_your_daily_quote),
            tint = MaterialTheme.colorScheme.surface
        )
    }
}

// PREVIEW
@Preview(showBackground = true)
@Composable
private fun ThirtyDayAppPreview() {
    _30DaysTheme {
        ThirtyDaysApp()
    }
}