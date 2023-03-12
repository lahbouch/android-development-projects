package com.example.whowroteit

import android.net.Uri
import android.util.Log
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class NetworkUtils {
    companion object{
         val LOG_TAG = NetworkUtils::class.java.simpleName

        // Base URL for Books API.
        private const val BOOK_BASE_URL = "https://www.googleapis.com/books/v1/volumes?"

        // Parameter for the search string.
        private const val QUERY_PARAM = "q"

        // Parameter that limits search results.
        private const val MAX_RESULTS = "maxResults"

        // Parameter to filter by print type.
        private const val PRINT_TYPE = "printType"
        private const val GET_METHOD = "GET"
        private const val POST_METHOD = "POST"


        fun getBookInfo(q : String?) : String?{
            var urlConnection: HttpURLConnection? = null
            var reader: BufferedReader? = null
            var bookJSONString: String? = null
            var inputStream : InputStream? = null
            var stringBuilder : java.lang.StringBuilder? = null
            try {
                val builtUri : Uri = Uri.parse(BOOK_BASE_URL).buildUpon()
                    .appendQueryParameter(QUERY_PARAM,q)
                    .appendQueryParameter(MAX_RESULTS,"10")
                    .appendQueryParameter(PRINT_TYPE,"books")
                    .build()

                val requestUrl : URL = URL(builtUri.toString())

                urlConnection = requestUrl.openConnection() as HttpURLConnection

                urlConnection.requestMethod = GET_METHOD

                urlConnection.connect()

                inputStream = urlConnection.inputStream

                reader = BufferedReader(InputStreamReader(inputStream))

                stringBuilder = java.lang.StringBuilder()

                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    stringBuilder.append(line)
                    stringBuilder.append("\n")
                }

                if (stringBuilder.isEmpty()) {
                    return null;
                }

                bookJSONString = stringBuilder.toString()

                Log.d(LOG_TAG, "getBookInfo: $bookJSONString")

                return bookJSONString;
            }catch (e :IOException){
                Log.e(LOG_TAG, "getBookInfo: ${e.message}")
            }
            finally {
                if (urlConnection != null){
                    urlConnection.disconnect()
                }

                if (reader != null){
                   try {
                       reader.close()
                   }catch (e: IOException){
                       Log.d(LOG_TAG, "getBookInfo: ${e.message}")
                   }
                }
            }

            return null
        }
    }
}