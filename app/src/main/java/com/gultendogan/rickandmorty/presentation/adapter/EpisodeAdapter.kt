package com.gultendogan.rickandmorty.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gultendogan.rickandmorty.databinding.EpisodeRowLayoutBinding
import com.gultendogan.rickandmorty.domain.uimodel.EpisodeUIModel

class EpisodeAdapter() :
    PagingDataAdapter<EpisodeUIModel, EpisodeAdapter.EpisodeViewHolder>(DiffUtilCallBack()) {
    class EpisodeViewHolder(var binding: EpisodeRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val view = EpisodeRowLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return EpisodeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val currentEpisode = getItem(position)!!
        val hb = holder.binding
        val mContext = hb.root.context

        hb.tvRowEpisode.text = currentEpisode.episode
        hb.tvRowName.text = currentEpisode.name
        hb.tvRowAirDate.text = currentEpisode.airDate
    }

    class DiffUtilCallBack : DiffUtil.ItemCallback<EpisodeUIModel>() {
        override fun areItemsTheSame(
            oldItem: EpisodeUIModel,
            newItem: EpisodeUIModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: EpisodeUIModel,
            newItem: EpisodeUIModel
        ): Boolean {
            return oldItem == newItem
        }

    }
}