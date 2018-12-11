package com.github.kirillf.materialdemo.cards

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.github.kirillf.materialdemo.R

import java.util.ArrayList

/**
 * Created by k.filimonov on 11/04/2017.
 */

class CardsFragment : Fragment() {

    private var cardsRecycler: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.cards_fragment_layout, container, false)
        cardsRecycler = view.findViewById<View>(R.id.cards_recycler) as RecyclerView
        cardsRecycler!!.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        val adapter = CardsAdapter()
        cardsRecycler!!.adapter = adapter
        adapter.addCards(createCards())
        adapter.notifyDataSetChanged()
        return view
    }

    private fun createCards(): List<Card> {
        val cards = ArrayList<Card>()
        for (i in 0..9) {
            val card = Card("Title $i", "Message $i")
            cards.add(card)
        }
        return cards
    }
}
