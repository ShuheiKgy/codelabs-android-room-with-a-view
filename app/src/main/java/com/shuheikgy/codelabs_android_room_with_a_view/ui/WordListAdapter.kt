package com.shuheikgy.codelabs_android_room_with_a_view.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.shuheikgy.codelabs_android_room_with_a_view.R
import com.shuheikgy.codelabs_android_room_with_a_view.entity.Word
import org.w3c.dom.Text

class WordListAdapter(val context: Context) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    private var inflater: LayoutInflater
    private var words: List<Word>? = null

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return words?.count() ?: 0
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.wordItemView?.text = words?.get(position)?.word ?: ""
    }

    fun setWord(words: List<Word>) {
        this.words = words
        notifyDataSetChanged()
    }

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var wordItemView: TextView?
        init {
            wordItemView = itemView.findViewById(R.id.textView) as? TextView
        }
    }

}