package dev.acuon.walkthrough

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import dev.acuon.walkthrough.databinding.ActivityMainBinding
import io.akndmr.ugly_tooltip.TooltipBuilder
import io.akndmr.ugly_tooltip.TooltipContentPosition
import io.akndmr.ugly_tooltip.TooltipDialog
import io.akndmr.ugly_tooltip.TooltipObject

class MainActivity : AppCompatActivity() {
    private var tooltipDialog: TooltipDialog? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        initUglyTooltip()
        startUglyTooltips()
    }

    private fun initUglyTooltip() {
        tooltipDialog = TooltipBuilder()
            .setPackageName(packageName)
            .titleTextColorRes(R.color.white)
            .textColorRes(R.color.white)
            .shadowColorRes(R.color.transparent) // Overlay canvas color
            .titleTextSizeRes(R.dimen._16sp)
            .textSizeRes(R.dimen._16sp)
            .spacingRes(R.dimen._5sp)
            .backgroundContentColorRes(R.color.semi_transparent) // Tooltip background color
//            .circleIndicatorBackgroundDrawableRes(drawable.selector_circle)
            .prevString(R.string.back)
            .nextString(R.string.next) // Optional nextStringRes or nextStringText
//            .finishString(finishStringText = "Finish")
            .useCircleIndicator(false)
            .clickable(false) // Click anywhere to continue
            .useArrow(true) // Optional tooltip pointing arrow
            .useSkipWord(false) // Optional tooltip skip option
            .setFragmentManager(this.supportFragmentManager)
            .lineColorRes(R.color.black) // Optional tooltip button seperator line color
            .lineWidthRes(R.dimen._2dp) // Optional tooltip button seperator line width
            .shouldShowIcons(false) // Optional tooltip next/prev icons
            .setTooltipRadius(R.dimen._10dp) //Optional tooltip corder radius
            .showSpotlight(true) //Optional spotlight
            .build()
    }

    private fun startUglyTooltips() {
        binding.apply {
            val tooltips: ArrayList<TooltipObject> = ArrayList()

            tooltips.add(
                TooltipObject(
                    cardViewUserIcon,
                    null,
                    "Change your settings\n\nCheck your accomplishments and app activity\n\nSee your entries in the self reflection journal\n\nSee pages and chapters that you bookmarked or set as favourite"
                )
            )

            tooltips.add(
                TooltipObject(
                    assistantChatMessage,
                    null,
                    "Start a chatbot conversation\n\n\nMore than 150 answers waiting for you in the app library. Learn anytime, anywhere.",
                )
            )

            tooltips.add(
                TooltipObject(
                    layoutLearningBites,
                    null,
                    "\nCheck the next recommended steps\n\n",
                    tooltipContentPosition = TooltipContentPosition.BOTTOM
                )
            )

            tooltips.add(
                TooltipObject(
                    layoutContinueLearning,
                    null,
                    "\nContinue where you left off\n\n",
                    tooltipContentPosition = TooltipContentPosition.BOTTOM
                )
            )

            tooltips.add(
                TooltipObject(
                    layoutAlreadyCompleted,
                    null,
                    "\nRefresh your knowledge, see your \naccomplishments\n",
                    tooltipContentPosition = TooltipContentPosition.BOTTOM
                )
            )

            tooltips.add(
                TooltipObject(
                    findViewById(R.id.library),
                    null,
                    "\nCheck library which also includes\nadditional learning materials\n",
//                    tooltipContentPosition = TooltipContentPosition.UNDEFINED,
//                    tintBackgroundColor = ResourcesCompat.getColor(resources, R.color.blue, null),
//                    null
                )
            )

            tooltips.add(
                TooltipObject(
                    findViewById(R.id.search),
                    null,
                    "\nSearch the app for topics you are most\ninterested in\n"
                )
            )

            tooltips.add(
                TooltipObject(
                    findViewById(R.id.notification),
                    null,
                    "\nCheck for latest notifications, check what’s\nnew\n"
                )
            )

            tooltipDialog?.show(this@MainActivity, supportFragmentManager, "SHOWCASE_TAG", tooltips)
        }

    }
}
