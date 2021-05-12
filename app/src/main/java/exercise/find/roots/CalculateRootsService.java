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
    long time = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - timeStartMs);
    System.out.println("timeStartMs: "+ timeStartMs);
    System.out.println("time: "+ time);
    for(int i=2; i < numberToCalculateRootsFor; i++) {
      if (time > 20){
        System.out.println("if");
        intent.putExtra("original_number", numberToCalculateRootsFor);
        intent.putExtra("time_until_give_up_seconds", time);
        sendBroadcast(intent.setAction("stopped_calculations"));
        return;
      }
      else{
        if(numberToCalculateRootsFor%i == 0) {
          System.out.println(i);
          System.out.println(numberToCalculateRootsFor / i);
          System.out.println("else4");
          intent.setAction("found_roots");
          intent.putExtra("original_number", numberToCalculateRootsFor);
          intent.putExtra("root1", i);
          intent.putExtra("root2", (numberToCalculateRootsFor / i));
          long test = intent.getLongExtra("root1", 30);
          System.out.println(test);
          sendBroadcast(intent);
          return;
        }
        else{
          System.out.println("here3");
          time = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - timeStartMs);
        }
      }
    }
    System.out.println("reut");
    intent.putExtra("original_number", numberToCalculateRootsFor);
    intent.putExtra("root1", 1);
    intent.putExtra("root2", numberToCalculateRootsFor);
    sendBroadcast(intent.setAction("found_roots"));
  }
}