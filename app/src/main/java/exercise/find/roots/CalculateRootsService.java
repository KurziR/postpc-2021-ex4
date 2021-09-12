package exercise.find.roots;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class CalculateRootsService extends IntentService {


  public CalculateRootsService() {
    super("CalculateRootsService");
  }

  @Override
  protected void onHandleIntent(Intent intent) {
    if (intent == null) return;
    long timeStartMs = System.currentTimeMillis();
    long numberToCalculateRootsFor = intent.getLongExtra("number_for_service", 0);
    if (numberToCalculateRootsFor <= 0) {
      Log.e("CalculateRootsService", "can't calculate roots for non-positive input" + numberToCalculateRootsFor);
      return;
    }
    Intent rootIntent = new Intent();
    long time = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - timeStartMs);
    for(int i=2; i < numberToCalculateRootsFor; i++) {
      if (time > 20){
        rootIntent.setAction("stopped_calculations");
        rootIntent.putExtra("original_number", numberToCalculateRootsFor);
        rootIntent.putExtra("time_until_give_up_seconds", time);
        sendBroadcast(rootIntent);
        return;
      }
      else{
        if(numberToCalculateRootsFor%i == 0) {
          long root1 = i;
          long root2 = (numberToCalculateRootsFor / i);
          rootIntent.setAction("found_roots");
          rootIntent.putExtra("original_number", numberToCalculateRootsFor);
          rootIntent.putExtra("root1", root1);
          rootIntent.putExtra("root2", root2);
          sendBroadcast(rootIntent);
          return;
        }
        else{
          time = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - timeStartMs);
        }
      }
    }
    rootIntent.setAction("found_roots");
    rootIntent.putExtra("original_number", numberToCalculateRootsFor);
    rootIntent.putExtra("root1", 1);
    rootIntent.putExtra("root2", numberToCalculateRootsFor);
    sendBroadcast(rootIntent);
  }
}
