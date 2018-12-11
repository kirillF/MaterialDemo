package com.github.kirillf.materialdemo.cards

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.github.kirillf.materialdemo.R

import java.util.ArrayList

/**
 * Created by k.filimonov on 11/04/2017.
 */

class CardsAdapter : RecyclerView.Adapter<CardsAdapter.CardViewHolder>() {

    private val cards: MutableList<Card>

    init {
        cards = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_item_view, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val (title, message) = cards[position]
        holder.title.text = title
        holder.message.text = message
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    fun addCards(items: List<Card>) {
        cards.addAll(items)
    }

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: TextView = itemView.findViewById<View>(R.id.card_title) as TextView
        var message: TextView = itemView.findViewById<View>(R.id.card_message) as TextView

    }

}
