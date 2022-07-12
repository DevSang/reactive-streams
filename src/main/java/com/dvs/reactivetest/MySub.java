package com.dvs.reactivetest;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MySub implements Subscriber<Integer> {

  private Subscription s;
  private int bufferSize = 3;

  @Override
  public void onSubscribe(Subscription s) {
    System.out.println("구독자 : 구독 정보 받았어");
    this.s = s;
    System.out.println("구독자 : 신문 한개씩 줘");
    s.request(3); //신문 한개 받을게
  }

  @Override
  public void onNext(Integer t) {
    System.out.println(t + "받았엉");
    bufferSize--;
    if(bufferSize == 0) {
      System.out.println("...다음날...");
      bufferSize = 3;
      s.request(bufferSize); //백프레셔
    }
  }

  @Override
  public void onError(Throwable t) {
    System.out.println("구독 중");
  }

  @Override
  public void onComplete() {
    System.out.println("구독완료");
  }
}
