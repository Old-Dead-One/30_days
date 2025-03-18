package edu.dixietech.alanmcgraw.thirtydays

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Days(
    @DrawableRes val imageResources: Int,
    @StringRes val dayName: Int,
    @StringRes val quote: Int,
    @StringRes val author: Int,
)

val days = listOf(
    Days(R.drawable.a1, R.string.day_one_name, R.string.day_one_quote, R.string.day_one_author),
    Days(R.drawable.a2, R.string.day_two_name, R.string.day_two_quote, R.string.day_two_author),
    Days(R.drawable.a3, R.string.day_three_name, R.string.day_three_quote, R.string.day_three_author),
    Days(R.drawable.a4, R.string.day_four_name, R.string.day_four_quote, R.string.day_four_author),
    Days(R.drawable.a5, R.string.day_five_name, R.string.day_five_quote, R.string.day_five_author),
    Days(R.drawable.a6, R.string.day_six_name, R.string.day_six_quote, R.string.day_six_author),
    Days(R.drawable.a7, R.string.day_seven_name, R.string.day_seven_quote, R.string.day_seven_author),
    Days(R.drawable.a8, R.string.day_eight_name, R.string.day_eight_quote, R.string.day_eight_author),
    Days(R.drawable.a9, R.string.day_nine_name, R.string.day_nine_quote, R.string.day_nine_author),
    Days(R.drawable.a10, R.string.day_ten_name, R.string.day_ten_quote, R.string.day_ten_author),
    Days(R.drawable.a11, R.string.day_eleven_name, R.string.day_eleven_quote, R.string.day_eleven_author),
    Days(R.drawable.a12, R.string.day_twelve_name, R.string.day_twelve_quote, R.string.day_twelve_author),
    Days(R.drawable.a13, R.string.day_thirteen_name, R.string.day_thirteen_quote, R.string.day_thirteen_author),
    Days(R.drawable.a14, R.string.day_fourteen_name, R.string.day_fourteen_quote, R.string.day_fourteen_author),
    Days(R.drawable.a15, R.string.day_fifteen_name, R.string.day_fifteen_quote, R.string.day_fifteen_author),
    Days(R.drawable.a16, R.string.day_sixteen_name, R.string.day_sixteen_quote, R.string.day_sixteen_author),
    Days(R.drawable.a17, R.string.day_seventeen_name, R.string.day_seventeen_quote, R.string.day_seventeen_author),
    Days(R.drawable.a18, R.string.day_eighteen_name, R.string.day_eighteen_quote, R.string.day_eighteen_author),
    Days(R.drawable.a19, R.string.day_nineteen_name, R.string.day_nineteen_quote, R.string.day_nineteen_author),
    Days(R.drawable.a20, R.string.day_twenty_name, R.string.day_twenty_quote, R.string.day_twenty_author),
    Days(R.drawable.a21, R.string.day_twenty_one_name, R.string.day_twenty_one_quote, R.string.day_twenty_one_author),
    Days(R.drawable.a22, R.string.day_twenty_two_name, R.string.day_twenty_two_quote, R.string.day_twenty_two_author),
    Days(R.drawable.a23, R.string.day_twenty_three_name, R.string.day_twenty_three_quote, R.string.day_twenty_three_author),
    Days(R.drawable.a24, R.string.day_twenty_four_name, R.string.day_twenty_four_quote, R.string.day_twenty_four_author),
    Days(R.drawable.a25, R.string.day_twenty_five_name, R.string.day_twenty_five_quote, R.string.day_twenty_five_author),
    Days(R.drawable.a25, R.string.day_twenty_six_name, R.string.day_twenty_six_quote, R.string.day_twenty_six_author),
    Days(R.drawable.a27, R.string.day_twenty_seven_name, R.string.day_twenty_seven_quote, R.string.day_twenty_seven_author),
    Days(R.drawable.a28, R.string.day_twenty_eight_name, R.string.day_twenty_eight_quote, R.string.day_twenty_eight_author),
    Days(R.drawable.a29, R.string.day_twenty_nine_name, R.string.day_twenty_nine_quote, R.string.day_twenty_nine_author),
    Days(R.drawable.a30, R.string.day_thirty_name, R.string.day_thirty_quote, R.string.day_thirty_author)
)
