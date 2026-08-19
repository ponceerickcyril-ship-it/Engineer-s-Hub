package com.example.ui.screens

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.SwapVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.components.BlueprintGridBackground
import com.example.ui.components.EngineeringCard
import com.example.ui.components.MathEquationBox
import com.example.ui.components.SectionHeader
import com.example.ui.components.TechBadge
import com.example.ui.theme.BorderDark
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
import java.text.DecimalFormat

enum class UnitCategory(val title: String, val units: List<String>) {
    LENGTH("Length", listOf("Meters (m)", "Millimeters (mm)", "Centimeters (cm)", "Kilometers (km)", "Inches (in)", "Feet (ft)", "Miles (mi)")),
    MASS("Mass", listOf("Kilograms (kg)", "Grams (g)", "Milligrams (mg)", "Pounds (lb)", "Ounces (oz)", "Metric Tons (t)")),
    FORCE("Force", listOf("Newtons (N)", "Kilonewtons (kN)", "Pound-force (lbf)", "Dynes (dyn)", "Kilogram-force (kgf)")),
    PRESSURE("Pressure", listOf("Pascals (Pa)", "Kilopascals (kPa)", "Megapascals (MPa)", "Bar", "PSI (lbf/in²)", "Atmospheres (atm)")),
    ENERGY("Energy & Work", listOf("Joules (J)", "Kilojoules (kJ)", "Megajoules (MJ)", "Calories (cal)", "Kilowatt-hours (kWh)", "BTU", "Foot-pounds (ft-lbf)")),
    POWER("Power", listOf("Watts (W)", "Kilowatts (kW)", "Megawatts (MW)", "Mechanical Horsepower (hp)", "Metric Horsepower (PS)")),
    TEMPERATURE("Temperature", listOf("Celsius (°C)", "Fahrenheit (°F)", "Kelvin (K)"))
}

@Composable
fun UnitConverterScreen(modifier: Modifier = Modifier) {
    var selectedCategory by remember { mutableStateOf(UnitCategory.LENGTH) }
    var fromUnit by remember { mutableStateOf(selectedCategory.units[0]) }
    var toUnit by remember { mutableStateOf(selectedCategory.units[1]) }
    var inputValue by remember { mutableStateOf("1") }

    val df = DecimalFormat("#.######")

    fun convert(value: Double, from: String, to: String, category: UnitCategory): Double {
        if (from == to) return value

        return when (category) {
            UnitCategory.LENGTH -> {
                // Base: meters
                val inMeters = when (from) {
                    "Meters (m)" -> value
                    "Millimeters (mm)" -> value * 0.001
                    "Centimeters (cm)" -> value * 0.01
                    "Kilometers (km)" -> value * 1000.0
                    "Inches (in)" -> value * 0.0254
                    "Feet (ft)" -> value * 0.3048
                    "Miles (mi)" -> value * 1609.344
                    else -> value
                }
                when (to) {
                    "Meters (m)" -> inMeters
                    "Millimeters (mm)" -> inMeters / 0.001
                    "Centimeters (cm)" -> inMeters / 0.01
                    "Kilometers (km)" -> inMeters / 1000.0
                    "Inches (in)" -> inMeters / 0.0254
                    "Feet (ft)" -> inMeters / 0.3048
                    "Miles (mi)" -> inMeters / 1609.344
                    else -> inMeters
                }
            }
            UnitCategory.MASS -> {
                // Base: kg
                val inKg = when (from) {
                    "Kilograms (kg)" -> value
                    "Grams (g)" -> value * 0.001
                    "Milligrams (mg)" -> value * 1e-6
                    "Pounds (lb)" -> value * 0.45359237
                    "Ounces (oz)" -> value * 0.0283495
                    "Metric Tons (t)" -> value * 1000.0
                    else -> value
                }
                when (to) {
                    "Kilograms (kg)" -> inKg
                    "Grams (g)" -> inKg / 0.001
                    "Milligrams (mg)" -> inKg / 1e-6
                    "Pounds (lb)" -> inKg / 0.45359237
                    "Ounces (oz)" -> inKg / 0.0283495
                    "Metric Tons (t)" -> inKg / 1000.0
                    else -> inKg
                }
            }
            UnitCategory.FORCE -> {
                // Base: Newtons
                val inN = when (from) {
                    "Newtons (N)" -> value
                    "Kilonewtons (kN)" -> value * 1000.0
                    "Pound-force (lbf)" -> value * 4.44822
                    "Dynes (dyn)" -> value * 1e-5
                    "Kilogram-force (kgf)" -> value * 9.80665
                    else -> value
                }
                when (to) {
                    "Newtons (N)" -> inN
                    "Kilonewtons (kN)" -> inN / 1000.0
                    "Pound-force (lbf)" -> inN / 4.44822
                    "Dynes (dyn)" -> inN / 1e-5
                    "Kilogram-force (kgf)" -> inN / 9.80665
                    else -> inN
                }
            }
            UnitCategory.PRESSURE -> {
                // Base: Pascals
                val inPa = when (from) {
                    "Pascals (Pa)" -> value
                    "Kilopascals (kPa)" -> value * 1000.0
                    "Megapascals (MPa)" -> value * 1e6
                    "Bar" -> value * 100000.0
                    "PSI (lbf/in²)" -> value * 6894.757
                    "Atmospheres (atm)" -> value * 101325.0
                    else -> value
                }
                when (to) {
                    "Pascals (Pa)" -> inPa
                    "Kilopascals (kPa)" -> inPa / 1000.0
                    "Megapascals (MPa)" -> inPa / 1e6
                    "Bar" -> inPa / 100000.0
                    "PSI (lbf/in²)" -> inPa / 6894.757
                    "Atmospheres (atm)" -> inPa / 101325.0
                    else -> inPa
                }
            }
            UnitCategory.ENERGY -> {
                // Base: Joules
                val inJ = when (from) {
                    "Joules (J)" -> value
                    "Kilojoules (kJ)" -> value * 1000.0
                    "Megajoules (MJ)" -> value * 1e6
                    "Calories (cal)" -> value * 4.184
                    "Kilowatt-hours (kWh)" -> value * 3.6e6
                    "BTU" -> value * 1055.06
                    "Foot-pounds (ft-lbf)" -> value * 1.355818
                    else -> value
                }
                when (to) {
                    "Joules (J)" -> inJ
                    "Kilojoules (kJ)" -> inJ / 1000.0
                    "Megajoules (MJ)" -> inJ / 1e6
                    "Calories (cal)" -> inJ / 4.184
                    "Kilowatt-hours (kWh)" -> inJ / 3.6e6
                    "BTU" -> inJ / 1055.06
                    "Foot-pounds (ft-lbf)" -> inJ / 1.355818
                    else -> inJ
                }
            }
            UnitCategory.POWER -> {
                // Base: Watts
                val inW = when (from) {
                    "Watts (W)" -> value
                    "Kilowatts (kW)" -> value * 1000.0
                    "Megawatts (MW)" -> value * 1e6
                    "Mechanical Horsepower (hp)" -> value * 745.69987
                    "Metric Horsepower (PS)" -> value * 735.49875
                    else -> value
                }
                when (to) {
                    "Watts (W)" -> inW
                    "Kilowatts (kW)" -> inW / 1000.0
                    "Megawatts (MW)" -> inW / 1e6
                    "Mechanical Horsepower (hp)" -> inW / 745.69987
                    "Metric Horsepower (PS)" -> inW / 735.49875
                    else -> inW
                }
            }
            UnitCategory.TEMPERATURE -> {
                when (from) {
                    "Celsius (°C)" -> when (to) {
                        "Fahrenheit (°F)" -> (value * 9.0 / 5.0) + 32.0
                        "Kelvin (K)" -> value + 273.15
                        else -> value
                    }
                    "Fahrenheit (°F)" -> when (to) {
                        "Celsius (°C)" -> (value - 32.0) * 5.0 / 9.0
                        "Kelvin (K)" -> (value - 32.0) * 5.0 / 9.0 + 273.15
                        else -> value
                    }
                    "Kelvin (K)" -> when (to) {
                        "Celsius (°C)" -> value - 273.15
                        "Fahrenheit (°F)" -> (value - 273.15) * 9.0 / 5.0 + 32.0
                        else -> value
                    }
                    else -> value
                }
            }
        }
    }

    val inputNum = inputValue.toDoubleOrNull() ?: 0.0
    val convertedResult = convert(inputNum, fromUnit, toUnit, selectedCategory)

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
                    title = "Engineering Unit Converter",
                    subtitle = "Convert SI, Imperial & technical engineering units with live calculation",
                    icon = Icons.Default.SwapHoriz,
                    badgeText = "7 Disciplines",
                    badgeColor = TechCyan
                )
            }

            // Category Chips
            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(UnitCategory.values()) { category ->
                        val isSelected = selectedCategory == category
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(if (isSelected) TechCyan else SurfaceVariantDark)
                                .border(1.dp, if (isSelected) TechCyan else BorderDark, RoundedCornerShape(8.dp))
                                .clickable {
                                    selectedCategory = category
                                    fromUnit = category.units[0]
                                    toUnit = if (category.units.size > 1) category.units[1] else category.units[0]
                                }
                                .padding(horizontal = 12.dp, vertical = 8.dp)
                        ) {
                            Text(
                                text = category.title,
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                color = if (isSelected) DeepNavy else TextPrimary
                            )
                        }
                    }
                }
            }

            // Converter Card
            item {
                EngineeringCard(
                    borderColor = TechCyan.copy(alpha = 0.5f),
                    backgroundColor = CardBackground
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        // Input value
                        OutlinedTextField(
                            value = inputValue,
                            onValueChange = { inputValue = it },
                            label = { Text("Enter Value to Convert", color = TextSecondary) },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("converter_input"),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = TechCyan,
                                unfocusedBorderColor = BorderDark,
                                focusedContainerColor = SurfaceVariantDark,
                                unfocusedContainerColor = SurfaceVariantDark,
                                focusedTextColor = TextPrimary,
                                unfocusedTextColor = TextPrimary
                            ),
                            shape = RoundedCornerShape(10.dp)
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        // From Unit Dropdown / Selector
                        Text("From Unit", style = MaterialTheme.typography.labelMedium, color = TechCyan)
                        Spacer(modifier = Modifier.height(6.dp))
                        UnitDropdownSelector(
                            selectedUnit = fromUnit,
                            units = selectedCategory.units,
                            onUnitSelected = { fromUnit = it }
                        )

                        // Swap Button
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            IconButton(
                                onClick = {
                                    val temp = fromUnit
                                    fromUnit = toUnit
                                    toUnit = temp
                                },
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .background(TechCyan.copy(alpha = 0.15f))
                                    .border(1.dp, TechCyan, CircleShape)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.SwapVert,
                                    contentDescription = "Swap Units",
                                    tint = TechCyan
                                )
                            }
                        }

                        // To Unit Dropdown / Selector
                        Text("To Unit", style = MaterialTheme.typography.labelMedium, color = SuccessGreen)
                        Spacer(modifier = Modifier.height(6.dp))
                        UnitDropdownSelector(
                            selectedUnit = toUnit,
                            units = selectedCategory.units,
                            onUnitSelected = { toUnit = it }
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        // Output Result Box
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(14.dp))
                                .background(
                                    androidx.compose.ui.graphics.Brush.horizontalGradient(
                                        listOf(SurfaceVariantDark, DeepNavy)
                                    )
                                )
                                .border(1.5.dp, TechCyan, RoundedCornerShape(14.dp))
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "$inputValue $fromUnit =",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = TextSecondary
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "${df.format(convertedResult)} $toUnit",
                                    style = MaterialTheme.typography.headlineMedium,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Monospace,
                                    color = TechCyan
                                )
                            }
                        }
                    }
                }
            }

            // Quick Engineering Multiples reference table
            item {
                EngineeringCard(
                    borderColor = BorderDark,
                    backgroundColor = CardBackground
                ) {
                    Column {
                        Text(
                            text = "SI Engineering Metric Prefixes",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        val prefixes = listOf(
                            Triple("Giga (G)", "10⁹", "1,000,000,000"),
                            Triple("Mega (M)", "10⁶", "1,000,000"),
                            Triple("Kilo (k)", "10³", "1,000"),
                            Triple("Milli (m)", "10⁻³", "0.001"),
                            Triple("Micro (μ)", "10⁻⁶", "0.000001"),
                            Triple("Nano (n)", "10⁻⁹", "0.000000001")
                        )
                        prefixes.forEach { (name, exp, mult) ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = name, style = MaterialTheme.typography.bodyMedium, color = TechCyan)
                                Text(text = exp, fontFamily = FontFamily.Monospace, style = MaterialTheme.typography.bodyMedium, color = TextPrimary)
                                Text(text = mult, fontFamily = FontFamily.Monospace, style = MaterialTheme.typography.bodySmall, color = TextSecondary)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun UnitDropdownSelector(
    selectedUnit: String,
    units: List<String>,
    onUnitSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(SurfaceElevated)
                .border(1.dp, BorderDark, RoundedCornerShape(10.dp))
                .clickable { expanded = true }
                .padding(horizontal = 14.dp, vertical = 12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = selectedUnit,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = TextPrimary
                )
                Text(
                    text = "▼",
                    style = MaterialTheme.typography.labelSmall,
                    color = TechCyan
                )
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(SurfaceElevated)
        ) {
            units.forEach { unit ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = unit,
                            color = if (unit == selectedUnit) TechCyan else TextPrimary,
                            fontWeight = if (unit == selectedUnit) FontWeight.Bold else FontWeight.Normal
                        )
                    },
                    onClick = {
                        onUnitSelected(unit)
                        expanded = false
                    }
                )
            }
        }
    }
}
