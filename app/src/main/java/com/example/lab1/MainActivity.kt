package com.example.lab1

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.photo_entry.view.*

class MainActivity : AppCompatActivity() {

    var adapter: PhotoAdapter? = null
    var photosList = ArrayList<Photo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //load photos
        photosList.add(Photo(R.drawable.banan1))
        photosList.add(Photo(R.drawable.brokul1))
        photosList.add(Photo(R.drawable.brzoskwinia1))
        photosList.add(Photo(R.drawable.gruszka1))
        photosList.add(Photo(R.drawable.jablko1))
        photosList.add(Photo(R.drawable.morela1))
        photosList.add(Photo(R.drawable.ogorek1))
        photosList.add(Photo(R.drawable.pomidor1))
        photosList.add(Photo(R.drawable.pomarancza1))
        photosList.add(Photo(R.drawable.por1))
        photosList.add(Photo(R.drawable.sliwka1))
        photosList.add(Photo(R.drawable.smoothie1))

        adapter = PhotoAdapter(this, photosList)

        gvPhotos.adapter = adapter

    }

    class PhotoAdapter : BaseAdapter {
        var photosList = ArrayList<Photo>()
        var context: Context? = null

        constructor(context: Context, photosList: ArrayList<Photo>) : super() {
            this.context = context
            this.photosList = photosList
        }

        override fun getCount(): Int {
            return photosList.size
        }

        override fun getItem(position: Int): Any {
            return photosList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val photo = this.photosList[position]

            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var photoView = inflator.inflate(R.layout.photo_entry, null)
            photoView.imgPhoto.setOnClickListener{

                val intent = Intent(context, PhotoHorizontal::class.java)
                intent.putExtra("image", photo.image!!)
                context!!.startActivity(intent)
            }

            photoView.imgPhoto.setImageResource(photo.image!!)

            return photoView
        }
    }
}
