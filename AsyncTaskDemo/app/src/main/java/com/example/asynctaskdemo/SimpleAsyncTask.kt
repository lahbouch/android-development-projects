package com.example.asynctaskdemo

import android.os.AsyncTask
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import java.lang.ref.WeakReference

class SimpleAsyncTask(tv : TextView,pb : ProgressBar) : AsyncTask<Unit,Integer,String?>() {
    val pb : WeakReference<ProgressBar> = WeakReference(pb)
    val tv : WeakReference<TextView> = WeakReference(tv)
    override fun doInBackground(vararg params: Unit?): String? {
        val delay : Int = (0..11).shuffled().first() * 200
        try {
            Thread.sleep(delay.toLong() / 2)
            publishProgress(Integer(20))
            Thread.sleep(delay.toLong() / 4)
            publishProgress(Integer(40))
            Thread.sleep(delay.toLong() / 6)
            publishProgress(Integer(60))
            Thread.sleep(delay.toLong() / 8)
            publishProgress(Integer(80))
            Thread.sleep(delay.toLong() / 10)
            publishProgress(Integer(100))

//            cancel(true)
        }catch (e : InterruptedException){
            Log.e("TAG", "doInBackground: ${e.message}" )
        }

        return "Awake at last after sleeping for  $delay  milliseconds!";
    }

    override fun onPreExecute() {
        super.onPreExecute()
        pb.get()?.progress = 0
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        tv.get()?.text = result
    }

    override fun onProgressUpdate(vararg values: Integer?) {
        super.onProgressUpdate(*values)
        pb.get()?.visibility = View.VISIBLE
        pb.get()?.progress = values.get(0)?.toInt() ?: 0
    }

//    override fun onCancelled() {
//        super.onCancelled()
//        tv.get()?.text = "Canclled"
//    }




}