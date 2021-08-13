package com.example.tshlib

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_learn.*
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.coroutines.awaitString
import com.github.kittinunf.fuel.coroutines.awaitStringResponse
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.coroutines.runBlocking
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.util.*

class LearnFragment: Fragment(R.layout.fragment_learn) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sectionTitles: List<Int> = listOf(R.string.section1, R.string.section2, R.string.section3, R.string.section4)
        val quickTips: List<Int> = listOf(R.string.q_t_waste, R.string.q_t_food, R.string.q_t_transport, R.string.q_t_energy)

        val dummyArticles: MutableList<MutableList<Article>> = mutableListOf()

        for(stringId in sectionTitles) {
            dummyArticles.add(getArticles(getString(stringId).toLowerCase(Locale.ROOT)))

        }

        val sectionAdapter = PagerAdapter(dummyArticles, quickTips)
        learn_viewpager_sections.adapter = sectionAdapter

        TabLayoutMediator(learn_section_tabs, learn_viewpager_sections) { tab, position ->
            tab.setText(sectionTitles[position])
        }.attach()

    }

    private fun getArticles(sectionTag: String): MutableList<Article> {
        val articles = mutableListOf<Article>()
        FuelManager.instance.basePath = "https://cactus-backend.herokuapp.com/"
        runBlocking {
            val (_, _, result) = Fuel.get("/tags/"+sectionTag).awaitStringResponse()
            Log.d("result", result)
            val jsonObject = JSONTokener(result).nextValue() as JSONObject
            val articleList = jsonObject.getJSONArray("articles")
            Log.d("article_list", articleList.toString())
            for (i in 0 until articleList.length()) {
                val id: Int = articleList.getJSONObject(i).getInt("id")
                val title: String = articleList.getJSONObject(i).getString("title")
                val image: String = articleList.getJSONObject(i).getString("image")
                val link: String = articleList.getJSONObject(i).getString("link")
                articles.add(Article(id, title, image, link, sectionTag))
            }
            Log.d("articles", articles.toString())
        }
        return articles
    }

}

