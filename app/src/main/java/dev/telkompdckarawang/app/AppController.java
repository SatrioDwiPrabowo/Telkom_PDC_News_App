package dev.telkompdckarawang.app;
/* Created By : SatrioDwiPrabowo
*/

import android.app.Application;
import android.text.TextUtils;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
public class AppController extends Application {

	//Happy fucking code is here !
	//All connection here and i very angry
	//Why controller data still connected fuckyou !
	// // FIXME: 13/04/16 ASAP URGENT
	//  Sirah lieur hate teu puguh rasa wkwk :'3
	//Need molor again !
	public static final String TAG = AppController.class.getSimpleName();

	private RequestQueue mRequestQueue;

	private static AppController mInstance;

	@Override
	public void onCreate() {
		super.onCreate();
		mInstance = this;
	}

	public static synchronized AppController getInstance() {
		return mInstance;
	}

	public RequestQueue getRequestQueue() {
		if (mRequestQueue == null) {
			mRequestQueue = Volley.newRequestQueue(getApplicationContext());
		}

		return mRequestQueue;
	}

	public <TAG> void addToRequestQueue(Request<TAG> req, String tag) {
		req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
		getRequestQueue().add(req);
	}

	public <TAG> void addToRequestQueue(Request<TAG> req) {
		req.setTag(TAG);
		getRequestQueue().add(req);
	}

	public void cancelPendingRequests(Object tag) {
		if (mRequestQueue != null) {
			mRequestQueue.cancelAll(tag);
		}
	}
}