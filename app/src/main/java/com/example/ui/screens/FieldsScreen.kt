package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Construction
import androidx.compose.material.icons.filled.Devices
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Flight
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.Memory
import androidx.compose.material.icons.filled.Nature
import androidx.compose.material.icons.filled.PrecisionManufacturing
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.EngineeringData
import com.example.data.EngineeringField
import com.example.ui.components.BlueprintGridBackground
import com.example.ui.components.EngineeringCard
import com.example.ui.components.SectionHeader
import com.example.ui.components.TechBadge
import com.example.ui.theme.BorderDark
import com.example.ui.theme.BorderLight
import com.example.ui.theme.CardBackground
import com.example.ui.theme.DeepNavy
import com.example.ui.theme.ElectricBlue
import com.example.ui.theme.EngineeringOrange
import com.example.ui.theme.SuccessGreen
import com.example.ui.theme.SurfaceElevated
import com.example.ui.theme.SurfaceVariantDark
import com.example.ui.theme.TechCyan
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary
import com.example.ui.theme.TextTertiary

@Composable
fun FieldsScreen(
    initialSelectedFieldId: String? = null,
    modifier: Modifier = Modifier
) {
    var expandedFieldId by remember { mutableStateOf(initialSelectedFieldId) }
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategoryFilter by remember { mutableStateOf("All") }

    val categories = listOf("All", "Infrastructure", "Mechanisms", "Energy & Power", "Digital & Silicon", "Advanced Materials", "Bio & Eco")

    val filteredFields = EngineeringData.fields.filter { field ->
        val matchesSearch = field.title.contains(searchQuery, ignoreCase = true) ||
                field.shortDescription.contains(searchQuery, ignoreCase = true) ||
                field.fullDescription.contains(searchQuery, ignoreCase = true) ||
                field.commonTechnologies.any { it.contains(searchQuery, ignoreCase = true) } ||
                field.exampleCareers.any { it.contains(searchQuery, ignoreCase = true) }

        val matchesCategory = when (selectedCategoryFilter) {
            "Infrastructure" -> field.id in listOf("civil", "environmental")
            "Mechanisms" -> field.id in listOf("mechanical", "aerospace", "industrial")
            "Energy & Power" -> field.id in listOf("electrical", "chemical")
            "Digital & Silicon" -> field.id in listOf("computer", "electronics")
            "Advanced Materials" -> field.id in listOf("chemical", "materials")
            "Bio & Eco" -> field.id in listOf("biomedical", "environmental")
            else -> true
        }

        matchesSearch && matchesCategory
    }

    Box(modifier = modifier.fillMaxSize()) {
        BlueprintGridBackground(modifier = Modifier.fillMaxSize())

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header
            item {
                SectionHeader(
                    title = "Engineering Fields",
                    subtitle = "10 core disciplines shaping the modern technological world",
                    icon = Icons.Default.Construction,
                    badgeText = "${EngineeringData.fields.size} Disciplines",
                    badgeColor = ElectricBlue
                )
            }

            // Search and Filter Bar
            item {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { Text("Search disciplines, technologies, careers...", color = TextTertiary) },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = TechCyan) },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("fields_search_input"),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = TechCyan,
                        unfocusedBorderColor = BorderDark,
                        focusedContainerColor = SurfaceVariantDark,
                        unfocusedContainerColor = SurfaceVariantDark,
                        focusedTextColor = TextPrimary,
                        unfocusedTextColor = TextPrimary
                    ),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(categories) { category ->
                        val isSelected = selectedCategoryFilter == category
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(if (isSelected) TechCyan else SurfaceVariantDark)
                                .border(
                                    1.dp,
                                    if (isSelected) TechCyan else BorderDark,
                                    RoundedCornerShape(8.dp)
                                )
                                .clickable { selectedCategoryFilter = category }
                                .padding(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Text(
                                text = category,
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                color = if (isSelected) DeepNavy else TextSecondary
                            )
                        }
                    }
                }
            }

            // Fields List
            items(filteredFields) { field ->
                val isExpanded = expandedFieldId == field.id
                FieldCard(
                    field = field,
                    isExpanded = isExpanded,
                    onToggleExpand = {
                        expandedFieldId = if (isExpanded) null else field.id
                    }
                )
            }
        }
    }
}

@Composable
fun FieldCard(
    field: EngineeringField,
    isExpanded: Boolean,
    onToggleExpand: () -> Unit
) {
    val fieldColor = Color(field.badgeColorHex)
    val fieldIcon = when (field.id) {
        "civil" -> Icons.Default.Business
        "mechanical" -> Icons.Default.PrecisionManufacturing
        "electrical" -> Icons.Default.Bolt
        "electronics" -> Icons.Default.Memory
        "chemical" -> Icons.Default.Science
        "computer" -> Icons.Default.Code
        "environmental" -> Icons.Default.Nature
        "aerospace" -> Icons.Default.Flight
        "industrial" -> Icons.Default.Work
        "biomedical" -> Icons.Default.LocalHospital
        else -> Icons.Default.Construction
    }

    EngineeringCard(
        borderColor = if (isExpanded) fieldColor.copy(alpha = 0.6f) else BorderDark,
        backgroundColor = if (isExpanded) SurfaceVariantDark else CardBackground,
        onClick = onToggleExpand,
        modifier = Modifier.testTag("field_card_${field.id}")
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(fieldColor.copy(alpha = 0.15f))
                            .border(1.dp, fieldColor.copy(alpha = 0.35f), RoundedCornerShape(10.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = fieldIcon,
                            contentDescription = null,
                            tint = fieldColor,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = field.title,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                        Text(
                            text = field.shortDescription,
                            style = MaterialTheme.typography.bodySmall,
                            color = TextSecondary,
                            maxLines = if (isExpanded) Int.MAX_VALUE else 2
                        )
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = null,
                    tint = if (isExpanded) fieldColor else TextTertiary
                )
            }

            AnimatedVisibility(
                visible = isExpanded,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Column(modifier = Modifier.padding(top = 16.dp)) {
                    // Full description
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(SurfaceElevated)
                            .padding(14.dp)
                    ) {
                        Text(
                            text = field.fullDescription,
                            style = MaterialTheme.typography.bodyMedium,
                            color = TextPrimary,
                            lineHeight = 20.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Key Responsibilities
                    Text(
                        text = "Main Responsibilities",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = fieldColor
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    field.mainResponsibilities.forEach { resp ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 3.dp),
                            verticalAlignment = Alignment.Top
                        ) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null,
                                tint = fieldColor,
                                modifier = Modifier
                                    .size(16.dp)
                                    .padding(top = 2.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = resp,
                                style = MaterialTheme.typography.bodyMedium,
                                color = TextPrimary
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Common Technologies & Tools
                    Text(
                        text = "Common Technologies & Software",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = fieldColor
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        field.commonTechnologies.take(3).forEach { tech ->
                            TechBadge(text = tech, color = TechCyan)
                        }
                    }
                    if (field.commonTechnologies.size > 3) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            field.commonTechnologies.drop(3).forEach { tech ->
                                TechBadge(text = tech, color = ElectricBlue)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Example Careers & Flagship Projects
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Example Careers",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = fieldColor
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            field.exampleCareers.forEach { career ->
                                Text(
                                    text = "• $career",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = TextSecondary
                                )
                            }
                        }

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Flagship Projects",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = fieldColor
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            field.realWorldExamples.forEach { example ->
                                Text(
                                    text = "• $example",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = TextSecondary
                                )
                            }
                        }
                    }

                    if (field.keyHighlight.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(12.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .background(fieldColor.copy(alpha = 0.1f))
                                .border(1.dp, fieldColor.copy(alpha = 0.25f), RoundedCornerShape(8.dp))
                                .padding(10.dp)
                        ) {
                            Text(
                                text = "💡 Insight: ${field.keyHighlight}",
                                style = MaterialTheme.typography.bodySmall,
                                color = fieldColor,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }
        }
    }
}
