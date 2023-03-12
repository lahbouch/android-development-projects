package com.example.whowroteit

import android.os.AsyncTask
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.asynctaskloaderdemo.R
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.lang.ref.WeakReference


class FetchBook(mTitleText : TextView ,  mAuteurText : TextView,mThumbnailImg : ImageView) : AsyncTask<String,Unit,String>() {

    private val mTitleText : WeakReference<TextView> = WeakReference(mTitleText)
    private val mAuteurText : WeakReference<TextView> = WeakReference(mAuteurText)
    private val mThumbnailImg : WeakReference<ImageView> = WeakReference(mThumbnailImg)
    private val  DEFAULT_THUMBNAIL = "https://www.icarda.org/sites/default/files/styles/d02/public/feeds/publications/HPbzT4h0.png?itok=cUpFPYMT"

    override fun doInBackground(vararg params: String?): String? {
        Log.e("TAG", "doInBackground: ${params.get(0)}")
        return NetworkUtils.getBookInfo(params.get(0))
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        try {
            val jsonRes = JSONObject(result)
            val books : JSONArray = jsonRes.getJSONArray("items")

            var i = 0

            var title : String? = null
            var auteurs : String? = null
            var thumbnail : String? = null

            while (i < books.length() && (title == null && auteurs == null) ){
                val book = books.getJSONObject(i)
                val volumeInfo = book.getJSONObject("volumeInfo")

                try {

                    title = volumeInfo.getString("title")
                    auteurs = volumeInfo.getString("authors")
                    if (volumeInfo.has("imageLinks")){
                        thumbnail = volumeInfo.getJSONObject("imageLinks").getString("thumbnail")
                    }else{
                        thumbnail = DEFAULT_THUMBNAIL
                    }
                    Log.e("TAG", "thumbnail: ${thumbnail}")
                }catch (e : JSONException){
                    Log.e("TAG", "onPostExecute: ${e.message}" )
                }
                i++
            }

            if (title != null && auteurs != null) {
                mTitleText.get()?.text = (title);
                mTitleText.get()?.visibility = View.VISIBLE
                mAuteurText.get()?.text = auteurs;
                mAuteurText.get()?.visibility = View.VISIBLE;
                Picasso.get().load(thumbnail)
                    .networkPolicy(NetworkPolicy.NO_CACHE,NetworkPolicy.NO_STORE)
                    .into(mThumbnailImg.get())
                mThumbnailImg.get()?.visibility = View.VISIBLE
            }else{
                mTitleText.get()?.setText(R.string.no_result)
                mAuteurText.get()?.text = ""
                mThumbnailImg.get()?.visibility = View.GONE
            }

        } catch (e: JSONException) {
            Log.e("TAG", "onPostExecute: ${e.message}", )
            mTitleText.get()?.setText(R.string.no_result)
            mAuteurText.get()?.text = ""
            mThumbnailImg.get()?.visibility = View.GONE
        }
    }
}