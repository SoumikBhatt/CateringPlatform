package com.example.cateringplatform.adapters

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.cateringplatform.R

class HomeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val context: Context? = null
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {

        if (i == VIEW_TYPE_FOOD_TYPE) {
            val foodType = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_food_type, viewGroup, false)
            return FoodTypeHolder(foodType)
        } else if (i == VIEW_TYPE_FEATURE_RESTURANT) {
            val featureResturant = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_feature_resturant, viewGroup, false)
            return FeatureResturantHolder(featureResturant)
        } else {

            val availableResturant = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_available_resturant, viewGroup, false)
            return AvailableResturantHolder(availableResturant)
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, i: Int) {

        val itemType = getItemViewType(i)

        if (itemType == VIEW_TYPE_FOOD_TYPE) {

            val foodTypeHolder = viewHolder as FoodTypeHolder
            val foodTypeAdapter = FoodTypeAdapter()
            foodTypeHolder.foodTypeRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            foodTypeHolder.foodTypeRecycler.adapter = foodTypeAdapter
        } else if (itemType == VIEW_TYPE_FEATURE_RESTURANT) {

            val featureResturantHolder = viewHolder as FeatureResturantHolder
            val featuredResturantAdapter = FeaturedResturantAdapter()
            featureResturantHolder.featureResturantRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            featureResturantHolder.featureResturantRecycler.adapter = featuredResturantAdapter
        } else {

            val availableResturantHolder = viewHolder as AvailableResturantHolder
            val availableResturantAdapter = AvailableResturantAdapter()
            availableResturantHolder.availableResturantRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            availableResturantHolder.availableResturantRecycler.adapter = availableResturantAdapter
        }

    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            VIEW_TYPE_FOOD_TYPE
        } else if (position == 1) {
            VIEW_TYPE_FEATURE_RESTURANT
        } else {
            VIEW_TYPE_AVAILABLE_RESTURANT
        }
    }


    inner class FoodTypeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val foodTypeRecycler: RecyclerView

        init {
            foodTypeRecycler = itemView.findViewById(R.id.rv_food_type)
        }
    }

    inner class FeatureResturantHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val featureResturantRecycler: RecyclerView

        init {
            featureResturantRecycler = itemView.findViewById(R.id.rv_featured_resturant)
        }
    }

    inner class AvailableResturantHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val availableTV: TextView
        val availableResturantRecycler: RecyclerView

        init {
            availableTV = itemView.findViewById(R.id.tv_available_on_date)
            availableResturantRecycler = itemView.findViewById(R.id.rv_available_resturant)
        }
    }

    companion object {

        val VIEW_TYPE_FOOD_TYPE = 0
        val VIEW_TYPE_FEATURE_RESTURANT = 1
        val VIEW_TYPE_AVAILABLE_RESTURANT = 2
    }
}
