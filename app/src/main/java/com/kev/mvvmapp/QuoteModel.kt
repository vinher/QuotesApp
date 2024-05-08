package com.kev.mvvmapp

import com.kev.mvvmapp.model.QuoteModel

class QuoteModels {
    companion object{
        fun randomQuote():QuoteModel{
            val position = (0..9).random()
            return quote[position]
        }


        private val quote = listOf<QuoteModel>(
            QuoteModel(
                "It’s not a bug. It’s an undocumented feature!",
                "Anonymous"
            ),
            QuoteModel(
                "“Software Developer” – An organism that turns caffeine into software",
                "Anonymous"
            ),
            QuoteModel(
                "If debugging is the process of removing software bugs, then programming must be the process of putting them in",
                "Edsger Dijkstra"
            ),
            QuoteModel(
                "A user interface is like a joke. If you have to explain it, it’s not that good.",
                "Anonymous"
            ),
            QuoteModel(
                "I don’t care if it works on your machine! We are not shipping your machine!",
                "Vidiu Platon"
            ),
            QuoteModel(
                "Measuring programming progress by lines of code is like measuring aircraft building progress by weight.",
                "Bill Gates"
            ),
            QuoteModel(
                "My code DOESN’T work, I have no idea why. My code WORKS, I have no idea why.",
                "Anonymous"
            ),
            QuoteModel("Things aren’t always #000000 and #FFFFFF", "Anonymous"),
            QuoteModel("Talk is cheap. Show me the code.", "Linus Torvalds"),
            QuoteModel(
                "Software and cathedrals are much the same — first we build them, then we pray.",
                "Anonymous"
            ),

            )

    }




}