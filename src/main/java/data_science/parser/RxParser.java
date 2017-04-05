package data_science.parser;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

import java.util.concurrent.ExecutorService;

/**
 * Parses data.
 * @author I.A
 */
public final class RxParser implements Runnable {
  /**
   * The emitter to dispatch results and events to.
   */
  private final ObservableEmitter<String> emitter;

  /**
   * Creates a new {@link RxParser}.
   */
  private RxParser(ObservableEmitter<String> emitter) {
    this.emitter = emitter;
  }

  /**
   * A factory method to produce an {@link Observable} that asynchronously computes
   * a result on the given {@link ExecutorService}.
   */
  public static Observable<String> async(ExecutorService service) {
    return Observable.create(emitter -> service.submit(new RxParser(emitter)));
  }

  @Override
  public void run() {
    try {
      // TODO
      emitter.onNext("Test");
    } catch (Exception e) {
      emitter.onError(e);
    }
  }
}
