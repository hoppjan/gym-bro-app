package de.janhopp.gymbro.model.exercise

import kotlin.time.DurationUnit

data class Duration(
    val time: Int,
    val unit: DurationUnit,
)
