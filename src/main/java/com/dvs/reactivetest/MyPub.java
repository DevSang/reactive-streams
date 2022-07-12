package com.dvs.reactivetest;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.Arrays;

public class MyPub implements Publisher<Integer> {

  Iterable<Integer> its = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

  public void subscribe(Subscriber<? super Integer> s) {
    System.out.println("구독자 : 구독할게");
    System.out.println("신문사 : 구독 정보 만들어줄게 기다려");
    MySubscription subscription = new MySubscription(s, its);
    System.out.println("신문사 : 구독 정보 생성 완료");
    s.onSubscribe(subscription);
  }
}
