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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Functions
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.CalculatorType
import com.example.ui.components.BlueprintGridBackground
import com.example.ui.components.EngineeringCard
import com.example.ui.components.MathEquationBox
import com.example.ui.components.SectionHeader
import com.example.ui.components.StepSolutionBox
import com.example.ui.components.TechBadge
import com.example.ui.theme.BorderDark
import com.example.ui.theme.BorderLight
import com.example.ui.theme.CardBackground
import com.example.ui.theme.DeepNavy
import com.example.ui.theme.ElectricBlue
import com.example.ui.theme.EngineeringOrange
import com.example.ui.theme.ErrorRed
import com.example.ui.theme.SuccessGreen
import com.example.ui.theme.SurfaceElevated
import com.example.ui.theme.SurfaceVariantDark
import com.example.ui.theme.TechCyan
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary
import com.example.ui.theme.TextTertiary
import com.example.ui.theme.WarningYellow
import java.text.DecimalFormat
import kotlin.math.sin

@Composable
fun CalculatorsScreen(
    initialCalculator: CalculatorType = CalculatorType.OHMS_LAW,
    modifier: Modifier = Modifier
) {
    var activeCalculator by remember { mutableStateOf(initialCalculator) }

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
                    title = "Engineering Calculators",
                    subtitle = "Interactive math with step-by-step substitution and unit verification",
                    icon = Icons.Default.Calculate,
                    badgeText = "${CalculatorType.values().size} Solvers",
                    badgeColor = SuccessGreen
                )
            }

            // Calculator Selector Tabs
            item {
                Text(
                    text = "Select Calculator",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                Spacer(modifier = Modifier.height(8.dp))
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(CalculatorType.values()) { calc ->
                        val isSelected = activeCalculator == calc
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .background(if (isSelected) SuccessGreen else SurfaceVariantDark)
                                .border(
                                    1.dp,
                                    if (isSelected) SuccessGreen else BorderDark,
                                    RoundedCornerShape(10.dp)
                                )
                                .clickable { activeCalculator = calc }
                                .padding(horizontal = 12.dp, vertical = 8.dp)
                                .testTag("calc_tab_${calc.name}")
                        ) {
                            Column {
                                Text(
                                    text = calc.title,
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                    color = if (isSelected) DeepNavy else TextPrimary
                                )
                                Text(
                                    text = calc.formulaShort,
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 10.sp,
                                    color = if (isSelected) DeepNavy else TechCyan
                                )
                            }
                        }
                    }
                }
            }

            // Active Calculator View
            item {
                when (activeCalculator) {
                    CalculatorType.OHMS_LAW -> OhmsLawCalculatorView()
                    CalculatorType.FORCE -> ForceCalculatorView()
                    CalculatorType.ELECTRICAL_POWER -> ElectricalPowerCalculatorView()
                    CalculatorType.WORK -> WorkCalculatorView()
                    CalculatorType.POWER -> PowerCalculatorView()
                    CalculatorType.DENSITY -> DensityCalculatorView()
                    CalculatorType.PRESSURE -> PressureCalculatorView()
                    CalculatorType.KINETIC_ENERGY -> KineticEnergyCalculatorView()
                    CalculatorType.POTENTIAL_ENERGY -> PotentialEnergyCalculatorView()
                    CalculatorType.MOMENTUM -> MomentumCalculatorView()
                    CalculatorType.TORQUE -> TorqueCalculatorView()
                    CalculatorType.HEAT_ENERGY -> HeatEnergyCalculatorView()
                    CalculatorType.STRESS_STRAIN -> StressStrainCalculatorView()
                    CalculatorType.FLOW_RATE -> FlowRateCalculatorView()
                }
            }
        }
    }
}

// 1. Ohm's Law Calculator (V = IR)
@Composable
fun OhmsLawCalculatorView() {
    var mode by remember { mutableStateOf("V") } // "V", "I", "R"
    var val1 by remember { mutableStateOf("") }
    var val2 by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf<String?>(null) }
    var steps by remember { mutableStateOf<List<String>>(emptyList()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val df = DecimalFormat("#.####")

    fun calculate() {
        errorMessage = null
        resultText = null
        steps = emptyList()

        val n1 = val1.toDoubleOrNull()
        val n2 = val2.toDoubleOrNull()

        if (n1 == null || n2 == null) {
            errorMessage = "Please enter valid numeric values for both fields."
            return
        }

        when (mode) {
            "V" -> { // Calculate V from I and R
                val v = n1 * n2
                resultText = "Voltage (V) = ${df.format(v)} V"
                steps = listOf(
                    "Formula: V = I × R",
                    "Input Values: Current (I) = $n1 A, Resistance (R) = $n2 Ω",
                    "Substitution: V = ($n1 A) × ($n2 Ω)",
                    "Final Result: V = ${df.format(v)} Volts (V)"
                )
            }
            "I" -> { // Calculate I from V and R
                if (n2 == 0.0) {
                    errorMessage = "Resistance (R) cannot be zero when calculating current (division by zero)."
                    return
                }
                val i = n1 / n2
                resultText = "Current (I) = ${df.format(i)} A"
                steps = listOf(
                    "Formula: I = V / R",
                    "Input Values: Voltage (V) = $n1 V, Resistance (R) = $n2 Ω",
                    "Substitution: I = ($n1 V) / ($n2 Ω)",
                    "Final Result: I = ${df.format(i)} Amperes (A)"
                )
            }
            "R" -> { // Calculate R from V and I
                if (n2 == 0.0) {
                    errorMessage = "Current (I) cannot be zero when calculating resistance (division by zero)."
                    return
                }
                val r = n1 / n2
                resultText = "Resistance (R) = ${df.format(r)} Ω"
                steps = listOf(
                    "Formula: R = V / I",
                    "Input Values: Voltage (V) = $n1 V, Current (I) = $n2 A",
                    "Substitution: R = ($n1 V) / ($n2 A)",
                    "Final Result: R = ${df.format(r)} Ohms (Ω)"
                )
            }
        }
    }

    CalculatorContainer(
        title = "Ohm's Law Calculator",
        formula = "V = I × R",
        category = "Electricity",
        accentColor = TechCyan
    ) {
        // Mode Selector
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ModeSelectButton("Find Voltage (V)", isSelected = mode == "V", color = TechCyan, modifier = Modifier.weight(1f)) {
                mode = "V"; val1 = ""; val2 = ""; resultText = null; errorMessage = null
            }
            ModeSelectButton("Find Current (I)", isSelected = mode == "I", color = TechCyan, modifier = Modifier.weight(1f)) {
                mode = "I"; val1 = ""; val2 = ""; resultText = null; errorMessage = null
            }
            ModeSelectButton("Find Resistance (R)", isSelected = mode == "R", color = TechCyan, modifier = Modifier.weight(1f)) {
                mode = "R"; val1 = ""; val2 = ""; resultText = null; errorMessage = null
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Input Fields
        val (label1, unit1, label2, unit2) = when (mode) {
            "V" -> listOf("Current (I)", "Amperes (A)", "Resistance (R)", "Ohms (Ω)")
            "I" -> listOf("Voltage (V)", "Volts (V)", "Resistance (R)", "Ohms (Ω)")
            else -> listOf("Voltage (V)", "Volts (V)", "Current (I)", "Amperes (A)")
        }

        CalcInputField(
            value = val1,
            onValueChange = { val1 = it },
            label = label1,
            unit = unit1,
            tag = "ohm_input_1"
        )
        Spacer(modifier = Modifier.height(10.dp))
        CalcInputField(
            value = val2,
            onValueChange = { val2 = it },
            label = label2,
            unit = unit2,
            tag = "ohm_input_2"
        )

        Spacer(modifier = Modifier.height(14.dp))

        // Action Buttons
        CalcActionButtons(
            onCalculate = { calculate() },
            onClear = { val1 = ""; val2 = ""; resultText = null; steps = emptyList(); errorMessage = null },
            accentColor = TechCyan
        )

        // Error message
        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(12.dp))
            CalcErrorBox(errorMessage!!)
        }

        // Result and Steps
        if (resultText != null) {
            Spacer(modifier = Modifier.height(14.dp))
            CalcResultBox(result = resultText!!, accentColor = TechCyan)
            Spacer(modifier = Modifier.height(10.dp))
            StepSolutionBox(steps = steps, accentColor = SuccessGreen)
        }
    }
}

// 2. Newton's Force Calculator (F = ma)
@Composable
fun ForceCalculatorView() {
    var mode by remember { mutableStateOf("F") } // "F", "m", "a"
    var val1 by remember { mutableStateOf("") }
    var val2 by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf<String?>(null) }
    var steps by remember { mutableStateOf<List<String>>(emptyList()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val df = DecimalFormat("#.####")

    fun calculate() {
        errorMessage = null
        resultText = null
        steps = emptyList()

        val n1 = val1.toDoubleOrNull()
        val n2 = val2.toDoubleOrNull()

        if (n1 == null || n2 == null) {
            errorMessage = "Please enter valid numeric values for both fields."
            return
        }

        when (mode) {
            "F" -> {
                if (n1 < 0) {
                    errorMessage = "Mass cannot be negative."
                    return
                }
                val f = n1 * n2
                resultText = "Force (F) = ${df.format(f)} N"
                steps = listOf(
                    "Formula: F = m × a",
                    "Input Values: Mass (m) = $n1 kg, Acceleration (a) = $n2 m/s²",
                    "Substitution: F = ($n1 kg) × ($n2 m/s²)",
                    "Final Result: F = ${df.format(f)} Newtons (N)"
                )
            }
            "m" -> {
                if (n2 == 0.0) {
                    errorMessage = "Acceleration cannot be zero when calculating mass."
                    return
                }
                val m = n1 / n2
                if (m < 0) {
                    errorMessage = "Resulting mass cannot be negative."
                    return
                }
                resultText = "Mass (m) = ${df.format(m)} kg"
                steps = listOf(
                    "Formula: m = F / a",
                    "Input Values: Force (F) = $n1 N, Acceleration (a) = $n2 m/s²",
                    "Substitution: m = ($n1 N) / ($n2 m/s²)",
                    "Final Result: m = ${df.format(m)} Kilograms (kg)"
                )
            }
            "a" -> {
                if (n2 <= 0.0) {
                    errorMessage = "Mass (m) must be greater than zero."
                    return
                }
                val a = n1 / n2
                resultText = "Acceleration (a) = ${df.format(a)} m/s²"
                steps = listOf(
                    "Formula: a = F / m",
                    "Input Values: Force (F) = $n1 N, Mass (m) = $n2 kg",
                    "Substitution: a = ($n1 N) / ($n2 kg)",
                    "Final Result: a = ${df.format(a)} m/s²"
                )
            }
        }
    }

    CalculatorContainer(
        title = "Newton's Force Calculator",
        formula = "F = m × a",
        category = "Mechanics",
        accentColor = EngineeringOrange
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ModeSelectButton("Find Force (F)", isSelected = mode == "F", color = EngineeringOrange, modifier = Modifier.weight(1f)) {
                mode = "F"; val1 = ""; val2 = ""; resultText = null; errorMessage = null
            }
            ModeSelectButton("Find Mass (m)", isSelected = mode == "m", color = EngineeringOrange, modifier = Modifier.weight(1f)) {
                mode = "m"; val1 = ""; val2 = ""; resultText = null; errorMessage = null
            }
            ModeSelectButton("Find Accel (a)", isSelected = mode == "a", color = EngineeringOrange, modifier = Modifier.weight(1f)) {
                mode = "a"; val1 = ""; val2 = ""; resultText = null; errorMessage = null
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        val (label1, unit1, label2, unit2) = when (mode) {
            "F" -> listOf("Mass (m)", "Kilograms (kg)", "Acceleration (a)", "m/s²")
            "m" -> listOf("Force (F)", "Newtons (N)", "Acceleration (a)", "m/s²")
            else -> listOf("Force (F)", "Newtons (N)", "Mass (m)", "Kilograms (kg)")
        }

        CalcInputField(val1, { val1 = it }, label1, unit1, "force_input_1")
        Spacer(modifier = Modifier.height(10.dp))
        CalcInputField(val2, { val2 = it }, label2, unit2, "force_input_2")

        Spacer(modifier = Modifier.height(14.dp))
        CalcActionButtons({ calculate() }, { val1 = ""; val2 = ""; resultText = null; steps = emptyList(); errorMessage = null }, EngineeringOrange)

        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(12.dp))
            CalcErrorBox(errorMessage!!)
        }

        if (resultText != null) {
            Spacer(modifier = Modifier.height(14.dp))
            CalcResultBox(resultText!!, EngineeringOrange)
            Spacer(modifier = Modifier.height(10.dp))
            StepSolutionBox(steps = steps, accentColor = SuccessGreen)
        }
    }
}

// 3. Electrical Power Calculator (P = VI)
@Composable
fun ElectricalPowerCalculatorView() {
    var vStr by remember { mutableStateOf("") }
    var iStr by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf<String?>(null) }
    var steps by remember { mutableStateOf<List<String>>(emptyList()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val df = DecimalFormat("#.####")

    fun calculate() {
        val v = vStr.toDoubleOrNull()
        val i = iStr.toDoubleOrNull()

        if (v == null || i == null) {
            errorMessage = "Please enter valid numbers for Voltage and Current."
            resultText = null
            return
        }
        errorMessage = null
        val p = v * i
        val kw = p / 1000.0
        val hp = p / 745.7
        resultText = "Power (P) = ${df.format(p)} W (${df.format(kw)} kW)"
        steps = listOf(
            "Formula: P = V × I",
            "Input Values: Voltage (V) = $v V, Current (I) = $i A",
            "Substitution: P = ($v V) × ($i A)",
            "Result: ${df.format(p)} Watts (W)",
            "Conversions: ${df.format(kw)} kW  |  ${df.format(hp)} Horsepower (hp)"
        )
    }

    CalculatorContainer("Electrical Power Calculator", "P = V × I", "Electricity", TechCyan) {
        CalcInputField(vStr, { vStr = it }, "Voltage (V)", "Volts (V)", "p_v_input")
        Spacer(modifier = Modifier.height(10.dp))
        CalcInputField(iStr, { iStr = it }, "Current (I)", "Amperes (A)", "p_i_input")
        Spacer(modifier = Modifier.height(14.dp))
        CalcActionButtons({ calculate() }, { vStr = ""; iStr = ""; resultText = null; errorMessage = null }, TechCyan)

        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(12.dp))
            CalcErrorBox(errorMessage!!)
        }
        if (resultText != null) {
            Spacer(modifier = Modifier.height(14.dp))
            CalcResultBox(resultText!!, TechCyan)
            Spacer(modifier = Modifier.height(10.dp))
            StepSolutionBox(steps = steps, accentColor = SuccessGreen)
        }
    }
}

// 4. Work Calculator (W = Fd)
@Composable
fun WorkCalculatorView() {
    var fStr by remember { mutableStateOf("") }
    var dStr by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf<String?>(null) }
    var steps by remember { mutableStateOf<List<String>>(emptyList()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val df = DecimalFormat("#.####")

    fun calculate() {
        val f = fStr.toDoubleOrNull()
        val d = dStr.toDoubleOrNull()
        if (f == null || d == null) {
            errorMessage = "Please enter valid numeric values for Force and Distance."
            resultText = null
            return
        }
        errorMessage = null
        val w = f * d
        val kj = w / 1000.0
        resultText = "Work (W) = ${df.format(w)} Joules (J)"
        steps = listOf(
            "Formula: W = F × d",
            "Input Values: Force (F) = $f N, Distance (d) = $d m",
            "Substitution: W = ($f N) × ($d m)",
            "Result: W = ${df.format(w)} Joules (${df.format(kj)} kJ)"
        )
    }

    CalculatorContainer("Mechanical Work Calculator", "W = F × d", "Mechanics", ElectricBlue) {
        CalcInputField(fStr, { fStr = it }, "Applied Force (F)", "Newtons (N)", "work_f_input")
        Spacer(modifier = Modifier.height(10.dp))
        CalcInputField(dStr, { dStr = it }, "Distance / Displacement (d)", "Meters (m)", "work_d_input")
        Spacer(modifier = Modifier.height(14.dp))
        CalcActionButtons({ calculate() }, { fStr = ""; dStr = ""; resultText = null; errorMessage = null }, ElectricBlue)

        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(12.dp))
            CalcErrorBox(errorMessage!!)
        }
        if (resultText != null) {
            Spacer(modifier = Modifier.height(14.dp))
            CalcResultBox(resultText!!, ElectricBlue)
            Spacer(modifier = Modifier.height(10.dp))
            StepSolutionBox(steps = steps, accentColor = SuccessGreen)
        }
    }
}

// 5. Mechanical Power Calculator (P = W/t)
@Composable
fun PowerCalculatorView() {
    var wStr by remember { mutableStateOf("") }
    var tStr by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf<String?>(null) }
    var steps by remember { mutableStateOf<List<String>>(emptyList()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val df = DecimalFormat("#.####")

    fun calculate() {
        val w = wStr.toDoubleOrNull()
        val t = tStr.toDoubleOrNull()
        if (w == null || t == null) {
            errorMessage = "Please enter valid numeric values for Work and Time."
            resultText = null
            return
        }
        if (t <= 0.0) {
            errorMessage = "Time (t) must be greater than zero."
            resultText = null
            return
        }
        errorMessage = null
        val p = w / t
        val hp = p / 745.7
        resultText = "Power (P) = ${df.format(p)} Watts (W)"
        steps = listOf(
            "Formula: P = W / t",
            "Input Values: Work (W) = $w J, Time (t) = $t s",
            "Substitution: P = ($w J) / ($t s)",
            "Result: P = ${df.format(p)} W  |  ${df.format(hp)} Horsepower (hp)"
        )
    }

    CalculatorContainer("Mechanical Power Calculator", "P = W / t", "Mechanics", EngineeringOrange) {
        CalcInputField(wStr, { wStr = it }, "Work Performed (W)", "Joules (J)", "p_w_input")
        Spacer(modifier = Modifier.height(10.dp))
        CalcInputField(tStr, { tStr = it }, "Elapsed Time (t)", "Seconds (s)", "p_t_input")
        Spacer(modifier = Modifier.height(14.dp))
        CalcActionButtons({ calculate() }, { wStr = ""; tStr = ""; resultText = null; errorMessage = null }, EngineeringOrange)

        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(12.dp))
            CalcErrorBox(errorMessage!!)
        }
        if (resultText != null) {
            Spacer(modifier = Modifier.height(14.dp))
            CalcResultBox(resultText!!, EngineeringOrange)
            Spacer(modifier = Modifier.height(10.dp))
            StepSolutionBox(steps = steps, accentColor = SuccessGreen)
        }
    }
}

// 6. Density Calculator (ρ = m/V)
@Composable
fun DensityCalculatorView() {
    var mStr by remember { mutableStateOf("") }
    var vStr by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf<String?>(null) }
    var steps by remember { mutableStateOf<List<String>>(emptyList()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val df = DecimalFormat("#.####")

    fun calculate() {
        val m = mStr.toDoubleOrNull()
        val v = vStr.toDoubleOrNull()
        if (m == null || v == null) {
            errorMessage = "Please enter valid numeric values for Mass and Volume."
            resultText = null
            return
        }
        if (v <= 0.0) {
            errorMessage = "Volume (V) must be greater than zero."
            resultText = null
            return
        }
        if (m < 0.0) {
            errorMessage = "Mass cannot be negative."
            resultText = null
            return
        }
        errorMessage = null
        val rho = m / v
        val gcm3 = rho / 1000.0
        resultText = "Density (ρ) = ${df.format(rho)} kg/m³"
        steps = listOf(
            "Formula: ρ = m / V",
            "Input Values: Mass (m) = $m kg, Volume (V) = $v m³",
            "Substitution: ρ = ($m kg) / ($v m³)",
            "Result: ρ = ${df.format(rho)} kg/m³  (${df.format(gcm3)} g/cm³)"
        )
    }

    CalculatorContainer("Density Calculator", "ρ = m / V", "Materials", SuccessGreen) {
        CalcInputField(mStr, { mStr = it }, "Mass (m)", "Kilograms (kg)", "dens_m_input")
        Spacer(modifier = Modifier.height(10.dp))
        CalcInputField(vStr, { vStr = it }, "Volume (V)", "Cubic Meters (m³)", "dens_v_input")
        Spacer(modifier = Modifier.height(14.dp))
        CalcActionButtons({ calculate() }, { mStr = ""; vStr = ""; resultText = null; errorMessage = null }, SuccessGreen)

        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(12.dp))
            CalcErrorBox(errorMessage!!)
        }
        if (resultText != null) {
            Spacer(modifier = Modifier.height(14.dp))
            CalcResultBox(resultText!!, SuccessGreen)
            Spacer(modifier = Modifier.height(10.dp))
            StepSolutionBox(steps = steps, accentColor = SuccessGreen)
        }
    }
}

// 7. Pressure Calculator (P = F/A)
@Composable
fun PressureCalculatorView() {
    var fStr by remember { mutableStateOf("") }
    var aStr by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf<String?>(null) }
    var steps by remember { mutableStateOf<List<String>>(emptyList()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val df = DecimalFormat("#.####")

    fun calculate() {
        val f = fStr.toDoubleOrNull()
        val a = aStr.toDoubleOrNull()
        if (f == null || a == null) {
            errorMessage = "Please enter valid numeric values for Force and Area."
            resultText = null
            return
        }
        if (a <= 0.0) {
            errorMessage = "Contact Area (A) must be greater than zero."
            resultText = null
            return
        }
        errorMessage = null
        val p = f / a
        val kpa = p / 1000.0
        val bar = p / 100000.0
        val psi = p / 6894.76
        resultText = "Pressure (P) = ${df.format(p)} Pa (${df.format(kpa)} kPa)"
        steps = listOf(
            "Formula: P = F / A",
            "Input Values: Force (F) = $f N, Area (A) = $a m²",
            "Substitution: P = ($f N) / ($a m²)",
            "Result: P = ${df.format(p)} Pascals (Pa)",
            "Equivalents: ${df.format(kpa)} kPa  |  ${df.format(bar)} bar  |  ${df.format(psi)} psi"
        )
    }

    CalculatorContainer("Pressure Calculator", "P = F / A", "Fluids", TechCyan) {
        CalcInputField(fStr, { fStr = it }, "Perpendicular Force (F)", "Newtons (N)", "press_f_input")
        Spacer(modifier = Modifier.height(10.dp))
        CalcInputField(aStr, { aStr = it }, "Contact Surface Area (A)", "Square Meters (m²)", "press_a_input")
        Spacer(modifier = Modifier.height(14.dp))
        CalcActionButtons({ calculate() }, { fStr = ""; aStr = ""; resultText = null; errorMessage = null }, TechCyan)

        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(12.dp))
            CalcErrorBox(errorMessage!!)
        }
        if (resultText != null) {
            Spacer(modifier = Modifier.height(14.dp))
            CalcResultBox(resultText!!, TechCyan)
            Spacer(modifier = Modifier.height(10.dp))
            StepSolutionBox(steps = steps, accentColor = SuccessGreen)
        }
    }
}

// 8. Kinetic Energy Calculator (KE = 1/2 m v²)
@Composable
fun KineticEnergyCalculatorView() {
    var mStr by remember { mutableStateOf("") }
    var vStr by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf<String?>(null) }
    var steps by remember { mutableStateOf<List<String>>(emptyList()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val df = DecimalFormat("#.####")

    fun calculate() {
        val m = mStr.toDoubleOrNull()
        val v = vStr.toDoubleOrNull()
        if (m == null || v == null) {
            errorMessage = "Please enter valid numeric values for Mass and Velocity."
            resultText = null
            return
        }
        if (m < 0.0) {
            errorMessage = "Mass cannot be negative."
            resultText = null
            return
        }
        errorMessage = null
        val ke = 0.5 * m * v * v
        val kj = ke / 1000.0
        resultText = "Kinetic Energy (KE) = ${df.format(ke)} Joules (J)"
        steps = listOf(
            "Formula: KE = ½ × m × v²",
            "Input Values: Mass (m) = $m kg, Velocity (v) = $v m/s",
            "Substitution: KE = 0.5 × ($m kg) × ($v m/s)² = 0.5 × $m × ${v * v}",
            "Result: KE = ${df.format(ke)} Joules (${df.format(kj)} kJ)"
        )
    }

    CalculatorContainer("Kinetic Energy Calculator", "KE = ½ m v²", "Energy", EngineeringOrange) {
        CalcInputField(mStr, { mStr = it }, "Object Mass (m)", "Kilograms (kg)", "ke_m_input")
        Spacer(modifier = Modifier.height(10.dp))
        CalcInputField(vStr, { vStr = it }, "Speed / Velocity (v)", "Meters per second (m/s)", "ke_v_input")
        Spacer(modifier = Modifier.height(14.dp))
        CalcActionButtons({ calculate() }, { mStr = ""; vStr = ""; resultText = null; errorMessage = null }, EngineeringOrange)

        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(12.dp))
            CalcErrorBox(errorMessage!!)
        }
        if (resultText != null) {
            Spacer(modifier = Modifier.height(14.dp))
            CalcResultBox(resultText!!, EngineeringOrange)
            Spacer(modifier = Modifier.height(10.dp))
            StepSolutionBox(steps = steps, accentColor = SuccessGreen)
        }
    }
}

// 9. Potential Energy Calculator (PE = mgh)
@Composable
fun PotentialEnergyCalculatorView() {
    var mStr by remember { mutableStateOf("") }
    var hStr by remember { mutableStateOf("") }
    var gStr by remember { mutableStateOf("9.81") }
    var resultText by remember { mutableStateOf<String?>(null) }
    var steps by remember { mutableStateOf<List<String>>(emptyList()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val df = DecimalFormat("#.####")

    fun calculate() {
        val m = mStr.toDoubleOrNull()
        val h = hStr.toDoubleOrNull()
        val g = gStr.toDoubleOrNull() ?: 9.81
        if (m == null || h == null) {
            errorMessage = "Please enter valid numeric values for Mass and Height."
            resultText = null
            return
        }
        errorMessage = null
        val pe = m * g * h
        val kj = pe / 1000.0
        resultText = "Potential Energy (PE) = ${df.format(pe)} Joules (J)"
        steps = listOf(
            "Formula: PE = m × g × h",
            "Input Values: Mass (m) = $m kg, Height (h) = $h m, Gravity (g) = $g m/s²",
            "Substitution: PE = ($m kg) × ($g m/s²) × ($h m)",
            "Result: PE = ${df.format(pe)} Joules (${df.format(kj)} kJ)"
        )
    }

    CalculatorContainer("Gravitational Potential Energy", "PE = m × g × h", "Energy", ElectricBlue) {
        CalcInputField(mStr, { mStr = it }, "Object Mass (m)", "Kilograms (kg)", "pe_m_input")
        Spacer(modifier = Modifier.height(10.dp))
        CalcInputField(hStr, { hStr = it }, "Height (h)", "Meters (m)", "pe_h_input")
        Spacer(modifier = Modifier.height(10.dp))
        CalcInputField(gStr, { gStr = it }, "Gravity (g)", "m/s² (Default: 9.81)", "pe_g_input")
        Spacer(modifier = Modifier.height(14.dp))
        CalcActionButtons({ calculate() }, { mStr = ""; hStr = ""; gStr = "9.81"; resultText = null; errorMessage = null }, ElectricBlue)

        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(12.dp))
            CalcErrorBox(errorMessage!!)
        }
        if (resultText != null) {
            Spacer(modifier = Modifier.height(14.dp))
            CalcResultBox(resultText!!, ElectricBlue)
            Spacer(modifier = Modifier.height(10.dp))
            StepSolutionBox(steps = steps, accentColor = SuccessGreen)
        }
    }
}

// 10. Momentum Calculator (p = mv)
@Composable
fun MomentumCalculatorView() {
    var mStr by remember { mutableStateOf("") }
    var vStr by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf<String?>(null) }
    var steps by remember { mutableStateOf<List<String>>(emptyList()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val df = DecimalFormat("#.####")

    fun calculate() {
        val m = mStr.toDoubleOrNull()
        val v = vStr.toDoubleOrNull()
        if (m == null || v == null) {
            errorMessage = "Please enter valid numeric values for Mass and Velocity."
            resultText = null
            return
        }
        errorMessage = null
        val p = m * v
        resultText = "Momentum (p) = ${df.format(p)} kg·m/s"
        steps = listOf(
            "Formula: p = m × v",
            "Input Values: Mass (m) = $m kg, Velocity (v) = $v m/s",
            "Substitution: p = ($m kg) × ($v m/s)",
            "Result: p = ${df.format(p)} kg·m/s (or N·s)"
        )
    }

    CalculatorContainer("Linear Momentum Calculator", "p = m × v", "Mechanics", EngineeringOrange) {
        CalcInputField(mStr, { mStr = it }, "Mass (m)", "Kilograms (kg)", "mom_m_input")
        Spacer(modifier = Modifier.height(10.dp))
        CalcInputField(vStr, { vStr = it }, "Velocity (v)", "Meters/sec (m/s)", "mom_v_input")
        Spacer(modifier = Modifier.height(14.dp))
        CalcActionButtons({ calculate() }, { mStr = ""; vStr = ""; resultText = null; errorMessage = null }, EngineeringOrange)

        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(12.dp))
            CalcErrorBox(errorMessage!!)
        }
        if (resultText != null) {
            Spacer(modifier = Modifier.height(14.dp))
            CalcResultBox(resultText!!, EngineeringOrange)
            Spacer(modifier = Modifier.height(10.dp))
            StepSolutionBox(steps = steps, accentColor = SuccessGreen)
        }
    }
}

// 11. Torque Calculator (τ = F r sinθ)
@Composable
fun TorqueCalculatorView() {
    var fStr by remember { mutableStateOf("") }
    var rStr by remember { mutableStateOf("") }
    var thetaStr by remember { mutableStateOf("90") }
    var resultText by remember { mutableStateOf<String?>(null) }
    var steps by remember { mutableStateOf<List<String>>(emptyList()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val df = DecimalFormat("#.####")

    fun calculate() {
        val f = fStr.toDoubleOrNull()
        val r = rStr.toDoubleOrNull()
        val thetaDeg = thetaStr.toDoubleOrNull() ?: 90.0
        if (f == null || r == null) {
            errorMessage = "Please enter valid values for Force and Lever Arm."
            resultText = null
            return
        }
        errorMessage = null
        val thetaRad = Math.toRadians(thetaDeg)
        val sinVal = sin(thetaRad)
        val tau = f * r * sinVal
        resultText = "Torque (τ) = ${df.format(tau)} N·m"
        steps = listOf(
            "Formula: τ = F × r × sin(θ)",
            "Input Values: Force = $f N, Lever Arm = $r m, Angle = $thetaDeg° (sin = ${df.format(sinVal)})",
            "Substitution: τ = ($f N) × ($r m) × ${df.format(sinVal)}",
            "Result: τ = ${df.format(tau)} Newton-meters (N·m)"
        )
    }

    CalculatorContainer("Mechanical Torque Calculator", "τ = F × r × sin(θ)", "Mechanics", TechCyan) {
        CalcInputField(fStr, { fStr = it }, "Applied Force (F)", "Newtons (N)", "torq_f_input")
        Spacer(modifier = Modifier.height(10.dp))
        CalcInputField(rStr, { rStr = it }, "Radial Lever Arm (r)", "Meters (m)", "torq_r_input")
        Spacer(modifier = Modifier.height(10.dp))
        CalcInputField(thetaStr, { thetaStr = it }, "Angle (θ)", "Degrees (°)", "torq_th_input")
        Spacer(modifier = Modifier.height(14.dp))
        CalcActionButtons({ calculate() }, { fStr = ""; rStr = ""; thetaStr = "90"; resultText = null; errorMessage = null }, TechCyan)

        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(12.dp))
            CalcErrorBox(errorMessage!!)
        }
        if (resultText != null) {
            Spacer(modifier = Modifier.height(14.dp))
            CalcResultBox(resultText!!, TechCyan)
            Spacer(modifier = Modifier.height(10.dp))
            StepSolutionBox(steps = steps, accentColor = SuccessGreen)
        }
    }
}

// 12. Heat Energy Calculator (Q = mcΔT)
@Composable
fun HeatEnergyCalculatorView() {
    var mStr by remember { mutableStateOf("") }
    var cStr by remember { mutableStateOf("4184") } // Water default
    var dtStr by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf<String?>(null) }
    var steps by remember { mutableStateOf<List<String>>(emptyList()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val df = DecimalFormat("#.####")

    fun calculate() {
        val m = mStr.toDoubleOrNull()
        val c = cStr.toDoubleOrNull()
        val dt = dtStr.toDoubleOrNull()
        if (m == null || c == null || dt == null) {
            errorMessage = "Please enter valid numeric values for all parameters."
            resultText = null
            return
        }
        errorMessage = null
        val q = m * c * dt
        val kj = q / 1000.0
        resultText = "Heat Energy (Q) = ${df.format(q)} Joules (${df.format(kj)} kJ)"
        steps = listOf(
            "Formula: Q = m × c × ΔT",
            "Input Values: Mass (m) = $m kg, Specific Heat (c) = $c J/(kg·°C), ΔT = $dt °C",
            "Substitution: Q = ($m kg) × ($c J/kg°C) × ($dt °C)",
            "Result: Q = ${df.format(q)} Joules (${df.format(kj)} kJ)"
        )
    }

    CalculatorContainer("Sensible Heat Energy Calculator", "Q = m × c × ΔT", "Thermodynamics", ErrorRed) {
        CalcInputField(mStr, { mStr = it }, "Substance Mass (m)", "Kilograms (kg)", "heat_m_input")
        Spacer(modifier = Modifier.height(10.dp))
        CalcInputField(cStr, { cStr = it }, "Specific Heat Capacity (c)", "J/(kg·°C) [Water = 4184]", "heat_c_input")
        Spacer(modifier = Modifier.height(10.dp))
        CalcInputField(dtStr, { dtStr = it }, "Temperature Change (ΔT)", "°C or Kelvin", "heat_dt_input")
        Spacer(modifier = Modifier.height(14.dp))
        CalcActionButtons({ calculate() }, { mStr = ""; cStr = "4184"; dtStr = ""; resultText = null; errorMessage = null }, ErrorRed)

        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(12.dp))
            CalcErrorBox(errorMessage!!)
        }
        if (resultText != null) {
            Spacer(modifier = Modifier.height(14.dp))
            CalcResultBox(resultText!!, ErrorRed)
            Spacer(modifier = Modifier.height(10.dp))
            StepSolutionBox(steps = steps, accentColor = SuccessGreen)
        }
    }
}

// 13. Stress & Strain Calculator
@Composable
fun StressStrainCalculatorView() {
    var fStr by remember { mutableStateOf("") }
    var aStr by remember { mutableStateOf("") }
    var dlStr by remember { mutableStateOf("") }
    var l0Str by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf<String?>(null) }
    var steps by remember { mutableStateOf<List<String>>(emptyList()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val df = DecimalFormat("#.####")

    fun calculate() {
        val f = fStr.toDoubleOrNull()
        val a = aStr.toDoubleOrNull()
        val dl = dlStr.toDoubleOrNull()
        val l0 = l0Str.toDoubleOrNull()
        if (f == null || a == null) {
            errorMessage = "Please enter Force and Area to calculate Stress."
            resultText = null
            return
        }
        if (a <= 0.0) {
            errorMessage = "Cross-sectional area must be greater than zero."
            resultText = null
            return
        }
        errorMessage = null
        val stressPa = f / a
        val stressMpa = stressPa / 1e6
        val stepList = mutableListOf(
            "Stress Formula: σ = F / A",
            "Stress Substitution: σ = ($f N) / ($a m²) = ${df.format(stressPa)} Pa (${df.format(stressMpa)} MPa)"
        )
        if (dl != null && l0 != null && l0 > 0.0) {
            val strain = dl / l0
            val youngsGpa = (stressPa / strain) / 1e9
            stepList.add("Strain Formula: ε = ΔL / L₀ = ($dl m) / ($l0 m) = ${df.format(strain)}")
            stepList.add("Young's Modulus: E = σ / ε = ${df.format(youngsGpa)} GPa")
            resultText = "Stress (σ) = ${df.format(stressMpa)} MPa  |  Strain (ε) = ${df.format(strain)}"
        } else {
            resultText = "Stress (σ) = ${df.format(stressMpa)} MPa"
        }
        steps = stepList
    }

    CalculatorContainer("Stress & Strain Calculator", "σ = F/A, ε = ΔL/L₀, E = σ/ε", "Materials", SuccessGreen) {
        CalcInputField(fStr, { fStr = it }, "Axial Force (F)", "Newtons (N)", "str_f_input")
        Spacer(modifier = Modifier.height(10.dp))
        CalcInputField(aStr, { aStr = it }, "Cross-Section Area (A)", "Square Meters (m²)", "str_a_input")
        Spacer(modifier = Modifier.height(10.dp))
        CalcInputField(dlStr, { dlStr = it }, "Elongation (ΔL) [Optional]", "Meters (m)", "str_dl_input")
        Spacer(modifier = Modifier.height(10.dp))
        CalcInputField(l0Str, { l0Str = it }, "Original Length (L₀) [Optional]", "Meters (m)", "str_l0_input")
        Spacer(modifier = Modifier.height(14.dp))
        CalcActionButtons({ calculate() }, { fStr = ""; aStr = ""; dlStr = ""; l0Str = ""; resultText = null; errorMessage = null }, SuccessGreen)

        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(12.dp))
            CalcErrorBox(errorMessage!!)
        }
        if (resultText != null) {
            Spacer(modifier = Modifier.height(14.dp))
            CalcResultBox(resultText!!, SuccessGreen)
            Spacer(modifier = Modifier.height(10.dp))
            StepSolutionBox(steps = steps, accentColor = SuccessGreen)
        }
    }
}

// 14. Fluid Flow Rate Calculator (Q = Av)
@Composable
fun FlowRateCalculatorView() {
    var aStr by remember { mutableStateOf("") }
    var vStr by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf<String?>(null) }
    var steps by remember { mutableStateOf<List<String>>(emptyList()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val df = DecimalFormat("#.####")

    fun calculate() {
        val a = aStr.toDoubleOrNull()
        val v = vStr.toDoubleOrNull()
        if (a == null || v == null) {
            errorMessage = "Please enter valid numeric values for Area and Velocity."
            resultText = null
            return
        }
        if (a <= 0.0) {
            errorMessage = "Pipe area must be greater than zero."
            resultText = null
            return
        }
        errorMessage = null
        val q = a * v
        val lps = q * 1000.0
        resultText = "Flow Rate (Q) = ${df.format(q)} m³/s (${df.format(lps)} L/s)"
        steps = listOf(
            "Formula: Q = A × v",
            "Input Values: Pipe Area (A) = $a m², Velocity (v) = $v m/s",
            "Substitution: Q = ($a m²) × ($v m/s)",
            "Result: Q = ${df.format(q)} m³/s (${df.format(lps)} Liters/second)"
        )
    }

    CalculatorContainer("Volumetric Flow Rate", "Q = A × v", "Fluids", TechCyan) {
        CalcInputField(aStr, { aStr = it }, "Pipe Cross-Section Area (A)", "Square Meters (m²)", "flow_a_input")
        Spacer(modifier = Modifier.height(10.dp))
        CalcInputField(vStr, { vStr = it }, "Fluid Velocity (v)", "Meters per second (m/s)", "flow_v_input")
        Spacer(modifier = Modifier.height(14.dp))
        CalcActionButtons({ calculate() }, { aStr = ""; vStr = ""; resultText = null; errorMessage = null }, TechCyan)

        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(12.dp))
            CalcErrorBox(errorMessage!!)
        }
        if (resultText != null) {
            Spacer(modifier = Modifier.height(14.dp))
            CalcResultBox(resultText!!, TechCyan)
            Spacer(modifier = Modifier.height(10.dp))
            StepSolutionBox(steps = steps, accentColor = SuccessGreen)
        }
    }
}

// Common Reusable Calculator Subcomponents
@Composable
fun CalculatorContainer(
    title: String,
    formula: String,
    category: String,
    accentColor: Color,
    content: @Composable () -> Unit
) {
    EngineeringCard(
        borderColor = accentColor.copy(alpha = 0.5f),
        backgroundColor = CardBackground
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                TechBadge(text = category, color = accentColor)
            }
            Spacer(modifier = Modifier.height(10.dp))
            MathEquationBox(equation = formula, accentColor = accentColor)
            Spacer(modifier = Modifier.height(16.dp))
            content()
        }
    }
}

@Composable
fun ModeSelectButton(
    text: String,
    isSelected: Boolean,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(if (isSelected) color else SurfaceVariantDark)
            .border(1.dp, if (isSelected) color else BorderDark, RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp, horizontal = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = if (isSelected) DeepNavy else TextPrimary
        )
    }
}

@Composable
fun CalcInputField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    unit: String,
    tag: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, color = TextSecondary) },
        trailingIcon = {
            Text(
                text = unit,
                style = MaterialTheme.typography.labelSmall,
                color = TechCyan,
                modifier = Modifier.padding(end = 12.dp)
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .testTag(tag),
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
}

@Composable
fun CalcActionButtons(
    onCalculate: () -> Unit,
    onClear: () -> Unit,
    accentColor: Color
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Button(
            onClick = onCalculate,
            colors = ButtonDefaults.buttonColors(containerColor = accentColor),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .weight(2f)
                .testTag("btn_calculate")
        ) {
            Icon(
                imageVector = Icons.Default.Calculate,
                contentDescription = null,
                tint = DeepNavy,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "Calculate & Show Steps",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                color = DeepNavy
            )
        }

        Button(
            onClick = onClear,
            colors = ButtonDefaults.buttonColors(containerColor = SurfaceElevated),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .weight(1f)
                .testTag("btn_clear")
        ) {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = null,
                tint = TextSecondary,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Clear",
                style = MaterialTheme.typography.labelMedium,
                color = TextPrimary
            )
        }
    }
}

@Composable
fun CalcResultBox(result: String, accentColor: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(accentColor.copy(alpha = 0.15f))
            .border(1.5.dp, accentColor, RoundedCornerShape(12.dp))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = result,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            color = accentColor
        )
    }
}

@Composable
fun CalcErrorBox(error: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(ErrorRed.copy(alpha = 0.15f))
            .border(1.dp, ErrorRed, RoundedCornerShape(10.dp))
            .padding(12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Warning,
                contentDescription = null,
                tint = ErrorRed,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = error,
                style = MaterialTheme.typography.bodySmall,
                color = ErrorRed,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
