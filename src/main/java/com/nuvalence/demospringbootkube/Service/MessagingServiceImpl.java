package com.nuvalence.demospringbootkube.Service;

import com.example.grpc.MessagingRequest;
import com.example.grpc.MessagingResponse;
import com.example.grpc.HeartBeatRequest;
import com.example.grpc.HeartBeatResponse;
import com.example.grpc.MessagingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.logging.Level;

@GrpcService
public class MessagingServiceImpl extends MessagingServiceGrpc.MessagingServiceImplBase {

    @Override
    public void message(MessagingRequest request, StreamObserver<MessagingResponse> responseObserver) {
        String message = request.getMessage();
        MessagingResponse greetingResponse = MessagingResponse.newBuilder()
                .setMessage("Server - message received: " + message)
                .build();

        responseObserver.onNext(greetingResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void messageStream(MessagingRequest request, StreamObserver<MessagingResponse> responseObserver){
        for(int i = 0; i < 10; i++){
            try{
                Thread.sleep(1000);
                MessagingResponse greetingResponse = MessagingResponse.newBuilder()
                        .setMessage("heartbeat: " + i)
                        .build();
                responseObserver.onNext(greetingResponse);
            }catch (Exception e){}
        }
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<HeartBeatRequest> recordStream(final StreamObserver<HeartBeatResponse> responseObserver){
        return new StreamObserver<HeartBeatRequest>(){
          int hearBeatCount;

          @Override
          public void onNext(HeartBeatRequest hb){
              hearBeatCount += hb.getCount();
          }

          @Override
          public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted(){
                  responseObserver.onNext(HeartBeatResponse.newBuilder().setCount(hearBeatCount).build()); //this is the response action
                  responseObserver.onCompleted();
            }

        };
    }
}